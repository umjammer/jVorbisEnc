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


public interface Const {


  public static final int PACKETBLOBS = 15;
  public static final int CHUNKSIZE=8500;
  public static final int SEEK_SET=0;
  public static final int SEEK_CUR=1;
  public static final int SEEK_END=2;

  public static final int OV_FALSE=-1;
  public static final int OV_EOF=-2;
  public static final int OV_HOLE=-3;

  public static final int OV_EREAD=-128;
  public static final int OV_EFAULT=-129;
  public static final int OV_EIMPL=-130;
  public static final int OV_EINVAL=-131;
  public static final int OV_ENOTVORBIS=-132;
  public static final int OV_EBADHEADER=-133;
  public static final int OV_EVERSION=-134;
  public static final int OV_ENOTAUDIO=-135;
  public static final int OV_EBADPACKET=-136;
  public static final int OV_EBADLINK=-137;
  public static final int OV_ENOSEEK=-138;

}