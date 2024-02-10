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

public interface EnvelopeInt {

  public static final int VE_PRE  =  16;
  public static final int  VE_WIN  =  4;
  public static final int  VE_POST  = 2;
  public static final int  VE_AMP   = (VE_PRE+VE_POST-1);

  public static final float M_PI = 3.1415926536f;

  public static final int  VE_BANDS = 7;
  public static final int  VE_NEARDC= 15;

  public static final int  VE_MINSTRETCH = 2;   // a bit less than short block
  public static final int  VE_MAXSTRETCH = 12;  // one-third full block


}
