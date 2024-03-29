/*
 * THIS FILE IS PART OF THE OggVorbis SOFTWARE CODEC SOURCE CODE.
 * USE, DISTRIBUTION AND REPRODUCTION OF THIS LIBRARY SOURCE IS
 * GOVERNED BY A BSD-STYLE SOURCE LICENSE INCLUDED WITH THIS SOURCE
 * IN 'COPYING'. PLEASE READ THESE TERMS BEFORE DISTRIBUTING.
 *
 * THE OggVorbis SOURCE CODE IS (C) COPYRIGHT 1994-2002
 * by the XIPHOPHORUS Company http://www.xiph.org/
 */

package biniu.vorbis.books.coupled;

import biniu.vorbis.EncodeAuxThreshMatch;
import biniu.vorbis.StaticCodeBook;

/**
 * EncoderVorbis</p>
 * <p>Description: Codec for encoding music files (wav -> ogg) </p>
 * @author Zbigniew Sudnik
 * @version 1.1.0j 2005-05-01 07:00:00
 */
public class ResBooksStereo44c6s {

    private static final int[] _huff_lengthlist__44c6_s_long = {
            3, 8, 11, 13, 14, 14, 13, 13, 16, 14, 6, 3, 4, 7, 9, 9,
            10, 11, 14, 13, 10, 4, 3, 5, 7, 7, 9, 10, 13, 15, 12, 7,
            4, 4, 6, 6, 8, 10, 13, 15, 12, 8, 6, 6, 6, 6, 8, 10,
            13, 14, 11, 9, 7, 6, 6, 6, 7, 8, 12, 11, 13, 10, 9, 8,
            7, 6, 6, 7, 11, 11, 13, 11, 10, 9, 9, 7, 7, 6, 10, 11,
            13, 13, 13, 13, 13, 11, 9, 8, 10, 12, 12, 15, 15, 16, 15, 12,
            11, 10, 10, 12,
    };

    public static StaticCodeBook _huff_book__44c6_s_long = new StaticCodeBook(
            2, 100,
            _huff_lengthlist__44c6_s_long,
            0, 0, 0, 0, 0,
            null,
            null,
            null,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p1_0 = {
            1,
            0,
            2,
    };

    private static final int[] _vq_lengthlist__44c6_s_p1_0 = {
            1, 5, 5, 0, 5, 5, 0, 5, 5, 5, 8, 7, 0, 9, 9, 0,
            9, 8, 5, 7, 8, 0, 9, 9, 0, 8, 9, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 5, 9, 8, 0, 8, 8, 0, 8, 8, 5, 8, 9,
            0, 8, 8, 0, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5,
            9, 9, 0, 8, 8, 0, 8, 8, 5, 9, 9, 0, 8, 8, 0, 8,
            8,
    };

    private static final float[] _vq_quantthresh__44c6_s_p1_0 = {
            -0.5f, 0.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p1_0 = {
            1, 0, 2,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p1_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p1_0,
            _vq_quantmap__44c6_s_p1_0,
            3,
            3
    );

    public static StaticCodeBook _44c6_s_p1_0 = new StaticCodeBook(
            4, 81,
            _vq_lengthlist__44c6_s_p1_0,
            1, -535822336, 1611661312, 2, 0,
            _vq_quantlist__44c6_s_p1_0,
            null,
            _vq_auxt__44c6_s_p1_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p2_0 = {
            2,
            1,
            3,
            0,
            4,
    };

    private static final int[] _vq_lengthlist__44c6_s_p2_0 = {
            3, 5, 5, 8, 8, 0, 5, 5, 8, 8, 0, 5, 5, 8, 8, 0,
            7, 7, 9, 9, 0, 0, 0, 9, 9, 5, 7, 7, 9, 9, 0, 8,
            8, 10, 10, 0, 8, 7, 10, 9, 0, 10, 10, 11, 11, 0, 0, 0,
            11, 11, 5, 7, 7, 9, 9, 0, 8, 8, 10, 10, 0, 7, 8, 9,
            10, 0, 10, 10, 11, 11, 0, 0, 0, 11, 11, 8, 9, 9, 11, 11,
            0, 11, 11, 12, 12, 0, 11, 10, 12, 12, 0, 13, 14, 14, 14, 0,
            0, 0, 14, 13, 8, 9, 9, 11, 11, 0, 11, 11, 12, 12, 0, 10,
            11, 12, 12, 0, 14, 13, 14, 14, 0, 0, 0, 13, 14, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 5, 8, 7, 11, 10, 0, 7, 7, 10, 10,
            0, 7, 7, 10, 10, 0, 9, 9, 11, 10, 0, 0, 0, 11, 11, 5,
            7, 8, 10, 11, 0, 7, 7, 10, 10, 0, 7, 7, 10, 10, 0, 9,
            9, 10, 11, 0, 0, 0, 11, 11, 8, 10, 9, 12, 12, 0, 10, 10,
            12, 12, 0, 10, 10, 12, 12, 0, 12, 12, 13, 13, 0, 0, 0, 13,
            13, 8, 9, 10, 12, 12, 0, 10, 10, 11, 12, 0, 10, 10, 12, 12,
            0, 12, 12, 13, 13, 0, 0, 0, 13, 13, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 5, 8, 8, 11, 11, 0, 7, 7, 10, 10, 0, 7, 7,
            10, 10, 0, 9, 9, 10, 11, 0, 0, 0, 11, 10, 5, 8, 8, 11,
            11, 0, 7, 7, 10, 10, 0, 7, 7, 10, 10, 0, 9, 9, 11, 11,
            0, 0, 0, 10, 11, 8, 10, 10, 12, 12, 0, 10, 10, 12, 12, 0,
            10, 10, 12, 12, 0, 12, 13, 13, 13, 0, 0, 0, 14, 13, 8, 10,
            10, 12, 12, 0, 10, 10, 12, 12, 0, 10, 10, 12, 12, 0, 13, 12,
            13, 13, 0, 0, 0, 13, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            7, 10, 10, 14, 13, 0, 9, 9, 13, 12, 0, 9, 9, 12, 12, 0,
            10, 10, 12, 12, 0, 0, 0, 12, 12, 7, 10, 10, 13, 14, 0, 9,
            9, 12, 13, 0, 9, 9, 12, 12, 0, 10, 10, 12, 12, 0, 0, 0,
            12, 12, 9, 11, 11, 14, 13, 0, 11, 10, 14, 13, 0, 11, 11, 13,
            13, 0, 12, 12, 13, 13, 0, 0, 0, 13, 13, 9, 11, 11, 13, 14,
            0, 10, 11, 13, 14, 0, 11, 11, 13, 13, 0, 12, 12, 13, 13, 0,
            0, 0, 13, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9,
            11, 11, 14, 14, 0, 11, 11, 13, 13, 0, 11, 10, 13, 13, 0, 12,
            12, 13, 13, 0, 0, 0, 13, 13, 9, 11, 11, 14, 14, 0, 11, 11,
            13, 13, 0, 10, 11, 13, 13, 0, 12, 12, 14, 13, 0, 0, 0, 13,
            13,
    };

    private static final float[] _vq_quantthresh__44c6_s_p2_0 = {
            -1.5f, -0.5f, 0.5f, 1.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p2_0 = {
            3, 1, 0, 2, 4,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p2_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p2_0,
            _vq_quantmap__44c6_s_p2_0,
            5,
            5
    );

    public static StaticCodeBook _44c6_s_p2_0 = new StaticCodeBook(
            4, 625,
            _vq_lengthlist__44c6_s_p2_0,
            1, -533725184, 1611661312, 3, 0,
            _vq_quantlist__44c6_s_p2_0,
            null,
            _vq_auxt__44c6_s_p2_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p3_0 = {
            4,
            3,
            5,
            2,
            6,
            1,
            7,
            0,
            8,
    };

    private static final int[] _vq_lengthlist__44c6_s_p3_0 = {
            2, 3, 4, 6, 6, 7, 7, 9, 9, 0, 4, 4, 6, 6, 7, 7,
            9, 10, 0, 4, 4, 6, 6, 7, 7, 10, 9, 0, 5, 5, 7, 7,
            8, 8, 10, 10, 0, 0, 0, 7, 6, 8, 8, 10, 10, 0, 0, 0,
            7, 7, 9, 9, 11, 11, 0, 0, 0, 7, 7, 9, 9, 11, 11, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0,
    };

    private static final float[] _vq_quantthresh__44c6_s_p3_0 = {
            -3.5f, -2.5f, -1.5f, -0.5f, 0.5f, 1.5f, 2.5f, 3.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p3_0 = {
            7, 5, 3, 1, 0, 2, 4, 6,
            8,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p3_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p3_0,
            _vq_quantmap__44c6_s_p3_0,
            9,
            9
    );

    public static StaticCodeBook _44c6_s_p3_0 = new StaticCodeBook(
            2, 81,
            _vq_lengthlist__44c6_s_p3_0,
            1, -531628032, 1611661312, 4, 0,
            _vq_quantlist__44c6_s_p3_0,
            null,
            _vq_auxt__44c6_s_p3_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p4_0 = {
            8,
            7,
            9,
            6,
            10,
            5,
            11,
            4,
            12,
            3,
            13,
            2,
            14,
            1,
            15,
            0,
            16,
    };

    private static final int[] _vq_lengthlist__44c6_s_p4_0 = {
            2, 4, 4, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10,
            10, 0, 4, 4, 6, 6, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10,
            11, 11, 0, 4, 4, 6, 6, 8, 8, 9, 9, 9, 9, 10, 10, 10,
            10, 11, 11, 0, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 10, 10,
            11, 11, 11, 11, 0, 0, 0, 7, 7, 8, 8, 9, 9, 9, 9, 10,
            10, 11, 11, 11, 11, 0, 0, 0, 7, 7, 9, 9, 10, 10, 10, 10,
            11, 11, 11, 11, 12, 12, 0, 0, 0, 7, 7, 9, 9, 10, 10, 10,
            10, 11, 11, 11, 11, 12, 12, 0, 0, 0, 7, 7, 8, 8, 9, 9,
            10, 10, 11, 11, 12, 12, 12, 12, 0, 0, 0, 0, 0, 8, 8, 9,
            9, 10, 10, 11, 11, 12, 12, 12, 12, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0,
    };

    private static final float[] _vq_quantthresh__44c6_s_p4_0 = {
            -7.5f, -6.5f, -5.5f, -4.5f, -3.5f, -2.5f, -1.5f, -0.5f,
            0.5f, 1.5f, 2.5f, 3.5f, 4.5f, 5.5f, 6.5f, 7.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p4_0 = {
            15, 13, 11, 9, 7, 5, 3, 1,
            0, 2, 4, 6, 8, 10, 12, 14,
            16,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p4_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p4_0,
            _vq_quantmap__44c6_s_p4_0,
            17,
            17
    );

    public static StaticCodeBook _44c6_s_p4_0 = new StaticCodeBook(
            2, 289,
            _vq_lengthlist__44c6_s_p4_0,
            1, -529530880, 1611661312, 5, 0,
            _vq_quantlist__44c6_s_p4_0,
            null,
            _vq_auxt__44c6_s_p4_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p5_0 = {
            1,
            0,
            2,
    };

    private static final int[] _vq_lengthlist__44c6_s_p5_0 = {
            1, 4, 4, 5, 7, 7, 6, 7, 7, 4, 6, 6, 9, 9, 10, 10,
            10, 9, 4, 6, 6, 9, 10, 9, 10, 9, 10, 6, 9, 9, 10, 12,
            11, 10, 11, 11, 7, 10, 9, 11, 12, 12, 12, 12, 12, 7, 10, 10,
            11, 12, 12, 12, 12, 12, 6, 10, 10, 10, 12, 12, 11, 12, 12, 7,
            9, 10, 11, 12, 12, 12, 12, 12, 7, 10, 9, 12, 12, 12, 12, 12,
            12,
    };

    private static final float[] _vq_quantthresh__44c6_s_p5_0 = {
            -5.5f, 5.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p5_0 = {
            1, 0, 2,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p5_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p5_0,
            _vq_quantmap__44c6_s_p5_0,
            3,
            3
    );

    public static StaticCodeBook _44c6_s_p5_0 = new StaticCodeBook(
            4, 81,
            _vq_lengthlist__44c6_s_p5_0,
            1, -529137664, 1618345984, 2, 0,
            _vq_quantlist__44c6_s_p5_0,
            null,
            _vq_auxt__44c6_s_p5_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p5_1 = {
            5,
            4,
            6,
            3,
            7,
            2,
            8,
            1,
            9,
            0,
            10,
    };

    private static final int[] _vq_lengthlist__44c6_s_p5_1 = {
            3, 5, 4, 6, 6, 7, 7, 8, 8, 8, 8, 11, 4, 4, 6, 6,
            7, 7, 8, 8, 8, 8, 11, 4, 4, 6, 6, 7, 7, 8, 8, 8,
            8, 11, 6, 6, 6, 6, 8, 8, 8, 8, 9, 9, 11, 11, 11, 6,
            6, 7, 8, 8, 8, 8, 9, 11, 11, 11, 7, 7, 8, 8, 8, 8,
            8, 8, 11, 11, 11, 7, 7, 8, 8, 8, 8, 8, 8, 11, 11, 11,
            8, 8, 8, 8, 8, 8, 8, 8, 11, 11, 11, 10, 10, 8, 8, 8,
            8, 8, 8, 11, 11, 11, 10, 10, 8, 8, 8, 8, 8, 8, 11, 11,
            11, 10, 10, 7, 7, 8, 8, 8, 8,
    };

    private static final float[] _vq_quantthresh__44c6_s_p5_1 = {
            -4.5f, -3.5f, -2.5f, -1.5f, -0.5f, 0.5f, 1.5f, 2.5f,
            3.5f, 4.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p5_1 = {
            9, 7, 5, 3, 1, 0, 2, 4,
            6, 8, 10,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p5_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p5_1,
            _vq_quantmap__44c6_s_p5_1,
            11,
            11
    );

    public static StaticCodeBook _44c6_s_p5_1 = new StaticCodeBook(
            2, 121,
            _vq_lengthlist__44c6_s_p5_1,
            1, -531365888, 1611661312, 4, 0,
            _vq_quantlist__44c6_s_p5_1,
            null,
            _vq_auxt__44c6_s_p5_1,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p6_0 = {
            6,
            5,
            7,
            4,
            8,
            3,
            9,
            2,
            10,
            1,
            11,
            0,
            12,
    };

    private static final int[] _vq_lengthlist__44c6_s_p6_0 = {
            1, 4, 4, 6, 6, 8, 8, 8, 8, 10, 9, 10, 10, 6, 5, 5,
            7, 7, 9, 9, 9, 9, 10, 10, 11, 11, 6, 5, 5, 7, 7, 9,
            9, 10, 9, 11, 10, 11, 11, 0, 6, 6, 7, 7, 9, 9, 10, 10,
            11, 11, 12, 12, 0, 7, 7, 7, 7, 9, 9, 10, 10, 11, 11, 12,
            12, 0, 11, 11, 8, 8, 10, 10, 11, 11, 12, 12, 12, 12, 0, 11,
            12, 9, 8, 10, 10, 11, 11, 12, 12, 13, 13, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
    };

    private static final float[] _vq_quantthresh__44c6_s_p6_0 = {
            -27.5f, -22.5f, -17.5f, -12.5f, -7.5f, -2.5f, 2.5f, 7.5f,
            12.5f, 17.5f, 22.5f, 27.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p6_0 = {
            11, 9, 7, 5, 3, 1, 0, 2,
            4, 6, 8, 10, 12,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p6_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p6_0,
            _vq_quantmap__44c6_s_p6_0,
            13,
            13
    );

    public static StaticCodeBook _44c6_s_p6_0 = new StaticCodeBook(
            2, 169,
            _vq_lengthlist__44c6_s_p6_0,
            1, -526516224, 1616117760, 4, 0,
            _vq_quantlist__44c6_s_p6_0,
            null,
            _vq_auxt__44c6_s_p6_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p6_1 = {
            2,
            1,
            3,
            0,
            4,
    };

    private static final int[] _vq_lengthlist__44c6_s_p6_1 = {
            3, 4, 4, 5, 5, 5, 4, 4, 5, 5, 5, 4, 4, 5, 5, 6,
            5, 5, 5, 5, 6, 6, 6, 5, 5,
    };

    private static final float[] _vq_quantthresh__44c6_s_p6_1 = {
            -1.5f, -0.5f, 0.5f, 1.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p6_1 = {
            3, 1, 0, 2, 4,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p6_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p6_1,
            _vq_quantmap__44c6_s_p6_1,
            5,
            5
    );

    public static StaticCodeBook _44c6_s_p6_1 = new StaticCodeBook(
            2, 25,
            _vq_lengthlist__44c6_s_p6_1,
            1, -533725184, 1611661312, 3, 0,
            _vq_quantlist__44c6_s_p6_1,
            null,
            _vq_auxt__44c6_s_p6_1,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p7_0 = {
            6,
            5,
            7,
            4,
            8,
            3,
            9,
            2,
            10,
            1,
            11,
            0,
            12,
    };

    private static final int[] _vq_lengthlist__44c6_s_p7_0 = {
            1, 4, 4, 6, 6, 8, 8, 8, 8, 10, 10, 11, 10, 6, 5, 5,
            7, 7, 8, 8, 9, 9, 10, 10, 12, 11, 6, 5, 5, 7, 7, 8,
            8, 9, 9, 10, 10, 12, 11, 21, 7, 7, 7, 7, 9, 9, 10, 10,
            11, 11, 12, 12, 21, 7, 7, 7, 7, 9, 9, 10, 10, 11, 11, 12,
            12, 21, 12, 12, 9, 9, 10, 10, 11, 11, 11, 11, 12, 12, 21, 12,
            12, 9, 9, 10, 10, 11, 11, 12, 12, 12, 12, 21, 21, 21, 11, 11,
            10, 10, 11, 12, 12, 12, 13, 13, 21, 21, 21, 11, 11, 10, 10, 12,
            12, 12, 12, 13, 13, 21, 21, 21, 15, 15, 11, 11, 12, 12, 13, 13,
            13, 13, 21, 21, 21, 15, 16, 11, 11, 12, 12, 13, 13, 14, 14, 21,
            21, 21, 21, 20, 13, 13, 13, 13, 13, 13, 14, 14, 20, 20, 20, 20,
            20, 13, 13, 13, 13, 13, 13, 14, 14,
    };

    private static final float[] _vq_quantthresh__44c6_s_p7_0 = {
            -60.5f, -49.5f, -38.5f, -27.5f, -16.5f, -5.5f, 5.5f, 16.5f,
            27.5f, 38.5f, 49.5f, 60.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p7_0 = {
            11, 9, 7, 5, 3, 1, 0, 2,
            4, 6, 8, 10, 12,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p7_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p7_0,
            _vq_quantmap__44c6_s_p7_0,
            13,
            13
    );

    public static StaticCodeBook _44c6_s_p7_0 = new StaticCodeBook(
            2, 169,
            _vq_lengthlist__44c6_s_p7_0,
            1, -523206656, 1618345984, 4, 0,
            _vq_quantlist__44c6_s_p7_0,
            null,
            _vq_auxt__44c6_s_p7_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p7_1 = {
            5,
            4,
            6,
            3,
            7,
            2,
            8,
            1,
            9,
            0,
            10,
    };

    private static final int[] _vq_lengthlist__44c6_s_p7_1 = {
            3, 5, 5, 6, 6, 7, 7, 7, 7, 7, 7, 9, 5, 5, 6, 6,
            7, 7, 7, 7, 8, 7, 8, 5, 5, 6, 6, 7, 7, 7, 7, 7,
            7, 9, 6, 6, 7, 7, 7, 7, 8, 7, 7, 8, 9, 9, 9, 7,
            7, 7, 7, 7, 7, 7, 8, 9, 9, 9, 7, 7, 7, 7, 8, 8,
            8, 8, 9, 9, 9, 7, 7, 7, 7, 7, 7, 8, 8, 9, 9, 9,
            8, 8, 8, 8, 7, 7, 8, 8, 9, 9, 9, 9, 8, 8, 8, 7,
            7, 8, 8, 9, 9, 9, 8, 8, 8, 8, 7, 7, 8, 8, 9, 9,
            9, 8, 8, 7, 7, 7, 7, 8, 8,
    };

    private static final float[] _vq_quantthresh__44c6_s_p7_1 = {
            -4.5f, -3.5f, -2.5f, -1.5f, -0.5f, 0.5f, 1.5f, 2.5f,
            3.5f, 4.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p7_1 = {
            9, 7, 5, 3, 1, 0, 2, 4,
            6, 8, 10,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p7_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p7_1,
            _vq_quantmap__44c6_s_p7_1,
            11,
            11
    );

    public static StaticCodeBook _44c6_s_p7_1 = new StaticCodeBook(
            2, 121,
            _vq_lengthlist__44c6_s_p7_1,
            1, -531365888, 1611661312, 4, 0,
            _vq_quantlist__44c6_s_p7_1,
            null,
            _vq_auxt__44c6_s_p7_1,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p8_0 = {
            7,
            6,
            8,
            5,
            9,
            4,
            10,
            3,
            11,
            2,
            12,
            1,
            13,
            0,
            14,
    };

    private static final int[] _vq_lengthlist__44c6_s_p8_0 = {
            1, 4, 4, 7, 7, 8, 8, 7, 7, 8, 7, 9, 8, 10, 9, 6,
            5, 5, 8, 8, 9, 9, 8, 8, 9, 9, 11, 10, 11, 10, 6, 5,
            5, 8, 8, 9, 9, 8, 8, 9, 9, 10, 10, 11, 11, 18, 8, 8,
            9, 8, 10, 10, 9, 9, 10, 10, 10, 10, 11, 10, 18, 8, 8, 9,
            9, 10, 10, 9, 9, 10, 10, 11, 11, 12, 12, 18, 12, 13, 9, 10,
            10, 10, 9, 10, 10, 10, 11, 11, 12, 11, 18, 13, 13, 9, 9, 10,
            10, 10, 10, 10, 10, 11, 11, 12, 12, 18, 18, 18, 10, 10, 9, 9,
            11, 11, 11, 11, 11, 12, 12, 12, 18, 18, 18, 10, 9, 10, 9, 11,
            10, 11, 11, 11, 11, 13, 12, 18, 18, 18, 14, 13, 10, 10, 11, 11,
            12, 12, 12, 12, 12, 12, 18, 18, 18, 14, 13, 10, 10, 11, 10, 12,
            12, 12, 12, 12, 12, 18, 18, 18, 18, 18, 12, 12, 11, 11, 12, 12,
            13, 13, 13, 14, 18, 18, 18, 18, 18, 12, 12, 11, 11, 12, 11, 13,
            13, 14, 13, 18, 18, 18, 18, 18, 16, 16, 11, 12, 12, 13, 13, 13,
            14, 13, 18, 18, 18, 18, 18, 16, 15, 12, 11, 12, 11, 13, 11, 15,
            14,
    };

    private static final float[] _vq_quantthresh__44c6_s_p8_0 = {
            -136.5f, -115.5f, -94.5f, -73.5f, -52.5f, -31.5f, -10.5f, 10.5f,
            31.5f, 52.5f, 73.5f, 94.5f, 115.5f, 136.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p8_0 = {
            13, 11, 9, 7, 5, 3, 1, 0,
            2, 4, 6, 8, 10, 12, 14,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p8_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p8_0,
            _vq_quantmap__44c6_s_p8_0,
            15,
            15
    );

    public static StaticCodeBook _44c6_s_p8_0 = new StaticCodeBook(
            2, 225,
            _vq_lengthlist__44c6_s_p8_0,
            1, -520986624, 1620377600, 4, 0,
            _vq_quantlist__44c6_s_p8_0,
            null,
            _vq_auxt__44c6_s_p8_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p8_1 = {
            10,
            9,
            11,
            8,
            12,
            7,
            13,
            6,
            14,
            5,
            15,
            4,
            16,
            3,
            17,
            2,
            18,
            1,
            19,
            0,
            20,
    };

    private static final int[] _vq_lengthlist__44c6_s_p8_1 = {
            3, 5, 5, 6, 6, 7, 7, 7, 7, 8, 7, 8, 8, 8, 8, 8,
            8, 8, 8, 8, 8, 10, 6, 6, 7, 7, 8, 8, 8, 8, 8, 8,
            9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 6, 6, 7, 7, 8,
            8, 8, 8, 8, 8, 9, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10,
            7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9,
            9, 9, 9, 9, 10, 11, 11, 8, 7, 8, 8, 8, 9, 9, 9, 9,
            9, 9, 9, 9, 9, 9, 9, 9, 9, 11, 11, 11, 8, 8, 8, 8,
            9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 11, 11,
            11, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
            9, 9, 9, 11, 11, 11, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
            9, 9, 9, 9, 9, 9, 9, 9, 11, 11, 11, 11, 11, 9, 9, 9,
            9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 9, 11, 11, 11,
            11, 11, 9, 9, 9, 9, 9, 9, 10, 9, 9, 10, 9, 10, 9, 9,
            10, 9, 11, 11, 11, 11, 11, 9, 9, 9, 9, 9, 9, 9, 10, 10,
            10, 10, 9, 10, 10, 9, 10, 11, 11, 11, 11, 11, 9, 9, 9, 9,
            10, 10, 10, 9, 10, 10, 10, 10, 9, 10, 10, 9, 11, 11, 11, 11,
            11, 11, 11, 9, 9, 9, 9, 10, 10, 10, 10, 9, 10, 10, 10, 10,
            10, 11, 11, 11, 11, 11, 11, 11, 10, 9, 10, 10, 10, 10, 10, 10,
            10, 9, 10, 9, 10, 10, 11, 11, 11, 11, 11, 11, 11, 10, 9, 10,
            9, 10, 10, 9, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11,
            11, 11, 10, 10, 10, 10, 10, 10, 10, 9, 10, 10, 10, 10, 10, 9,
            11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11,
            11, 11, 11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 10, 10, 11,
            11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10, 9, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 10, 11, 9,
            10, 10, 10, 10, 10, 10, 10, 10, 10,
    };

    private static final float[] _vq_quantthresh__44c6_s_p8_1 = {
            -9.5f, -8.5f, -7.5f, -6.5f, -5.5f, -4.5f, -3.5f, -2.5f,
            -1.5f, -0.5f, 0.5f, 1.5f, 2.5f, 3.5f, 4.5f, 5.5f,
            6.5f, 7.5f, 8.5f, 9.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p8_1 = {
            19, 17, 15, 13, 11, 9, 7, 5,
            3, 1, 0, 2, 4, 6, 8, 10,
            12, 14, 16, 18, 20,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p8_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p8_1,
            _vq_quantmap__44c6_s_p8_1,
            21,
            21
    );

    public static StaticCodeBook _44c6_s_p8_1 = new StaticCodeBook(
            2, 441,
            _vq_lengthlist__44c6_s_p8_1,
            1, -529268736, 1611661312, 5, 0,
            _vq_quantlist__44c6_s_p8_1,
            null,
            _vq_auxt__44c6_s_p8_1,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p9_0 = {
            6,
            5,
            7,
            4,
            8,
            3,
            9,
            2,
            10,
            1,
            11,
            0,
            12,
    };

    private static final int[] _vq_lengthlist__44c6_s_p9_0 = {
            1, 3, 3, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 4, 7, 7,
            11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 5, 8, 9, 11, 11, 11,
            11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
            11, 11, 11, 11, 11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10,
    };

    private static final float[] _vq_quantthresh__44c6_s_p9_0 = {
            -3503.5f, -2866.5f, -2229.5f, -1592.5f, -955.5f, -318.5f, 318.5f, 955.5f,
            1592.5f, 2229.5f, 2866.5f, 3503.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p9_0 = {
            11, 9, 7, 5, 3, 1, 0, 2,
            4, 6, 8, 10, 12,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p9_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p9_0,
            _vq_quantmap__44c6_s_p9_0,
            13,
            13
    );

    public static StaticCodeBook _44c6_s_p9_0 = new StaticCodeBook(
            2, 169,
            _vq_lengthlist__44c6_s_p9_0,
            1, -511845376, 1630791680, 4, 0,
            _vq_quantlist__44c6_s_p9_0,
            null,
            _vq_auxt__44c6_s_p9_0,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p9_1 = {
            6,
            5,
            7,
            4,
            8,
            3,
            9,
            2,
            10,
            1,
            11,
            0,
            12,
    };

    private static final int[] _vq_lengthlist__44c6_s_p9_1 = {
            1, 4, 4, 7, 7, 7, 7, 7, 6, 8, 8, 8, 8, 6, 6, 6,
            8, 8, 8, 8, 8, 7, 9, 8, 10, 10, 5, 6, 6, 8, 8, 9,
            9, 8, 8, 10, 10, 10, 10, 16, 9, 9, 9, 9, 9, 9, 9, 8,
            10, 9, 11, 11, 16, 8, 9, 9, 9, 9, 9, 9, 9, 10, 10, 11,
            11, 16, 13, 13, 9, 9, 10, 9, 9, 10, 11, 11, 11, 12, 16, 13,
            14, 9, 8, 10, 8, 9, 9, 10, 10, 12, 11, 16, 14, 16, 9, 9,
            9, 9, 11, 11, 12, 11, 12, 11, 16, 16, 16, 9, 7, 9, 6, 11,
            11, 11, 10, 11, 11, 16, 16, 16, 11, 12, 9, 10, 11, 11, 12, 11,
            13, 13, 16, 16, 16, 12, 11, 10, 7, 12, 10, 12, 12, 12, 12, 16,
            16, 15, 16, 16, 10, 11, 10, 11, 13, 13, 14, 12, 16, 16, 16, 15,
            15, 12, 10, 11, 11, 13, 11, 12, 13,
    };

    private static final float[] _vq_quantthresh__44c6_s_p9_1 = {
            -269.5f, -220.5f, -171.5f, -122.5f, -73.5f, -24.5f, 24.5f, 73.5f,
            122.5f, 171.5f, 220.5f, 269.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p9_1 = {
            11, 9, 7, 5, 3, 1, 0, 2,
            4, 6, 8, 10, 12,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p9_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p9_1,
            _vq_quantmap__44c6_s_p9_1,
            13,
            13
    );

    public static StaticCodeBook _44c6_s_p9_1 = new StaticCodeBook(
            2, 169,
            _vq_lengthlist__44c6_s_p9_1,
            1, -518889472, 1622704128, 4, 0,
            _vq_quantlist__44c6_s_p9_1,
            null,
            _vq_auxt__44c6_s_p9_1,
            null,
            0
    );

    private static final int[] _vq_quantlist__44c6_s_p9_2 = {
            24,
            23,
            25,
            22,
            26,
            21,
            27,
            20,
            28,
            19,
            29,
            18,
            30,
            17,
            31,
            16,
            32,
            15,
            33,
            14,
            34,
            13,
            35,
            12,
            36,
            11,
            37,
            10,
            38,
            9,
            39,
            8,
            40,
            7,
            41,
            6,
            42,
            5,
            43,
            4,
            44,
            3,
            45,
            2,
            46,
            1,
            47,
            0,
            48,
    };

    private static final int[] _vq_lengthlist__44c6_s_p9_2 = {
            2, 4, 3, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6,
            6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
            7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
            7,
    };

    private static final float[] _vq_quantthresh__44c6_s_p9_2 = {
            -23.5f, -22.5f, -21.5f, -20.5f, -19.5f, -18.5f, -17.5f, -16.5f,
            -15.5f, -14.5f, -13.5f, -12.5f, -11.5f, -10.5f, -9.5f, -8.5f,
            -7.5f, -6.5f, -5.5f, -4.5f, -3.5f, -2.5f, -1.5f, -0.5f,
            0.5f, 1.5f, 2.5f, 3.5f, 4.5f, 5.5f, 6.5f, 7.5f,
            8.5f, 9.5f, 10.5f, 11.5f, 12.5f, 13.5f, 14.5f, 15.5f,
            16.5f, 17.5f, 18.5f, 19.5f, 20.5f, 21.5f, 22.5f, 23.5f,
    };

    private static final int[] _vq_quantmap__44c6_s_p9_2 = {
            47, 45, 43, 41, 39, 37, 35, 33,
            31, 29, 27, 25, 23, 21, 19, 17,
            15, 13, 11, 9, 7, 5, 3, 1,
            0, 2, 4, 6, 8, 10, 12, 14,
            16, 18, 20, 22, 24, 26, 28, 30,
            32, 34, 36, 38, 40, 42, 44, 46,
            48,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44c6_s_p9_2 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44c6_s_p9_2,
            _vq_quantmap__44c6_s_p9_2,
            49,
            49
    );

    public static StaticCodeBook _44c6_s_p9_2 = new StaticCodeBook(
            1, 49,
            _vq_lengthlist__44c6_s_p9_2,
            1, -526909440, 1611661312, 6, 0,
            _vq_quantlist__44c6_s_p9_2,
            null,
            _vq_auxt__44c6_s_p9_2,
            null,
            0
    );

    private static final int[] _huff_lengthlist__44c6_s_short = {
            3, 9, 11, 11, 13, 14, 19, 17, 17, 19, 5, 4, 5, 8, 10, 10,
            13, 16, 18, 19, 7, 4, 4, 5, 8, 9, 12, 14, 17, 19, 8, 6,
            5, 5, 7, 7, 10, 13, 16, 18, 10, 8, 7, 6, 5, 5, 8, 11,
            17, 19, 11, 9, 7, 7, 5, 4, 5, 8, 17, 19, 13, 11, 8, 7,
            7, 5, 5, 7, 16, 18, 14, 13, 8, 6, 6, 5, 5, 7, 16, 18,
            18, 16, 10, 8, 8, 7, 7, 9, 16, 18, 18, 18, 12, 10, 10, 9,
            9, 10, 17, 18,
    };

    public static StaticCodeBook _huff_book__44c6_s_short = new StaticCodeBook(
            2, 100,
            _huff_lengthlist__44c6_s_short,
            0, 0, 0, 0, 0,
            null,
            null,
            null,
            null,
            0
    );

}