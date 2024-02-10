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


public class PrivateState {

  /* local lookup storage */
  public EnvelopeLookUp enveLook; /* envelope lookup */
  public int[] window = new int[2];
  public Mdct[][] transform; /* block, type */
  public DrftLookup[] fftLook = { new DrftLookup(), new DrftLookup()};

  public int modeBits;
//    vorbis_look_floor     **flr;
  Object[] flr;
  LookResidue[] residue;
  PsyLook[] psy;
  public LookPsyGlobal psyGlobLook;

  /* local storage, only used on the encoding side.  This way the
     application does not need to worry about freeing some packets'
     memory and not others'; packet storage is always tracked.
     Cleared next call to a _dsp_ function */
  byte[] header;
  byte[] header1;
  byte[] header2;

  public BitrateManagerState bms;

  long sample_count;

  public PrivateState() {
    this.transform = new Mdct[2][];
    this.enveLook = new EnvelopeLookUp();
    this.psyGlobLook = new LookPsyGlobal();
    this.bms = new BitrateManagerState();
  }

}