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


public class AdjStereo {
  public int[]   pre = new int[Const.PACKETBLOBS];
  public int[]   post = new int[Const.PACKETBLOBS];
  public float[] kHz = new float[Const.PACKETBLOBS];
  public float[] lowpasskHz = new float[Const.PACKETBLOBS];

  public AdjStereo(
      int[]   pre ,
      int[]   post ,
      float[] kHz ,
      float[] lowpasskHz
      ){
    this.pre = pre;
    this.post = post;
    this.kHz = kHz;
    this.lowpasskHz = lowpasskHz;

  }
}