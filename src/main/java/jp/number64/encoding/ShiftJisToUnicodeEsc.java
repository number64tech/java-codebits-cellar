package jp.number64.encoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiftJisToUnicodeEsc {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiftJisToUnicodeEsc.class);

    private String targetFilePath = null;

    public void setUp(String targetFilePath) throws IOException {
        LOGGER.debug("** start #setup()  targetFilePath:{}", targetFilePath);

        File target = new File(targetFilePath);
        // isExist
        if (!target.exists()) {
            throw new IOException(targetFilePath + " is not exist, or unreadable.");
        }
        // isFile
        if (!target.isFile()) {
            throw new IOException(targetFilePath + " is not a file.");
        }

        this.targetFilePath = targetFilePath;
        LOGGER.debug("** finish #setup()  kept filepath.");
    }

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
