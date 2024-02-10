/*
 * THIS FILE IS PART OF THE OggVorbis SOFTWARE CODEC SOURCE CODE.
 * USE, DISTRIBUTION AND REPRODUCTION OF THIS LIBRARY SOURCE IS
 * GOVERNED BY A BSD-STYLE SOURCE LICENSE INCLUDED WITH THIS SOURCE
 * IN 'COPYING'. PLEASE READ THESE TERMS BEFORE DISTRIBUTING.
 *
 * THE OggVorbis SOURCE CODE IS (C) COPYRIGHT 1994-2002
 * by the XIPHOPHORUS Company http://www.xiph.org/
 */

package biniu.ogg;

/**
 * Ogg Stream</p>
 *
 * @author Zbigniew Sudnik
 * @version 1.1.0j 2005-05-01 07:00:00
 */
public class Packet {

    public byte[] packetByte;
//    public int packet;
    public int bytes;
    public int b_o_s;
    public int e_o_s;

    public long granulePos;

    /**
     * sequence number for decode; the framing
     * knows where there's a hole in the data,
     * but we need coupling so that the codec
     * (which is in a seperate abstraction
     * layer) also knows about the gap
     */
    public long packetNo;
}
