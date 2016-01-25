package jp.number64.fileoperation;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckedFile extends File {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckedFile.class);

    private CheckedFile(String targetFilePath) {
        super(targetFilePath);
    }

    public static CheckedFile generateCheckedFile(String targetFilePath) throws IOException {
        LOGGER.debug("** targetFilePath:{}", targetFilePath);
        File checking = new File(targetFilePath);
        if (!checking.exists()) {
            throw new IOException(targetFilePath + " is not exist, or unreadable.");
        }
        if (!checking.isFile()) {
            throw new IOException(targetFilePath + " is not a file.");
        }
        LOGGER.debug("** check OK.");
        return new CheckedFile(targetFilePath);
    }
}
