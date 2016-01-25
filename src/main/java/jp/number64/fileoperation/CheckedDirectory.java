package jp.number64.fileoperation;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckedDirectory extends File {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckedDirectory.class);

    private CheckedDirectory(String targetDirPath) {
        super(targetDirPath);
    }

    public static CheckedDirectory generateCheckedDirectory(String targetDirPath) throws IOException {
        LOGGER.debug("** targetDirPath:{}", targetDirPath);
        File checking = new File(targetDirPath);
        if (!checking.exists()) {
            throw new IOException(targetDirPath + " is not exist, or unreadable.");
        }
        if (!checking.isDirectory()) {
            throw new IOException(targetDirPath + " is not a directory.");
        }
        LOGGER.debug("** check OK.");
        return new CheckedDirectory(targetDirPath);
    }
}
