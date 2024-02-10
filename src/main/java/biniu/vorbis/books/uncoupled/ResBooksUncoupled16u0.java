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
public class ResBooksUncoupled16u0 {

    private static int[] _vq_quantlist__16u0__p1_0 = {
            1,
            0,
            2,
    };

    private static int[] _vq_lengthlist__16u0__p1_0 = {
            1, 4, 4, 5, 7, 7, 5, 7, 8, 5, 8, 8, 8, 10, 10, 8,
            10, 11, 5, 8, 8, 8, 10, 10, 8, 10, 10, 4, 9, 9, 9, 12,
            11, 8, 11, 11, 8, 12, 11, 10, 12, 14, 10, 13, 13, 7, 11, 11,
            10, 14, 12, 11, 14, 14, 4, 9, 9, 8, 11, 11, 9, 11, 12, 7,
            11, 11, 10, 13, 14, 10, 12, 14, 8, 11, 12, 10, 14, 14, 10, 13,
            12,
    };

    private static float[] _vq_quantthresh__16u0__p1_0 = {
            -0.5f, 0.5f,
    };

    private static int[] _vq_quantmap__16u0__p1_0 = {
            1, 0, 2,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p1_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p1_0,
            _vq_quantmap__16u0__p1_0,
            3,
            3
    );

    public static StaticCodeBook _16u0__p1_0 = new StaticCodeBook(
            4, 81,
            _vq_lengthlist__16u0__p1_0,
            1, -535822336, 1611661312, 2, 0,
            _vq_quantlist__16u0__p1_0,
            null,
            _vq_auxt__16u0__p1_0,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p2_0 = {
            1,
            0,
            2,
    };

    private static int[] _vq_lengthlist__16u0__p2_0 = {
            2, 4, 4, 5, 6, 6, 5, 6, 6, 5, 7, 7, 7, 8, 9, 7,
            8, 9, 5, 7, 7, 7, 9, 8, 7, 9, 7, 4, 7, 7, 7, 9,
            9, 7, 8, 8, 6, 9, 8, 7, 8, 11, 9, 11, 10, 6, 8, 9,
            8, 11, 8, 9, 10, 11, 4, 7, 7, 7, 8, 8, 7, 9, 9, 6,
            9, 8, 9, 11, 10, 8, 8, 11, 6, 8, 9, 9, 10, 11, 8, 11,
            8,
    };

    private static float[] _vq_quantthresh__16u0__p2_0 = {
            -0.5f, 0.5f,
    };

    private static int[] _vq_quantmap__16u0__p2_0 = {
            1, 0, 2,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p2_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p2_0,
            _vq_quantmap__16u0__p2_0,
            3,
            3
    );

    public static StaticCodeBook _16u0__p2_0 = new StaticCodeBook(
            4, 81,
            _vq_lengthlist__16u0__p2_0,
            1, -535822336, 1611661312, 2, 0,
            _vq_quantlist__16u0__p2_0,
            null,
            _vq_auxt__16u0__p2_0,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p3_0 = {
            2,
            1,
            3,
            0,
            4,
    };

    private static int[] _vq_lengthlist__16u0__p3_0 = {
            1, 5, 5, 7, 7, 6, 7, 7, 8, 8, 6, 7, 8, 8, 8, 8,
            9, 9, 11, 11, 8, 9, 9, 11, 11, 6, 9, 8, 10, 10, 8, 10,
            10, 11, 11, 8, 10, 10, 11, 11, 10, 11, 10, 13, 12, 9, 11, 10,
            13, 13, 6, 8, 9, 10, 10, 8, 10, 10, 11, 11, 8, 10, 10, 11,
            11, 9, 10, 11, 13, 12, 10, 10, 11, 12, 12, 8, 11, 11, 14, 13,
            10, 12, 11, 15, 13, 9, 12, 11, 15, 14, 12, 14, 13, 16, 14, 12,
            13, 13, 17, 14, 8, 11, 11, 13, 14, 9, 11, 12, 14, 15, 10, 11,
            12, 13, 15, 11, 13, 13, 14, 16, 12, 13, 14, 14, 16, 5, 9, 9,
            11, 11, 9, 11, 11, 12, 12, 8, 11, 11, 12, 12, 11, 12, 12, 15,
            14, 10, 12, 12, 15, 15, 8, 11, 11, 13, 12, 10, 12, 12, 13, 13,
            10, 12, 12, 14, 13, 12, 12, 13, 14, 15, 11, 13, 13, 17, 16, 7,
            11, 11, 13, 13, 10, 12, 12, 14, 13, 10, 12, 12, 13, 14, 12, 13,
            12, 15, 14, 11, 13, 13, 15, 14, 9, 12, 12, 16, 15, 11, 13, 13,
            17, 16, 10, 13, 13, 16, 16, 13, 14, 15, 15, 16, 13, 15, 14, 19,
            17, 9, 12, 12, 14, 16, 11, 13, 13, 15, 16, 10, 13, 13, 17, 16,
            13, 14, 13, 17, 15, 12, 15, 15, 16, 17, 5, 9, 9, 11, 11, 8,
            11, 11, 13, 12, 9, 11, 11, 12, 12, 10, 12, 12, 14, 15, 11, 12,
            12, 14, 14, 7, 11, 10, 13, 12, 10, 12, 12, 14, 13, 10, 11, 12,
            13, 13, 11, 13, 13, 15, 16, 12, 12, 13, 15, 15, 7, 11, 11, 13,
            13, 10, 13, 13, 14, 14, 10, 12, 12, 13, 13, 11, 13, 13, 16, 15,
            12, 13, 13, 15, 14, 9, 12, 12, 15, 15, 10, 13, 13, 17, 16, 11,
            12, 13, 15, 15, 12, 15, 14, 18, 18, 13, 14, 14, 16, 17, 9, 12,
            12, 15, 16, 10, 13, 13, 15, 16, 11, 13, 13, 15, 16, 13, 15, 15,
            17, 17, 13, 15, 14, 16, 15, 7, 11, 11, 15, 16, 10, 13, 12, 16,
            17, 10, 12, 13, 15, 17, 15, 16, 16, 18, 17, 13, 15, 15, 17, 18,
            8, 12, 12, 16, 16, 11, 13, 14, 17, 18, 11, 13, 13, 18, 16, 15,
            17, 16, 17, 19, 14, 15, 15, 17, 16, 8, 12, 12, 16, 15, 11, 14,
            13, 18, 17, 11, 13, 14, 18, 17, 15, 16, 16, 18, 17, 13, 16, 16,
            18, 18, 11, 15, 14, 18, 17, 13, 14, 15, 18, 0, 12, 15, 15, 0,
            17, 17, 16, 17, 17, 18, 14, 16, 18, 18, 0, 11, 14, 14, 17, 0,
            12, 15, 14, 17, 19, 12, 15, 14, 18, 0, 15, 18, 16, 0, 17, 14,
            18, 16, 18, 0, 7, 11, 11, 16, 15, 10, 12, 12, 18, 16, 10, 13,
            13, 16, 15, 13, 15, 14, 17, 17, 14, 16, 16, 19, 18, 8, 12, 12,
            16, 16, 11, 13, 13, 18, 16, 11, 13, 14, 17, 16, 14, 15, 15, 19,
            18, 15, 16, 16, 0, 19, 8, 12, 12, 16, 17, 11, 13, 13, 17, 17,
            11, 14, 13, 17, 17, 13, 15, 15, 17, 19, 15, 17, 17, 19, 0, 11,
            14, 15, 19, 17, 12, 15, 16, 18, 18, 12, 14, 15, 19, 17, 14, 16,
            17, 0, 18, 16, 16, 19, 17, 0, 11, 14, 14, 18, 19, 12, 15, 14,
            17, 17, 13, 16, 14, 17, 16, 14, 17, 16, 18, 18, 15, 18, 15, 0,
            18,
    };

    private static float[] _vq_quantthresh__16u0__p3_0 = {
            -1.5f, -0.5f, 0.5f, 1.5f,
    };

    private static int[] _vq_quantmap__16u0__p3_0 = {
            3, 1, 0, 2, 4,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p3_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p3_0,
            _vq_quantmap__16u0__p3_0,
            5,
            5
    );

    public static StaticCodeBook _16u0__p3_0 = new StaticCodeBook(
            4, 625,
            _vq_lengthlist__16u0__p3_0,
            1, -533725184, 1611661312, 3, 0,
            _vq_quantlist__16u0__p3_0,
            null,
            _vq_auxt__16u0__p3_0,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p4_0 = {
            2,
            1,
            3,
            0,
            4,
    };

    private static int[] _vq_lengthlist__16u0__p4_0 = {
            3, 5, 5, 8, 8, 6, 6, 6, 9, 9, 6, 6, 6, 9, 9, 9,
            10, 9, 11, 11, 9, 9, 9, 11, 11, 6, 7, 7, 10, 10, 7, 7,
            8, 10, 10, 7, 7, 8, 10, 10, 10, 10, 10, 11, 12, 9, 10, 10,
            11, 12, 6, 7, 7, 10, 10, 7, 8, 7, 10, 10, 7, 8, 7, 10,
            10, 10, 11, 10, 12, 11, 10, 10, 10, 13, 10, 9, 10, 10, 12, 12,
            10, 11, 10, 14, 12, 9, 11, 11, 13, 13, 11, 12, 13, 13, 13, 11,
            12, 12, 15, 13, 9, 10, 10, 12, 13, 9, 11, 10, 12, 13, 10, 10,
            11, 12, 13, 11, 12, 12, 12, 13, 11, 12, 12, 13, 13, 5, 7, 7,
            10, 10, 7, 8, 8, 10, 10, 7, 8, 8, 10, 10, 10, 11, 10, 12,
            13, 10, 10, 11, 12, 12, 6, 8, 8, 11, 10, 7, 8, 9, 10, 12,
            8, 9, 9, 11, 11, 11, 10, 11, 11, 12, 10, 11, 11, 13, 12, 7,
            8, 8, 10, 11, 8, 9, 8, 11, 10, 8, 9, 9, 11, 11, 10, 12,
            10, 13, 11, 10, 11, 11, 13, 13, 10, 11, 10, 14, 13, 10, 10, 11,
            13, 13, 10, 12, 11, 14, 13, 12, 11, 13, 12, 13, 13, 12, 13, 14,
            14, 10, 11, 11, 13, 13, 10, 11, 10, 12, 13, 10, 12, 12, 12, 14,
            12, 12, 12, 14, 12, 12, 13, 12, 17, 15, 5, 7, 7, 10, 10, 7,
            8, 8, 10, 10, 7, 8, 8, 11, 10, 10, 10, 11, 12, 12, 10, 11,
            11, 12, 13, 6, 8, 8, 11, 10, 8, 9, 9, 11, 11, 7, 8, 9,
            10, 11, 11, 11, 11, 12, 12, 10, 10, 11, 12, 13, 6, 8, 8, 10,
            11, 8, 9, 9, 11, 11, 7, 9, 7, 11, 10, 10, 12, 12, 13, 13,
            11, 11, 10, 13, 11, 9, 11, 10, 14, 13, 11, 11, 11, 15, 13, 10,
            10, 11, 13, 13, 12, 13, 13, 14, 14, 12, 11, 12, 12, 13, 10, 11,
            11, 12, 13, 10, 11, 12, 13, 13, 10, 11, 10, 13, 12, 12, 12, 13,
            14, 0, 12, 13, 11, 13, 11, 8, 10, 10, 13, 13, 10, 11, 11, 14,
            13, 10, 11, 11, 13, 12, 13, 14, 14, 14, 15, 12, 12, 12, 15, 14,
            9, 11, 10, 13, 12, 10, 10, 11, 13, 14, 11, 11, 11, 15, 12, 13,
            12, 14, 15, 16, 13, 13, 13, 14, 13, 9, 11, 11, 12, 12, 10, 12,
            11, 13, 13, 10, 11, 11, 13, 14, 13, 13, 13, 15, 15, 13, 13, 14,
            17, 15, 11, 12, 12, 14, 14, 10, 11, 12, 13, 15, 12, 13, 13, 0,
            15, 13, 11, 14, 12, 16, 14, 16, 14, 0, 15, 11, 12, 12, 14, 16,
            11, 13, 12, 16, 15, 12, 13, 13, 14, 15, 12, 14, 12, 15, 13, 15,
            14, 14, 16, 16, 8, 10, 10, 13, 13, 10, 11, 10, 13, 14, 10, 11,
            11, 13, 13, 13, 13, 12, 14, 14, 14, 13, 13, 16, 17, 9, 10, 10,
            12, 14, 10, 12, 11, 14, 13, 10, 11, 12, 13, 14, 12, 12, 12, 15,
            15, 13, 13, 13, 14, 14, 9, 10, 10, 13, 13, 10, 11, 12, 12, 14,
            10, 11, 10, 13, 13, 13, 13, 13, 14, 16, 13, 13, 13, 14, 14, 11,
            12, 13, 15, 13, 12, 14, 13, 14, 16, 12, 12, 13, 13, 14, 13, 14,
            14, 17, 15, 13, 12, 17, 13, 16, 11, 12, 13, 14, 15, 12, 13, 14,
            14, 17, 11, 12, 11, 14, 14, 13, 16, 14, 16, 0, 14, 15, 11, 15,
            11,
    };

    private static float[] _vq_quantthresh__16u0__p4_0 = {
            -1.5f, -0.5f, 0.5f, 1.5f,
    };

    private static int[] _vq_quantmap__16u0__p4_0 = {
            3, 1, 0, 2, 4,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p4_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p4_0,
            _vq_quantmap__16u0__p4_0,
            5,
            5
    );

    public static StaticCodeBook _16u0__p4_0 = new StaticCodeBook(
            4, 625,
            _vq_lengthlist__16u0__p4_0,
            1, -533725184, 1611661312, 3, 0,
            _vq_quantlist__16u0__p4_0,
            null,
            _vq_auxt__16u0__p4_0,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p5_0 = {
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

    private static int[] _vq_lengthlist__16u0__p5_0 = {
            1, 4, 4, 7, 7, 7, 7, 9, 9, 4, 6, 6, 8, 8, 8, 8,
            9, 9, 4, 6, 6, 8, 8, 8, 8, 9, 9, 7, 8, 8, 9, 9,
            9, 9, 11, 10, 7, 8, 8, 9, 9, 9, 9, 10, 11, 7, 8, 8,
            9, 9, 10, 10, 11, 11, 7, 8, 8, 9, 9, 10, 10, 11, 11, 9,
            9, 9, 10, 10, 11, 11, 12, 12, 9, 9, 9, 10, 10, 11, 11, 12,
            12,
    };

    private static float[] _vq_quantthresh__16u0__p5_0 = {
            -3.5f, -2.5f, -1.5f, -0.5f, 0.5f, 1.5f, 2.5f, 3.5f,
    };

    private static int[] _vq_quantmap__16u0__p5_0 = {
            7, 5, 3, 1, 0, 2, 4, 6,
            8,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p5_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p5_0,
            _vq_quantmap__16u0__p5_0,
            9,
            9
    );

    public static StaticCodeBook _16u0__p5_0 = new StaticCodeBook(
            2, 81,
            _vq_lengthlist__16u0__p5_0,
            1, -531628032, 1611661312, 4, 0,
            _vq_quantlist__16u0__p5_0,
            null,
            _vq_auxt__16u0__p5_0,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p6_0 = {
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

    private static int[] _vq_lengthlist__16u0__p6_0 = {
            1, 4, 4, 7, 7, 10, 10, 12, 12, 13, 13, 18, 17, 3, 6, 6,
            9, 9, 11, 11, 13, 13, 14, 14, 18, 17, 3, 6, 6, 9, 9, 11,
            11, 13, 13, 14, 14, 17, 18, 7, 9, 9, 11, 11, 13, 13, 14, 14,
            15, 15, 0, 0, 7, 9, 9, 11, 11, 13, 13, 14, 14, 15, 16, 19,
            18, 10, 11, 11, 13, 13, 14, 14, 16, 15, 17, 18, 0, 0, 10, 11,
            11, 13, 13, 14, 14, 15, 15, 16, 18, 0, 0, 11, 13, 13, 14, 14,
            15, 15, 17, 17, 0, 19, 0, 0, 11, 13, 13, 14, 14, 14, 15, 16,
            18, 0, 19, 0, 0, 13, 14, 14, 15, 15, 18, 17, 18, 18, 0, 19,
            0, 0, 13, 14, 14, 15, 16, 16, 16, 18, 18, 19, 0, 0, 0, 16,
            17, 17, 0, 17, 19, 19, 0, 19, 0, 0, 0, 0, 16, 19, 16, 17,
            18, 0, 19, 0, 0, 0, 0, 0, 0,
    };

    private static float[] _vq_quantthresh__16u0__p6_0 = {
            -27.5f, -22.5f, -17.5f, -12.5f, -7.5f, -2.5f, 2.5f, 7.5f,
            12.5f, 17.5f, 22.5f, 27.5f,
    };

    private static int[] _vq_quantmap__16u0__p6_0 = {
            11, 9, 7, 5, 3, 1, 0, 2,
            4, 6, 8, 10, 12,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p6_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p6_0,
            _vq_quantmap__16u0__p6_0,
            13,
            13
    );

    public static StaticCodeBook _16u0__p6_0 = new StaticCodeBook(
            2, 169,
            _vq_lengthlist__16u0__p6_0,
            1, -526516224, 1616117760, 4, 0,
            _vq_quantlist__16u0__p6_0,
            null,
            _vq_auxt__16u0__p6_0,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p6_1 = {
            2,
            1,
            3,
            0,
            4,
    };

    private static int[] _vq_lengthlist__16u0__p6_1 = {
            1, 4, 5, 6, 6, 4, 6, 6, 6, 6, 4, 6, 6, 6, 6, 6,
            6, 6, 7, 7, 6, 6, 6, 7, 7,
    };

    private static float[] _vq_quantthresh__16u0__p6_1 = {
            -1.5f, -0.5f, 0.5f, 1.5f,
    };

    private static int[] _vq_quantmap__16u0__p6_1 = {
            3, 1, 0, 2, 4,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p6_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p6_1,
            _vq_quantmap__16u0__p6_1,
            5,
            5
    );

    public static StaticCodeBook _16u0__p6_1 = new StaticCodeBook(
            2, 25,
            _vq_lengthlist__16u0__p6_1,
            1, -533725184, 1611661312, 3, 0,
            _vq_quantlist__16u0__p6_1,
            null,
            _vq_auxt__16u0__p6_1,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p7_0 = {
            1,
            0,
            2,
    };

    private static int[] _vq_lengthlist__16u0__p7_0 = {
            1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
            8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
            8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
            7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
            7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
            7,
    };

    private static float[] _vq_quantthresh__16u0__p7_0 = {
            -157.5f, 157.5f,
    };

    private static int[] _vq_quantmap__16u0__p7_0 = {
            1, 0, 2,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p7_0 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p7_0,
            _vq_quantmap__16u0__p7_0,
            3,
            3
    );

    public static StaticCodeBook _16u0__p7_0 = new StaticCodeBook(
            4, 81,
            _vq_lengthlist__16u0__p7_0,
            1, -518803456, 1628680192, 2, 0,
            _vq_quantlist__16u0__p7_0,
            null,
            _vq_auxt__16u0__p7_0,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p7_1 = {
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

    private static int[] _vq_lengthlist__16u0__p7_1 = {
            1, 5, 5, 6, 5, 9, 10, 11, 11, 10, 10, 10, 10, 10, 10, 5,
            8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 8,
            9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 8,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 4, 8, 9, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10,
    };

    private static float[] _vq_quantthresh__16u0__p7_1 = {
            -136.5f, -115.5f, -94.5f, -73.5f, -52.5f, -31.5f, -10.5f, 10.5f,
            31.5f, 52.5f, 73.5f, 94.5f, 115.5f, 136.5f,
    };

    private static int[] _vq_quantmap__16u0__p7_1 = {
            13, 11, 9, 7, 5, 3, 1, 0,
            2, 4, 6, 8, 10, 12, 14,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p7_1 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p7_1,
            _vq_quantmap__16u0__p7_1,
            15,
            15
    );

    public static StaticCodeBook _16u0__p7_1 = new StaticCodeBook(
            2, 225,
            _vq_lengthlist__16u0__p7_1,
            1, -520986624, 1620377600, 4, 0,
            _vq_quantlist__16u0__p7_1,
            null,
            _vq_auxt__16u0__p7_1,
            null,
            0
    );

    private static int[] _vq_quantlist__16u0__p7_2 = {
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

    private static int[] _vq_lengthlist__16u0__p7_2 = {
            1, 6, 6, 7, 8, 7, 7, 10, 9, 10, 9, 11, 10, 9, 11, 10,
            9, 9, 9, 9, 10, 6, 8, 7, 9, 9, 8, 8, 10, 10, 9, 11,
            11, 12, 12, 10, 9, 11, 9, 12, 10, 9, 6, 9, 8, 9, 12, 8,
            8, 11, 9, 11, 11, 12, 11, 12, 12, 10, 11, 11, 10, 10, 11, 7,
            10, 9, 9, 9, 9, 9, 10, 9, 10, 9, 10, 10, 12, 10, 10, 10,
            11, 12, 10, 10, 7, 9, 9, 9, 10, 9, 9, 10, 10, 9, 9, 9,
            11, 11, 10, 10, 10, 10, 9, 9, 12, 7, 9, 10, 9, 11, 9, 10,
            9, 10, 11, 11, 11, 10, 11, 12, 9, 12, 11, 10, 10, 10, 7, 9,
            9, 9, 9, 10, 12, 10, 9, 11, 12, 10, 11, 12, 12, 11, 9, 10,
            11, 10, 11, 7, 9, 10, 10, 11, 10, 9, 10, 11, 11, 11, 10, 12,
            12, 12, 11, 11, 10, 11, 11, 12, 8, 9, 10, 12, 11, 10, 10, 12,
            12, 12, 12, 12, 10, 11, 11, 9, 11, 10, 12, 11, 11, 8, 9, 10,
            10, 11, 12, 11, 11, 10, 10, 10, 12, 12, 12, 9, 10, 12, 12, 12,
            12, 12, 8, 10, 11, 10, 10, 12, 9, 11, 12, 12, 11, 12, 12, 12,
            12, 10, 12, 10, 10, 10, 10, 8, 12, 11, 11, 11, 10, 10, 11, 12,
            12, 12, 12, 11, 12, 12, 12, 11, 11, 11, 12, 10, 9, 10, 10, 12,
            10, 12, 10, 12, 12, 10, 10, 10, 11, 12, 12, 12, 11, 12, 12, 12,
            11, 10, 11, 12, 12, 12, 11, 12, 12, 11, 12, 12, 11, 12, 12, 12,
            12, 11, 12, 12, 10, 10, 10, 10, 11, 11, 12, 11, 12, 12, 12, 12,
            12, 12, 12, 11, 12, 11, 10, 11, 11, 12, 11, 11, 9, 10, 10, 10,
            12, 10, 10, 11, 9, 11, 12, 11, 12, 11, 12, 12, 10, 11, 10, 12,
            9, 9, 9, 12, 11, 10, 11, 10, 12, 10, 12, 10, 12, 12, 12, 11,
            11, 11, 11, 11, 10, 9, 10, 10, 11, 10, 11, 11, 12, 11, 10, 11,
            12, 12, 12, 11, 11, 9, 12, 10, 12, 9, 10, 12, 10, 10, 11, 10,
            11, 11, 12, 11, 10, 11, 10, 11, 11, 11, 11, 12, 11, 11, 10, 9,
            10, 10, 10, 9, 11, 11, 10, 9, 12, 10, 11, 12, 11, 12, 12, 11,
            12, 11, 12, 11, 10, 11, 10, 12, 11, 12, 11, 12, 11, 12, 10, 11,
            10, 10, 12, 11, 10, 11, 11, 11, 10,
    };

    private static float[] _vq_quantthresh__16u0__p7_2 = {
            -9.5f, -8.5f, -7.5f, -6.5f, -5.5f, -4.5f, -3.5f, -2.5f,
            -1.5f, -0.5f, 0.5f, 1.5f, 2.5f, 3.5f, 4.5f, 5.5f,
            6.5f, 7.5f, 8.5f, 9.5f,
    };

    private static int[] _vq_quantmap__16u0__p7_2 = {
            19, 17, 15, 13, 11, 9, 7, 5,
            3, 1, 0, 2, 4, 6, 8, 10,
            12, 14, 16, 18, 20,
    };

    public static EncodeAuxThreshMatch _vq_auxt__16u0__p7_2 = new EncodeAuxThreshMatch(
            _vq_quantthresh__16u0__p7_2,
            _vq_quantmap__16u0__p7_2,
            21,
            21
    );

    public static StaticCodeBook _16u0__p7_2 = new StaticCodeBook(
            2, 441,
            _vq_lengthlist__16u0__p7_2,
            1, -529268736, 1611661312, 5, 0,
            _vq_quantlist__16u0__p7_2,
            null,
            _vq_auxt__16u0__p7_2,
            null,
            0
    );

    private static int[] _huff_lengthlist__16u0__single = {
            3, 5, 8, 7, 14, 8, 9, 19, 5, 2, 5, 5, 9, 6, 9, 19,
            8, 4, 5, 7, 8, 9, 13, 19, 7, 4, 6, 5, 9, 6, 9, 19,
            12, 8, 7, 9, 10, 11, 13, 19, 8, 5, 8, 6, 9, 6, 7, 19,
            8, 8, 10, 7, 7, 4, 5, 19, 12, 17, 19, 15, 18, 13, 11, 18,
    };

    public static StaticCodeBook _huff_book__16u0__single = new StaticCodeBook(
            2, 64,
            _huff_lengthlist__16u0__single,
            0, 0, 0, 0, 0,
            null,
            null,
            null,
            null,
            0
    );
}
