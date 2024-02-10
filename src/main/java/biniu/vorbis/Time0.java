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

class Time0 extends FuncTime{
  void pack(Object i, Buffer opb){}
  Object unpack(Info vi , Buffer opb){return "";}
  Object look(DspState vd, InfoMode mi, Object i){return "";}
  void free_info(Object i){}
  void free_look(Object i){}
  int forward(Block vb, Object i){return 0;}
  int inverse(Block vb, Object i, float[] in, float[] out){return 0;}
}
