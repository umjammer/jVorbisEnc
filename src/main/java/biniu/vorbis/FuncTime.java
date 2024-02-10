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

abstract class FuncTime{
  public static FuncTime[] time_P={new Time0()};

  abstract void pack(Object i, Buffer opb);
  abstract Object unpack(Info vi , Buffer opb);
  abstract Object look(DspState vd, InfoMode vm, Object i);
  abstract void free_info(Object i);
  abstract void free_look(Object i);
  abstract int forward(Block vb, Object i);
  abstract int inverse(Block vb, Object i, float[] in, float[] out);
}