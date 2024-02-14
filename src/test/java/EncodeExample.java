/*
 * THIS FILE IS PART OF THE OggVorbis SOFTWARE CODEC SOURCE CODE.
 * USE, DISTRIBUTION AND REPRODUCTION OF THIS LIBRARY SOURCE IS
 * GOVERNED BY A BSD-STYLE SOURCE LICENSE INCLUDED WITH THIS SOURCE
 * IN 'COPYING'. PLEASE READ THESE TERMS BEFORE DISTRIBUTING.
 *
 * THE OggVorbis SOURCE CODE IS (C) COPYRIGHT 1994-2002
 * by the XIPHOPHORUS Company http://www.xiph.org/
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import biniu.ogg.Packet;
import biniu.ogg.Page;
import biniu.ogg.StreamState;
import biniu.vorbis.Block;
import biniu.vorbis.Comment;
import biniu.vorbis.DspState;
import biniu.vorbis.Info;
import biniu.vorbis.VorbisEnc;
import vavi.util.Debug;


/**
 * EncoderVorbis</p>
 * <p>Description: Codec for encoding music files (wav -> ogg) </p>
 *
 * @author Zbigniew Sudnik
 * @version 1.1.0j 2005-05-01 07:00:00
 */
public class EncodeExample {

    static final int READ = 1024;

    void encode(Path wav, Path ogg) throws IOException {

        // take physical pages, weld into a logical stream of packets
        StreamState state = new StreamState();
        // one Ogg bitstream page.  Vorbis packets are inside
        Page page = new Page();
        // one raw packet of data for decode
        Packet packet = new Packet();
        // struct that stores all the static vorbis bitstream settings
        Info info = new Info();
        // struct that stores all the user comments
        Comment comment = new Comment();
        // central working state for the packet->PCM decoder
        DspState dsp = new DspState();
        // local working space for packet->PCM decode
        Block block = new Block(dsp);

        boolean eos = false;

        VorbisEnc encoder = new VorbisEnc();
        InputStream in = new BufferedInputStream(Files.newInputStream(wav));
        OutputStream out = new BufferedOutputStream(Files.newOutputStream(ogg));

        // we cheat on the WAV header; we just bypass the header and never
        // verify that it matches 16bit/stereo/44.1kHz.  This is just an
        // example, after all.
        // out of the data segment, not the stack
        byte[] readBuffer = new byte[READ * 4 + 44];
        readBuffer[0] = '\0';
        byte[] rtab = new byte[2];
        for (int i = 0; i < 30; i++) {
            in.read(rtab);
            if (rtab[0] == 100 && rtab[1] == 97) {
                in.read(readBuffer, 1, 6);
                break;
            }
        }

        // Encode setup

        info.init(); //vorbis_info_init(vi);

        // choose an encoding mode.  A few possibilities commented out, one
        // actually used:

        // Encoding using a VBR quality mode.  The usable range is -.1
        // (lowest quality, smallest file) to 1. (highest quality, largest file).
        // Example quality mode .4: 44kHz stereo coupled, roughly 128kbps VBR
        // ret = vorbis_encode_init_vbr(&vi,2,44100,.4);
        // ---------------------------------------------------------------------
        // Encoding using an average bitrate mode (ABR).
        // example: 44kHz stereo coupled, average 128kbps VBR
        // ret = vorbis_encode_init(&vi,2,44100,-1,128000,-1);
        // ---------------------------------------------------------------------
        // Encode using a quality mode, but select that quality mode by asking for
        // an approximate bitrate.  This is not ABR, it is true VBR, but selected
        // using the bitrate interface, and then turning bitrate management off:
        // ret = ( vorbis_encode_setup_managed(&vi,2,44100,-1,128000,-1) ||
        // vorbis_encode_ctl(&vi,OV_ECTL_RATEMANAGE2_SET,NULL) ||
        // vorbis_encode_setup_init(&vi));

        int ret = encoder.initVBR(info, 2, 44100, 0.1f);

        // do not continue if setup failed; this can happen if we ask for a
        // mode that libVorbis does not support (eg, too low a bitrate, etc.,
        // will return 'OV_EIMPL')

        if (ret != 0)
            throw new IllegalStateException("initVBR: unexpected return value: " + ret);

        // add a comment
        comment.init();
        comment.addTag("ENCODER", "jVorbisEnc");

        // set up the analysis state and auxiliary encoding storage
        dsp.analysisInit(info);
        block.blockInit(dsp);

        // set up our packet.stream encoder
        // pick a random serial number; that way we can more likely build
        // chained streams just by concatenation
        Random rand = new Random(314159265358979L); // for test
        state.init(rand.nextInt());

        // Vorbis streams begin with three headers; the initial header (with
        // most of the codec setup parameters) which is mandated by the Ogg
        // bitstream spec.  The second header holds any comment fields.  The
        // third header holds the bitstream codebook.  We merely need to
        // make the headers, then pass them to libvorbis one at a time;
        // libvorbis handles the additional Ogg bitstream constraints

        {
            Packet header = new Packet();
            Packet headerComm = new Packet();
            Packet headerCode = new Packet();

            dsp.analysisHeaderOut(comment, header, headerComm, headerCode);

            // automatically placed in its own page
            state.packetIn(header);
            state.packetIn(headerComm);
            state.packetIn(headerCode);
            // This ensures the actual audio data will start on a new page, as per spec
            while (!eos) {
                boolean result = state.flush(page);
                if (!result)
                    break;
                out.write(page.header_base, page.header, page.header_len);
                out.write(page.body_base, page.body, page.body_len);
            }
        }

        while (!eos) {
            int bytes = 0;
            // stereo hardwired here
            bytes = in.read(readBuffer, 0, READ * 4);
            if (bytes == 0) {
                // end of file.  this can be done implicitly in the mainline,
                // but it's easier to see here in non-clever fashion.
                // Tell the library we're at end of stream so that it can handle
                // the last frame and mark end of stream in the output properly */
                dsp.analysisWrote(0);

            } else {
                // data to encode

                // expose the buffer to submit data
                float[][] buffer = dsp.analysisBuffer(READ);

                // uninterleave samples
                for (int i = 0, l = dsp.pcm_current; i < bytes / 4; i++, l++) {
                    buffer[0][l] = ((readBuffer[i * 4 + 1] << 8) |
                            (0x00ff & (int) readBuffer[i * 4])) / 32768.f;
                    buffer[1][l] = ((readBuffer[i * 4 + 3] << 8) |
                            (0x00ff & (int) readBuffer[i * 4 + 2])) / 32768.f;
                }

                // tell the library how much we actually submitted
                dsp.analysisWrote(bytes / 4);
            }

            // vorbis does some data preanalysis, then divvies up blocks for
            // more involved (potentially parallel) processing. Get a single
            // block for encoding now
            while (block.analysisBlockOut()) {
                // analysis, assume we want to use bitrate management
                block.analysis(null);
                block.bitrateAddBlock();

                while (dsp.bitrateFlushPacket(packet)) {
                    // weld the packet into the bitstream
                    state.packetIn(packet);
                    // write out pages (if any)
                    while (!eos) {
                        boolean result = state.pageOut(page);
                        if (!result)
                            break;
                        out.write(page.header_base, page.header, page.header_len);
                        out.write(page.body_base, page.body, page.body_len);

                        // this could be set above, but for illustrative purposes, I do
                        // it here (to show that vorbis does know where the stream ends)
                        if (page.eos())
                            eos = true;
                    }
                }
            }
        }

        // Clean up and exit.  vorbis_info_clear() must be called last
        state.clear();
        block.clear();
        dsp.clear();
        comment.clear();
        info.clear();

        // ogg_page and ogg_packet structs always point to storage in
        // libvorbis. They're never freed or manipulated directly
        Debug.println("Done.");
    }

    /**
     * @param args 0: wav, 1: out
     */
    public static void main(String[] args) throws Exception {
        Path wav = Path.of(args[0]);
        Path ogg = Path.of(args[1]);
        if (!Files.exists(ogg.getParent())) {
            Files.createDirectories(ogg.getParent());
        }
        EncodeExample app = new EncodeExample();
        app.encode(wav, ogg);
    }
}