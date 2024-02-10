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


/**
 * EncoderVorbis</p>
 * <p>Description: Codec for encoding music files (wav -> ogg) </p>
 *
 * @author Zbigniew Sudnik
 * @version 1.1.0j 2005-05-01 07:00:00
 */
public class EncodeExample {

    public static int READ = 1024;
    // out of the data segment, not the stack
    private byte[] readbuffer = new byte[READ * 4 + 44];
    private InputStream fread;
    private OutputStream fwrite;

    int encode(Path wav, Path ogg) throws IOException {

        // take physical pages, weld into a logical stream of packets
        StreamState os = new StreamState();
        // one Ogg bitstream page.  Vorbis packets are inside
        Page og = new Page();
        // one raw packet of data for decode
        Packet op = new Packet();
        // struct that stores all the static vorbis bitstream settings
        Info vi = new Info();
        // struct that stores all the user comments
        Comment vc = new Comment();
        // central working state for the packet->PCM decoder
        DspState vd = new DspState();
        // local working space for packet->PCM decode
        Block vb = new Block(vd);

        boolean eos = false;
        int ret;
        int i, founddata;

        VorbisEnc ve = new VorbisEnc();
        fread = new BufferedInputStream(Files.newInputStream(wav));
        fwrite = new BufferedOutputStream(Files.newOutputStream(ogg));

        // we cheat on the WAV header; we just bypass the header and never
        // verify that it matches 16bit/stereo/44.1kHz.  This is just an
        // example, after all.
        readbuffer[0] = '\0';
        byte[] rtab = new byte[2];
        for (i = 0, founddata = 0; i < 30; i++) {
            try {
                fread.read(rtab);
                if (rtab[0] == 100 && rtab[1] == 97) {
                    founddata = 1;
                    fread.read(readbuffer, 1, 6);
                    break;
                }
            } catch (IOException ioe) {
            }
        }

        // Encode setup

        vi.init(); //vorbis_info_init(vi);

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

        ret = ve.initVBR(vi, 2, 44100, 0.1f);

        // do not continue if setup failed; this can happen if we ask for a
        // mode that libVorbis does not support (eg, too low a bitrate, etc.,
        // will return 'OV_EIMPL')

        if (ret != 0)
            System.exit(1);

        // add a comment
        vc.init();
        vc.addTag("ENCODER", "jVorbisEnc");

        // set up the analysis state and auxiliary encoding storage
        vd.analysisInit(vi);
        vb.blockInit(vd);

        // set up our packet.stream encoder
        // pick a random serial number; that way we can more likely build
        // chained streams just by concatenation
        Random rand = new Random();
        os.init(rand.nextInt());

        // Vorbis streams begin with three headers; the initial header (with
        // most of the codec setup parameters) which is mandated by the Ogg
        // bitstream spec.  The second header holds any comment fields.  The
        // third header holds the bitstream codebook.  We merely need to
        // make the headers, then pass them to libvorbis one at a time;
        // libvorbis handles the additional Ogg bitstream constraints

        {
            Packet header = new Packet();
            Packet header_comm = new Packet();
            Packet header_code = new Packet();

            vd.analysisHeaderOut(vc, header, header_comm, header_code);

            // automatically placed in its own page
            os.packetIn(header);
            os.packetIn(header_comm);
            os.packetIn(header_code);
            // This ensures the actual audio data will start on a new page, as per spec
            while (!eos) {
                boolean result = os.flush(og);
                if (!result)
                    break;
                try {
                    fwrite.write(og.header_base, og.header, og.header_len);
                    fwrite.write(og.body_base, og.body, og.body_len);
                } catch (IOException ioe) {
                }
            }
        }

        int pos = 0;
        while (!eos) {
            int bytes = 0;
            int l;
            try {
                // stereo hardwired here
                bytes = fread.read(readbuffer, 0, READ * 4);
            } catch (IOException ioe) {
            }
            if (bytes == 0) {
                // end of file.  this can be done implicitly in the mainline,
                // but it's easier to see here in non-clever fashion.
                // Tell the library we're at end of stream so that it can handle
                // the last frame and mark end of stream in the output properly */
                vd.analysisWrote(0);

            } else {
                // data to encode

                // expose the buffer to submit data
                float[][] buffer = vd.analysisBuffer(READ);

                // uninterleave samples
                for (i = 0, l = vd.pcm_current; i < bytes / 4; i++, l++) {
                    buffer[0][l] = ((readbuffer[i * 4 + 1] << 8) |
                            (0x00ff & (int) readbuffer[i * 4])) / 32768.f;
                    buffer[1][l] = ((readbuffer[i * 4 + 3] << 8) |
                            (0x00ff & (int) readbuffer[i * 4 + 2])) / 32768.f;
                }

                // tell the library how much we actually submitted
                vd.analysisWrote(i);
            }

            // vorbis does some data preanalysis, then divvies up blocks for
            // more involved (potentially parallel) processing. Get a single
            // block for encoding now
            while (vb.analysisBlockOut()) {
                // analysis, assume we want to use bitrate management
                vb.analysis(null);
                vb.bitrateAddBlock();

                while (vd.bitrateFlushPacket(op)) {
                    // weld the packet into the bitstream
                    os.packetIn(op);
                    // write out pages (if any)
                    while (!eos) {
                        boolean result = os.pageOut(og);
                        if (!result)
                            break;
                        try {
                            fwrite.write(og.header_base, og.header, og.header_len);
                            fwrite.write(og.body_base, og.body, og.body_len);
                        } catch (IOException ioe) {
                        }

                        // this could be set above, but for illustrative purposes, I do
                        // it here (to show that vorbis does know where the stream ends)
                        if (og.eos())
                            eos = true;

                    }
                }
            }
        }

        // Clean up and exit.  vorbis_info_clear() must be called last
        os.clear();
        vb.clear();
        vd.clear();
        vc.clear();
        vi.clear();

        // ogg_page and ogg_packet structs always point to storage in
        // libvorbis. They're never freed or manipulated directly
        System.out.println("Done.\n");

        return 0;
    }

    public EncodeExample() {
    }

    /**
     * @param arg 0: wav, 1: out
     */
    public static void main(String[] arg) throws Exception {
        Path wav = Path.of(arg[0]);
        Path ogg = Path.of(arg[1]);
        if (!Files.exists(ogg.getParent())) {
            Files.createDirectories(ogg.getParent());
        }
        EncodeExample encodeExample = new EncodeExample();
        encodeExample.encode(wav, ogg);
    }
}