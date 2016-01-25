package jp.number64.encoding;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BinaryIo {
    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryIo.class);

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

    public Byte[] inputAsBinary() throws IOException {
        LOGGER.debug("** start #inputAsBinary()");

        try (BufferedInputStream bufStr = new BufferedInputStream(new FileInputStream(targetFilePath)))    {

        } catch (IOException e) {
            throw e;
        }

        LOGGER.debug("** end #inputAsBinary()");
        return null;
    }

    public String formatBinaryToHexDump(Byte[] input) {
        return null;
    }

}
