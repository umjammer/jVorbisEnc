/*
 * Copyright (c) 2024 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vavi.util.properties.annotation.Property;
import vavi.util.properties.annotation.PropsEntity;
import vavix.util.Checksum;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test1.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2024-02-14 nsano initial version <br>
 */
@PropsEntity(url = "file:local.properties")
public class Test1 {

    static boolean localPropertiesExists() {
        return Files.exists(Paths.get("local.properties"));
    }

    @BeforeEach
    void setup() throws Exception {
        if (localPropertiesExists()) {
            PropsEntity.Util.bind(this);
        }
    }

    @Property
    String wav = "src/test/resources/test.wav";

    @Property
    String ogg = "src/test/resources/test.ogg";

    @Test
    void test1() throws Exception {
        Path in = Path.of(wav);
        Path out = Path.of("tmp", "out2.ogg");
        if (!Files.exists(out.getParent())) {
            Files.createDirectories(out.getParent());
        }
        EncodeExample encodeExample = new EncodeExample();
        encodeExample.encode(in, out);

        assertEquals(Checksum.getChecksum(out), Checksum.getChecksum(Paths.get(ogg)));
    }
}
