/*
 * THIS FILE IS PART OF THE OggVorbis SOFTWARE CODEC SOURCE CODE.
 * USE, DISTRIBUTION AND REPRODUCTION OF THIS LIBRARY SOURCE IS
 * GOVERNED BY A BSD-STYLE SOURCE LICENSE INCLUDED WITH THIS SOURCE
 * IN 'COPYING'. PLEASE READ THESE TERMS BEFORE DISTRIBUTING.
 *
 * THE OggVorbis SOURCE CODE IS (C) COPYRIGHT 1994-2002
 * by the XIPHOPHORUS Company http://www.xiph.org/
 */

package biniu.vorbis.books.uncoupled;

import biniu.vorbis.EncodeAuxThreshMatch;
import biniu.vorbis.StaticCodeBook;

/**
 * EncoderVorbis</p>
 * <p>Description: Codec for encoding music files (wav -> ogg) </p>
 *
 * @author Zbigniew Sudnik
 * @version 1.1.0j 2005-05-01 07:00:00
 */
public class ResBooksUncoupled44u1 {

    private static int[] _huff_lengthlist__44u1__long = {
            5, 8, 13, 10, 17, 11, 11, 15, 7, 2, 4, 5, 8, 7, 9, 16,
            13, 4, 3, 5, 6, 8, 11, 20, 10, 4, 5, 5, 7, 6, 8, 18,
            15, 7, 6, 7, 8, 10, 14, 20, 10, 6, 7, 6, 9, 7, 8, 17,
            9, 8, 10, 8, 10, 5, 4, 11, 12, 17, 19, 14, 16, 10, 7, 12,
    };

    public static StaticCodeBook _huff_book__44u1__long = new StaticCodeBook(
            2, 64,
            _huff_lengthlist__44u1__long,
            0, 0, 0, 0, 0,
            null,
            null,
            null,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p1_0 = {
            1,
            0,
            2,
    };

    private static int[] _vq_lengthlist__44u1__p1_0 = {
            1, 4, 4, 5, 8, 7, 5, 7, 8, 5, 8, 8, 8, 11, 11, 8,
            10, 10, 5, 8, 8, 8, 11, 10, 8, 11, 11, 4, 8, 8, 8, 11,
            11, 8, 11, 11, 8, 12, 11, 11, 13, 13, 11, 13, 14, 7, 11, 11,
            10, 13, 12, 11, 13, 14, 4, 8, 8, 8, 11, 11, 8, 11, 12, 8,
            11, 11, 11, 13, 13, 10, 12, 13, 8, 11, 11, 11, 14, 13, 11, 14,
            13,
    };

    private static float[] _vq_quantthresh__44u1__p1_0 = {
            -0.5f, 0.5f,
    };

    private static int[] _vq_quantmap__44u1__p1_0 = {
            1, 0, 2,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p1_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p1_0,
            _vq_quantmap__44u1__p1_0,
            3,
            3
    );

    public static StaticCodeBook _44u1__p1_0 = new StaticCodeBook(
            4, 81,
            _vq_lengthlist__44u1__p1_0,
            1, -535822336, 1611661312, 2, 0,
            _vq_quantlist__44u1__p1_0,
            null,
            _vq_auxt__44u1__p1_0,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p2_0 = {
            1,
            0,
            2,
    };

    private static int[] _vq_lengthlist__44u1__p2_0 = {
            2, 4, 4, 5, 6, 6, 5, 6, 6, 5, 7, 7, 7, 8, 8, 6,
            8, 8, 5, 7, 7, 6, 8, 8, 7, 8, 8, 4, 7, 7, 7, 8,
            8, 7, 8, 8, 7, 8, 8, 8, 9, 10, 8, 10, 10, 6, 8, 8,
            8, 10, 8, 8, 10, 10, 5, 7, 7, 7, 8, 8, 7, 8, 8, 6,
            8, 8, 8, 10, 10, 8, 8, 10, 6, 8, 8, 8, 10, 10, 8, 10,
            9,
    };

    private static float[] _vq_quantthresh__44u1__p2_0 = {
            -0.5f, 0.5f,
    };

    private static int[] _vq_quantmap__44u1__p2_0 = {
            1, 0, 2,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p2_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p2_0,
            _vq_quantmap__44u1__p2_0,
            3,
            3
    );

    public static StaticCodeBook _44u1__p2_0 = new StaticCodeBook(
            4, 81,
            _vq_lengthlist__44u1__p2_0,
            1, -535822336, 1611661312, 2, 0,
            _vq_quantlist__44u1__p2_0,
            null,
            _vq_auxt__44u1__p2_0,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p3_0 = {
            2,
            1,
            3,
            0,
            4,
    };

    private static int[] _vq_lengthlist__44u1__p3_0 = {
            1, 5, 5, 8, 8, 5, 8, 7, 9, 9, 5, 7, 8, 9, 9, 9,
            10, 9, 12, 12, 9, 9, 10, 12, 12, 6, 8, 8, 11, 10, 8, 10,
            10, 11, 11, 8, 9, 10, 11, 11, 10, 11, 11, 14, 13, 10, 11, 11,
            13, 13, 5, 8, 8, 10, 10, 8, 10, 10, 11, 11, 8, 10, 10, 11,
            11, 10, 11, 11, 13, 13, 10, 11, 11, 13, 13, 9, 11, 11, 15, 14,
            10, 12, 12, 15, 14, 10, 12, 11, 15, 14, 13, 14, 14, 16, 16, 12,
            14, 13, 17, 15, 9, 11, 11, 14, 15, 10, 11, 12, 14, 16, 10, 11,
            12, 14, 16, 12, 13, 14, 16, 16, 13, 13, 15, 15, 18, 5, 8, 8,
            11, 11, 8, 10, 10, 12, 12, 8, 10, 10, 12, 13, 11, 12, 12, 14,
            14, 11, 12, 12, 15, 15, 8, 10, 10, 13, 13, 10, 12, 12, 13, 13,
            10, 12, 12, 14, 14, 12, 13, 13, 15, 15, 12, 13, 13, 16, 16, 7,
            10, 10, 12, 12, 10, 12, 11, 13, 13, 10, 12, 12, 13, 14, 12, 13,
            12, 15, 14, 12, 13, 13, 16, 16, 10, 12, 12, 17, 16, 12, 13, 13,
            16, 15, 11, 13, 13, 17, 17, 15, 15, 15, 16, 17, 14, 15, 15, 19,
            19, 10, 12, 12, 15, 16, 11, 13, 12, 15, 18, 11, 13, 13, 16, 16,
            14, 15, 15, 17, 17, 14, 15, 15, 17, 19, 5, 8, 8, 11, 11, 8,
            10, 10, 12, 12, 8, 10, 10, 12, 12, 11, 12, 12, 16, 15, 11, 12,
            12, 14, 15, 7, 10, 10, 13, 13, 10, 12, 12, 14, 13, 10, 11, 12,
            13, 13, 12, 13, 13, 16, 16, 12, 12, 13, 15, 15, 8, 10, 10, 13,
            13, 10, 12, 12, 14, 14, 10, 12, 12, 13, 13, 12, 13, 13, 16, 16,
            12, 13, 13, 15, 15, 10, 12, 12, 16, 15, 11, 13, 13, 17, 16, 11,
            12, 13, 16, 15, 13, 15, 15, 19, 17, 14, 15, 14, 17, 16, 10, 12,
            12, 16, 16, 11, 13, 13, 16, 17, 12, 13, 13, 15, 17, 14, 15, 15,
            17, 19, 14, 15, 15, 17, 17, 8, 11, 11, 16, 16, 10, 13, 12, 17,
            17, 10, 12, 13, 16, 16, 15, 17, 16, 20, 19, 14, 15, 17, 18, 19,
            9, 12, 12, 16, 17, 11, 13, 14, 17, 18, 11, 13, 13, 19, 18, 16,
            17, 18, 19, 19, 15, 16, 16, 19, 19, 9, 12, 12, 16, 17, 11, 14,
            13, 18, 17, 11, 13, 13, 17, 17, 16, 17, 16, 20, 19, 14, 16, 16,
            18, 18, 12, 15, 15, 19, 17, 14, 15, 16, 0, 20, 13, 15, 16, 20,
            17, 18, 16, 20, 0, 0, 15, 16, 19, 20, 0, 12, 15, 14, 18, 19,
            13, 16, 15, 20, 19, 13, 16, 15, 20, 18, 17, 18, 17, 0, 20, 16,
            17, 16, 0, 0, 8, 11, 11, 16, 15, 10, 12, 12, 17, 17, 10, 13,
            13, 17, 16, 14, 16, 15, 18, 20, 15, 16, 16, 19, 19, 9, 12, 12,
            16, 16, 11, 13, 13, 17, 16, 11, 13, 14, 17, 18, 15, 15, 16, 20,
            20, 16, 16, 17, 19, 19, 9, 13, 12, 16, 17, 11, 14, 13, 17, 17,
            11, 14, 14, 18, 17, 14, 16, 15, 18, 19, 16, 17, 18, 18, 19, 12,
            14, 15, 19, 18, 13, 15, 16, 18, 0, 13, 14, 15, 0, 0, 16, 16,
            17, 20, 0, 17, 17, 20, 20, 0, 12, 15, 15, 19, 20, 13, 15, 15,
            0, 0, 14, 16, 15, 0, 0, 15, 18, 16, 0, 0, 17, 18, 16, 0,
            19,
    };

    private static float[] _vq_quantthresh__44u1__p3_0 = {
            -1.5f, -0.5f, 0.5f, 1.5f,
    };

    private static int[] _vq_quantmap__44u1__p3_0 = {
            3, 1, 0, 2, 4,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p3_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p3_0,
            _vq_quantmap__44u1__p3_0,
            5,
            5
    );

    public static StaticCodeBook _44u1__p3_0 = new StaticCodeBook(
            4, 625,
            _vq_lengthlist__44u1__p3_0,
            1, -533725184, 1611661312, 3, 0,
            _vq_quantlist__44u1__p3_0,
            null,
            _vq_auxt__44u1__p3_0,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p4_0 = {
            2,
            1,
            3,
            0,
            4,
    };

    private static int[] _vq_lengthlist__44u1__p4_0 = {
            4, 5, 5, 9, 9, 5, 6, 6, 9, 9, 5, 6, 6, 9, 9, 9,
            10, 9, 12, 12, 9, 9, 10, 12, 12, 5, 7, 7, 10, 10, 7, 7,
            8, 10, 10, 6, 7, 8, 10, 10, 10, 10, 10, 11, 13, 10, 9, 10,
            12, 13, 5, 7, 7, 10, 10, 6, 8, 7, 10, 10, 7, 8, 7, 10,
            10, 9, 10, 10, 12, 12, 10, 10, 10, 13, 11, 9, 10, 10, 13, 13,
            10, 11, 10, 13, 13, 10, 10, 10, 13, 13, 12, 12, 13, 14, 14, 12,
            12, 13, 14, 14, 9, 10, 10, 13, 13, 10, 10, 10, 13, 13, 10, 10,
            10, 13, 13, 12, 13, 12, 15, 14, 12, 13, 12, 15, 15, 5, 7, 6,
            10, 10, 7, 8, 8, 10, 10, 7, 8, 8, 10, 10, 10, 11, 10, 13,
            13, 10, 10, 10, 12, 12, 7, 8, 8, 11, 10, 8, 8, 9, 10, 11,
            8, 9, 9, 11, 11, 11, 10, 11, 11, 14, 11, 11, 11, 13, 13, 6,
            8, 8, 10, 10, 7, 9, 8, 11, 10, 8, 9, 9, 11, 11, 10, 11,
            10, 14, 11, 10, 11, 11, 13, 13, 10, 11, 11, 14, 13, 10, 10, 11,
            14, 13, 10, 11, 11, 14, 14, 12, 11, 13, 12, 16, 13, 14, 14, 15,
            15, 10, 10, 11, 13, 14, 10, 11, 10, 14, 13, 10, 11, 11, 14, 14,
            12, 13, 12, 15, 13, 13, 13, 14, 15, 16, 5, 7, 7, 10, 10, 7,
            8, 8, 10, 10, 7, 8, 8, 10, 10, 10, 10, 10, 13, 13, 10, 10,
            11, 12, 13, 6, 8, 8, 11, 10, 8, 9, 9, 11, 11, 7, 8, 9,
            10, 11, 10, 11, 11, 13, 13, 10, 10, 11, 11, 13, 6, 8, 8, 10,
            11, 8, 9, 9, 11, 11, 8, 9, 8, 12, 10, 10, 11, 11, 13, 13,
            10, 11, 10, 14, 11, 10, 10, 10, 14, 13, 10, 11, 11, 14, 13, 10,
            10, 11, 13, 13, 12, 14, 14, 16, 16, 12, 12, 13, 13, 15, 10, 11,
            11, 13, 14, 10, 11, 11, 14, 15, 10, 11, 10, 13, 13, 13, 14, 13,
            16, 16, 12, 13, 11, 15, 12, 9, 10, 10, 13, 13, 10, 11, 11, 14,
            13, 10, 10, 11, 13, 14, 13, 14, 13, 16, 16, 13, 13, 13, 15, 16,
            9, 10, 10, 13, 13, 10, 10, 11, 13, 14, 10, 11, 11, 15, 13, 13,
            13, 14, 14, 18, 13, 13, 14, 16, 15, 9, 10, 10, 13, 14, 10, 11,
            10, 14, 13, 10, 11, 11, 13, 14, 13, 14, 13, 16, 15, 13, 13, 14,
            15, 16, 12, 13, 12, 16, 14, 11, 11, 13, 15, 15, 13, 14, 13, 16,
            15, 15, 12, 16, 12, 17, 14, 15, 15, 17, 17, 12, 13, 13, 14, 16,
            11, 13, 11, 16, 15, 12, 13, 14, 15, 16, 14, 15, 13, 0, 14, 14,
            16, 16, 0, 0, 9, 10, 10, 13, 13, 10, 11, 10, 14, 14, 10, 11,
            11, 13, 13, 12, 13, 13, 14, 16, 13, 14, 14, 16, 16, 9, 10, 10,
            14, 14, 11, 11, 11, 14, 13, 10, 10, 11, 14, 14, 13, 13, 13, 16,
            16, 13, 13, 14, 14, 17, 9, 10, 10, 13, 14, 10, 11, 11, 13, 15,
            10, 11, 10, 14, 14, 13, 13, 13, 14, 17, 13, 14, 13, 17, 14, 12,
            13, 13, 16, 14, 13, 14, 13, 16, 15, 12, 12, 13, 15, 16, 15, 15,
            16, 18, 16, 15, 13, 15, 14, 0, 12, 12, 13, 14, 16, 13, 13, 14,
            15, 16, 11, 12, 11, 16, 14, 15, 16, 16, 17, 17, 14, 15, 12, 17,
            12,
    };

    private static float[] _vq_quantthresh__44u1__p4_0 = {
            -1.5f, -0.5f, 0.5f, 1.5f,
    };

    private static int[] _vq_quantmap__44u1__p4_0 = {
            3, 1, 0, 2, 4,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p4_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p4_0,
            _vq_quantmap__44u1__p4_0,
            5,
            5
    );

    public static StaticCodeBook _44u1__p4_0 = new StaticCodeBook(
            4, 625,
            _vq_lengthlist__44u1__p4_0,
            1, -533725184, 1611661312, 3, 0,
            _vq_quantlist__44u1__p4_0,
            null,
            _vq_auxt__44u1__p4_0,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p5_0 = {
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

    private static int[] _vq_lengthlist__44u1__p5_0 = {
            1, 4, 4, 7, 7, 7, 7, 9, 9, 4, 6, 6, 8, 8, 8, 8,
            9, 9, 4, 6, 6, 8, 8, 8, 8, 9, 9, 7, 8, 8, 9, 9,
            9, 9, 11, 10, 7, 8, 8, 9, 9, 9, 9, 10, 10, 7, 8, 8,
            9, 9, 10, 10, 11, 11, 7, 8, 8, 9, 9, 10, 10, 11, 11, 9,
            9, 9, 10, 10, 11, 11, 12, 12, 9, 9, 9, 10, 11, 11, 11, 12,
            12,
    };

    private static float[] _vq_quantthresh__44u1__p5_0 = {
            -3.5f, -2.5f, -1.5f, -0.5f, 0.5f, 1.5f, 2.5f, 3.5f,
    };

    private static int[] _vq_quantmap__44u1__p5_0 = {
            7, 5, 3, 1, 0, 2, 4, 6,
            8,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p5_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p5_0,
            _vq_quantmap__44u1__p5_0,
            9,
            9
    );

    public static StaticCodeBook _44u1__p5_0 = new StaticCodeBook(
            2, 81,
            _vq_lengthlist__44u1__p5_0,
            1, -531628032, 1611661312, 4, 0,
            _vq_quantlist__44u1__p5_0,
            null,
            _vq_auxt__44u1__p5_0,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p6_0 = {
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

    private static int[] _vq_lengthlist__44u1__p6_0 = {
            1, 4, 4, 6, 6, 8, 8, 10, 9, 11, 10, 14, 13, 4, 6, 5,
            8, 8, 9, 9, 11, 10, 11, 11, 14, 14, 4, 5, 6, 8, 8, 9,
            9, 10, 10, 11, 11, 14, 14, 6, 8, 8, 9, 9, 10, 10, 11, 11,
            12, 12, 16, 15, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 15,
            15, 9, 10, 10, 10, 10, 11, 11, 12, 12, 12, 12, 15, 15, 9, 10,
            9, 10, 11, 11, 11, 12, 12, 12, 13, 15, 15, 10, 10, 11, 11, 11,
            12, 12, 13, 12, 13, 13, 16, 15, 10, 11, 11, 11, 11, 12, 12, 13,
            12, 13, 13, 16, 17, 11, 11, 12, 12, 12, 13, 13, 13, 14, 14, 15,
            17, 17, 11, 11, 12, 12, 12, 13, 13, 13, 14, 14, 14, 16, 18, 14,
            15, 15, 15, 15, 16, 16, 16, 16, 17, 18, 0, 0, 14, 15, 15, 15,
            15, 17, 16, 17, 18, 17, 17, 18, 0,
    };

    private static float[] _vq_quantthresh__44u1__p6_0 = {
            -27.5f, -22.5f, -17.5f, -12.5f, -7.5f, -2.5f, 2.5f, 7.5f,
            12.5f, 17.5f, 22.5f, 27.5f,
    };

    private static int[] _vq_quantmap__44u1__p6_0 = {
            11, 9, 7, 5, 3, 1, 0, 2,
            4, 6, 8, 10, 12,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p6_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p6_0,
            _vq_quantmap__44u1__p6_0,
            13,
            13
    );

    public static StaticCodeBook _44u1__p6_0 = new StaticCodeBook(
            2, 169,
            _vq_lengthlist__44u1__p6_0,
            1, -526516224, 1616117760, 4, 0,
            _vq_quantlist__44u1__p6_0,
            null,
            _vq_auxt__44u1__p6_0,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p6_1 = {
            2,
            1,
            3,
            0,
            4,
    };

    private static int[] _vq_lengthlist__44u1__p6_1 = {
            2, 4, 4, 5, 5, 4, 5, 5, 5, 5, 4, 5, 5, 5, 5, 5,
            6, 6, 6, 6, 5, 6, 6, 6, 6,
    };

    private static float[] _vq_quantthresh__44u1__p6_1 = {
            -1.5f, -0.5f, 0.5f, 1.5f,
    };

    private static int[] _vq_quantmap__44u1__p6_1 = {
            3, 1, 0, 2, 4,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p6_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p6_1,
            _vq_quantmap__44u1__p6_1,
            5,
            5
    );

    public static StaticCodeBook _44u1__p6_1 = new StaticCodeBook(
            2, 25,
            _vq_lengthlist__44u1__p6_1,
            1, -533725184, 1611661312, 3, 0,
            _vq_quantlist__44u1__p6_1,
            null,
            _vq_auxt__44u1__p6_1,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p7_0 = {
            3,
            2,
            4,
            1,
            5,
            0,
            6,
    };

    private static int[] _vq_lengthlist__44u1__p7_0 = {
            1, 3, 2, 9, 9, 7, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
            9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
            9, 9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
            8,
    };

    private static float[] _vq_quantthresh__44u1__p7_0 = {
            -422.5f, -253.5f, -84.5f, 84.5f, 253.5f, 422.5f,
    };

    private static int[] _vq_quantmap__44u1__p7_0 = {
            5, 3, 1, 0, 2, 4, 6,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p7_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p7_0,
            _vq_quantmap__44u1__p7_0,
            7,
            7
    );

    public static StaticCodeBook _44u1__p7_0 = new StaticCodeBook(
            2, 49,
            _vq_lengthlist__44u1__p7_0,
            1, -518017024, 1626677248, 3, 0,
            _vq_quantlist__44u1__p7_0,
            null,
            _vq_auxt__44u1__p7_0,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p7_1 = {
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

    private static int[] _vq_lengthlist__44u1__p7_1 = {
            1, 4, 4, 6, 6, 6, 6, 7, 7, 8, 8, 9, 9, 5, 7, 7,
            8, 7, 7, 7, 9, 8, 10, 9, 10, 11, 5, 7, 7, 8, 8, 7,
            7, 8, 9, 10, 10, 11, 11, 6, 8, 8, 9, 9, 9, 9, 11, 10,
            12, 12, 15, 12, 6, 8, 8, 9, 9, 9, 9, 11, 11, 12, 11, 14,
            12, 7, 8, 8, 10, 10, 12, 12, 13, 13, 13, 15, 13, 13, 7, 8,
            8, 10, 10, 11, 11, 13, 12, 14, 15, 15, 15, 9, 10, 10, 11, 12,
            13, 13, 14, 15, 14, 15, 14, 15, 8, 10, 10, 12, 12, 14, 14, 15,
            14, 14, 15, 15, 14, 10, 12, 12, 14, 14, 15, 14, 15, 15, 15, 14,
            15, 15, 10, 12, 12, 13, 14, 15, 14, 15, 15, 14, 15, 15, 15, 12,
            15, 13, 15, 14, 15, 15, 15, 15, 15, 15, 15, 15, 13, 13, 15, 15,
            15, 15, 15, 15, 15, 15, 15, 15, 15,
    };

    private static float[] _vq_quantthresh__44u1__p7_1 = {
            -71.5f, -58.5f, -45.5f, -32.5f, -19.5f, -6.5f, 6.5f, 19.5f,
            32.5f, 45.5f, 58.5f, 71.5f,
    };

    private static int[] _vq_quantmap__44u1__p7_1 = {
            11, 9, 7, 5, 3, 1, 0, 2,
            4, 6, 8, 10, 12,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p7_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p7_1,
            _vq_quantmap__44u1__p7_1,
            13,
            13
    );

    public static StaticCodeBook _44u1__p7_1 = new StaticCodeBook(
            2, 169,
            _vq_lengthlist__44u1__p7_1,
            1, -523010048, 1618608128, 4, 0,
            _vq_quantlist__44u1__p7_1,
            null,
            _vq_auxt__44u1__p7_1,
            null,
            0
    );

    private static int[] _vq_quantlist__44u1__p7_2 = {
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

    private static int[] _vq_lengthlist__44u1__p7_2 = {
            2, 5, 4, 6, 6, 7, 7, 8, 8, 8, 8, 9, 8, 5, 5, 6,
            7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 5, 6, 5, 7, 7, 8,
            8, 8, 8, 9, 9, 9, 9, 6, 7, 7, 8, 8, 8, 8, 9, 8,
            9, 9, 9, 9, 6, 7, 7, 8, 7, 8, 8, 9, 9, 9, 9, 9,
            9, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 7, 8,
            8, 9, 8, 9, 8, 9, 9, 9, 9, 9, 9, 8, 9, 8, 9, 9,
            9, 9, 9, 9, 9, 9, 10, 10, 8, 8, 9, 9, 9, 9, 9, 9,
            9, 9, 10, 9, 10, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
            9, 9, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
            9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 9, 9, 9, 9, 9,
            9, 9, 9, 10, 9, 9, 10, 10, 9,
    };

    private static float[] _vq_quantthresh__44u1__p7_2 = {
            -5.5f, -4.5f, -3.5f, -2.5f, -1.5f, -0.5f, 0.5f, 1.5f,
            2.5f, 3.5f, 4.5f, 5.5f,
    };

    private static int[] _vq_quantmap__44u1__p7_2 = {
            11, 9, 7, 5, 3, 1, 0, 2,
            4, 6, 8, 10, 12,
    };

    public static EncodeAuxThreshMatch _vq_auxt__44u1__p7_2 = new EncodeAuxThreshMatch(
            _vq_quantthresh__44u1__p7_2,
            _vq_quantmap__44u1__p7_2,
            13,
            13
    );

    public static StaticCodeBook _44u1__p7_2 = new StaticCodeBook(
            2, 169,
            _vq_lengthlist__44u1__p7_2,
            1, -531103744, 1611661312, 4, 0,
            _vq_quantlist__44u1__p7_2,
            null,
            _vq_auxt__44u1__p7_2,
            null,
            0
    );

    private static int[] _huff_lengthlist__44u1__short = {
            12, 13, 14, 13, 17, 12, 15, 17, 5, 5, 6, 10, 10, 11, 15, 16,
            4, 3, 3, 7, 5, 7, 10, 16, 7, 7, 7, 10, 9, 11, 12, 16,
            6, 5, 5, 9, 5, 6, 10, 16, 8, 7, 7, 9, 6, 7, 9, 16,
            11, 7, 3, 6, 4, 5, 8, 16, 12, 9, 4, 8, 5, 7, 9, 16,
    };

    public static StaticCodeBook _huff_book__44u1__short = new StaticCodeBook(
            2, 64,
            _huff_lengthlist__44u1__short,
            0, 0, 0, 0, 0,
            null,
            null,
            null,
            null,
            0
    );
}
