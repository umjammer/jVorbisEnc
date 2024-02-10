package biniu.vorbis;
/********************************************************************
 *                                                                  *
 * THIS FILE IS PART OF THE OggVorbis SOFTWARE CODEC SOURCE CODE.   *
 * USE, DISTRIBUTION AND REPRODUCTION OF THIS LIBRARY SOURCE IS     *
 * GOVERNED BY A BSD-STYLE SOURCE LICENSE INCLUDED WITH THIS SOURCE *
 * IN 'COPYING'. PLEASE READ THESE TERMS BEFORE DISTRIBUTING.       *
 *                                                                  *
 * THE OggVorbis SOURCE CODE IS (C) COPYRIGHT 1994-2002             *
 * by the XIPHOPHORUS Company http://www.xiph.org/                  *
 *                                                                  *
 ********************************************************************
 * <p>Title: EncoderVorbis</p>
 * <p>Description: Codec for encoding music files (wav -> ogg) </p>
 * @author Zbigniew Sudnik
 * @version 1.1.0j
 * function:
 * last mod: 2005-05-01 07:00:00
 ********************************************************************/

import biniu.ogg.*;

public class Info {
  private static final int OV_EBADPACKET = -136;
  private static final int OV_ENOTAUDIO = -135;

  private static byte[] _vorbis = "vorbis".getBytes();
  private static final int VI_TIMEB = 1;
  private static final int VI_FLOORB = 2;
  private static final int VI_RESB = 3;
  private static final int VI_MAPB = 1;
  private static final int VI_WINDOWB = 1;

  public int version;
  public int channels;
  public int rate;

  // The below bitrate declarations are *hints*.
  // Combinations of the three values carry the following implications:
  //
  // all three set to the same value:
  // implies a fixed rate bitstream
  // only nominal set:
  // implies a VBR stream that averages the nominal bitrate.  No hard
  // upper/lower limit
  // upper and or lower set:
  // implies a VBR bitstream that obeys the bitrate limits. nominal
  // may also be set to give a nominal rate.
  // none set:
  //  the coder does not care to speculate.

  int bitrate_upper;
  int bitrate_nominal;
  int bitrate_lower;
  int bitrate_window;

  // Vorbis supports only short and long blocks, but allows the
  // encoder to choose the sizes

  private CodecSetupInfo codecSetup;

  int[] blocksizes = new int[2];

  // modes are the primary means of supporting on-the-fly different
  // blocksizes, different channel mappings (LR or mid-side),
  // different residue backends, etc.  Each mode consists of a
  // blocksize flag and a mapping (along with the mapping setup

  int modes;
  int maps;
  int times;
  int floors;
  int residues;
  int books;
  int psys; // encode only

  InfoMode[] mode_param = null;

  int[] map_type = null;
  Object[] map_param = null;

  int[] time_type = null;
  Object[] time_param = null;

  int[] floor_type = null;
  Object[] floor_param = null;

  int[] residue_type = null;
  LookResidue[] residue_param = null;

  StaticCodeBook[] book_param = null;

  CodeBook[] fullbooks;

  InfoPsyGlobal psy_g_param;

  BitrateManagerInfo bi;
  HighlevelEncodeSetup hi; /* used only by vorbisenc.c.  It's a
       highly redundant structure, but
       improves clarity of program flow. */
  int halfrate_flag; /* painless downsample for decode */

  PsyInfo[] psy_param = new PsyInfo[64]; // encode only

  // for block long/sort tuning; encode only
  int envelopesa;
  float preecho_thresh;
  float preecho_clamp;

  public Info(){
  }
  // used by synthesis, which has a full, alloced vi
  public void init() {
    rate = 0;
    this.codecSetup = new CodecSetupInfo();
  }

  public LookPsyGlobal getLookPsyGlobal() {

    InfoPsyGlobal gi = codecSetup.psyGlobParam;
    LookPsyGlobal look = new LookPsyGlobal();

    look.channels = this.channels;

    look.ampmax = -9999.f;
    look.gi = gi;
    return (look);
  }

  public void clear() {
    for (int i = 0; i < modes; i++) {
      mode_param[i] = null;
    }
    mode_param = null;

    for (int i = 0; i < maps; i++) { // unpack does the range checking
      FuncMapping.mapping_P[map_type[i]].clear(map_param[i]);
    }
    map_param = null;

    for (int i = 0; i < times; i++) { // unpack does the range checking
      FuncTime.time_P[time_type[i]].free_info(time_param[i]);
    }
    time_param = null;

    for (int i = 0; i < floors; i++) { // unpack does the range checking
      FuncFloor.floor_P[floor_type[i]].clear(floor_param[i]);
    }
    floor_param = null;

    for (int i = 0; i < residues; i++) { // unpack does the range checking
      FuncResidue.residue_P[residue_type[i]].clear(residue_param[i]);
    }
    residue_param = null;

    // the static codebooks *are* freed if you call info_clear, because
    // decode side does alloc a 'static' codebook. Calling clear on the
    // full codebook does not clear the static codebook (that's our
    // responsibility)
    for (int i = 0; i < books; i++) {
      // just in case the decoder pre-cleared to save space
      if (book_param[i] != null) {
        book_param[i].clear();
        book_param[i] = null;
      }
    }
    book_param = null;

    for (int i = 0; i < psys; i++) {
      psy_param[i].free();
    }
  }

  // Header packing/unpacking
  int unpack_info(Buffer opb) {

    version = opb.read(32);
    if (version != 0)
      return ( -1);

    channels = opb.read(8);
    rate = opb.read(32);

    bitrate_upper = opb.read(32);
    bitrate_nominal = opb.read(32);
    bitrate_lower = opb.read(32);

    codecSetup.blocksizes[0] = 1 << opb.read(4);
    codecSetup.blocksizes[1] = 1 << opb.read(4);

    if ( (rate < 1) ||
        (channels < 1) ||
        (codecSetup.blocksizes[0] < 8) ||
        (codecSetup.blocksizes[1] < blocksizes[0]) ||
        (opb.read(1) != 1)) {
      clear();
      return ( -1);
    }
    return (0);
  }

   public boolean packBooks(Buffer opb) {

    if (codecSetup == null)
      return (false);

    // preamble
    opb.write(0x05, 8);
    opb.write(_vorbis);
    // books
    opb.write(codecSetup.books - 1, 8);
    for (int i = 0; i < codecSetup.books; i++) {
      if (codecSetup.bookParam[i].pack(opb) != 0) {
        return (false);
      }
    }

    // times; hook placeholders
    opb.write(0, 6);
    opb.write(0, 16);

   // floors
    opb.write(codecSetup.floors - 1, 6);
    for (int i = 0; i < codecSetup.floors; i++) {
      opb.write(codecSetup.floorType[i], 16);
//	      if (FuncFloor.floor_P[codecSetup.floor_type[i]].pack) {
      if (codecSetup.floorType[i] != 0) {
        FuncFloor.floor_P[codecSetup.floorType[i]].pack(codecSetup.floorParam[i],
            opb);
      } else {
        return (false);
      }
    }

    /* residues */
    opb.write(codecSetup.residues - 1, 6);
    for (int i = 0; i < codecSetup.residues; i++) {
      opb.write(codecSetup.residueType[i], 16);
      FuncResidue.residue_P[codecSetup.residueType[i]].pack(codecSetup.
          residueParam[i], opb);
    }

    /* maps */
    opb.write(codecSetup.maps - 1, 6);
    for (int i = 0; i < codecSetup.maps; i++) {
      opb.write(codecSetup.mapType[i], 16);
      FuncMapping.mapping_P[codecSetup.mapType[i]].pack(this,
          codecSetup.mapParam[i], opb);
    }

    /* modes */
    opb.write(codecSetup.modes - 1, 6);
    for (int i = 0; i < codecSetup.modes; i++) {
      opb.write(codecSetup.modeParam[i].blockflag, 1);
      opb.write(codecSetup.modeParam[i].windowtype, 16);
      opb.write(codecSetup.modeParam[i].transformtype, 16);
      opb.write(codecSetup.modeParam[i].mapping, 8);
    }
    opb.write(1, 1);

    return (true);
  }

  // pack side
  public boolean packInfo(Buffer opb) {
    if (codecSetup == null)
      return (false);

    // preamble
    opb.write(0x01, 8);
    opb.write(_vorbis);

    // basic information about the stream
    opb.write(0x00, 32);
    opb.write(this.channels, 8);
    opb.write(this.rate, 32);

    opb.write(this.bitrate_upper, 32);
    opb.write(this.bitrate_nominal, 32);
    opb.write(this.bitrate_lower, 32);

    opb.write(ilog2(codecSetup.blocksizes[0]), 4);
    opb.write(ilog2(codecSetup.blocksizes[1]), 4);
    opb.write(1, 1);
    return (true);
  }

  public CodecSetupInfo getCodecSetup() {
    return this.codecSetup;
  }

  private static int ilog2(int v) {
    int ret = 0;
    while (v > 1) {
      ret++;
      v >>>= 1;
    }
    return (ret);
  }

  public String toString() {
    return "version:" + new Integer(version) +
        ", channels:" + new Integer(channels) +
        ", rate:" + new Integer(rate) +
        ", bitrate:" + new Integer(bitrate_upper) + "," +
        new Integer(bitrate_nominal) + "," +
        new Integer(bitrate_lower);
  }
}