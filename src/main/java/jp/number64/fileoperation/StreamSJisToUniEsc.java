package jp.number64.fileoperation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamSJisToUniEsc {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamSJisToUniEsc.class);

    private String targetFilePath = null;

    /** Input file as ShiftJIS, Keep chars as Unicode-String (Java default). */
    public String inputAsShiftJIS() throws IOException {
        LOGGER.debug("** start #inputAsShiftJIS()");

        // three-piece set. somewhat classical...
        // when reader#close() is called by try-with-resources syntax, reader#close() calls InputStreamReader#close(),
        // and InputStreamReader#close() calls FileInputStream#close().
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(targetFilePath), "MS932"))) {

        } catch (IOException e) {
            throw e;
        }

        LOGGER.debug("** end #inputAsShiftJIS()");
        return null;
    }

    public String formatStringToEscapedUnicode(String input) {
        return null;
    }
}
