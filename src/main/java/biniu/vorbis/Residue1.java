/*
 * THIS FILE IS PART OF THE OggVorbis SOFTWARE CODEC SOURCE CODE.
 * USE, DISTRIBUTION AND REPRODUCTION OF THIS LIBRARY SOURCE IS
 * GOVERNED BY A BSD-STYLE SOURCE LICENSE INCLUDED WITH THIS SOURCE
 * IN 'COPYING'. PLEASE READ THESE TERMS BEFORE DISTRIBUTING.
 *
 * THE OggVorbis SOURCE CODE IS (C) COPYRIGHT 1994-2002
 * by the XIPHOPHORUS Company http://www.xiph.org/
 */

package biniu.vorbis;

import biniu.ogg.Buffer;

/**
 * EncoderVorbis</p>
 * <p>Description: Codec for encoding music files (wav -> ogg) </p>
 * @author Zbigniew Sudnik
 * @version 1.1.0j 2005-05-01 07:00:00
 */
public class Residue1 extends Residue0 {

    @Override
    public int inverse(Block vb, LookResidue vl, float[][] in, int[] nonzero, int ch) {

        int used = 0;
        for (int i = 0; i < ch; i++) {
            if (nonzero[i] != 0) {
                in[used++] = in[i];
            }
        }
        if (used != 0) {
            return (_01inverse(vb, vl, in, used, 1));
        } else {
            return 0;
        }
    }

    @Override
    public int[][] clas(LookResidue vl,
                        float[][] in, int pin, int[] nonzero, int ch) {
        int i, used = 0;
        for (i = 0; i < ch; i++)
            if (nonzero[i] != 0)
                in[used++] = in[i];
        if (used != 0)
            return (_01class(vl, in, pin, used));
        else
            return null;
    }

    @Override
    public int forward(Buffer opb, Block vb, LookResidue vl,
                       float[][] in, float[][] out, int[] nonzero, int ch,
                       int[][] partword) {
        int i, j, used = 0, n = vb.pcmEnd / 2;
        for (i = 0; i < ch; i++)
            if (nonzero[i] != 0) {
                if (out != null)
                    for (j = 0; j < n; j++)
                        out[i][j] += in[i][j];
                in[used++] = in[i];
            }

        if (used != 0) {
            int ret = _01forward(opb, vb, vl, in, used, partword);
            if (out != null) {
                used = 0;
                for (i = 0; i < ch; i++)
                    if (nonzero[i] != 0) {
                        for (j = 0; j < n; j++)
                            out[i][j] -= in[used][j];
                        used++;
                    }
            }
            return ret;
        } else {
            return 0;
        }
    }
}
