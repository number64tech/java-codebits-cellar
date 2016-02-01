package jp.number64.fileoperation;

import java.io.File;
import java.io.FileFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileClassSample {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileClassSample.class);

    public static final String WORKING_DIRECTORY_TOP = "./var";

    /**
     * File search sample. <br>
     * @see java.io.File#listFiles(java.io.FileFilter)
     */
    public File[] searchDirExceptForDir(String targetPath) {
        LOGGER.debug("** java.io.File#listFiles(FileFilter)");

        File targetDir = new File(targetPath);
        if (!targetDir.isDirectory()) {
            LOGGER.debug("** invalid path : {}", targetPath);
            return null;
        }

        LOGGER.debug("** targetDir : {}", targetDir.getAbsolutePath());
        File[] result = targetDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isDirectory();
            }
        });

        return result;
    }

    /**
     * File rename sample. <br>
     * note: renameTo() can't move file to another filesystem (because of not atmic).
     * @see java.io.File#renameTo(File)
     */
    public void renameTo(String targetFilePath, String destFilePath) {
        LOGGER.debug("** java.io.File#renameTo(File)");

        File inputFile = new File(targetFilePath);
        LOGGER.debug("** inputFile : {}", inputFile.getAbsolutePath());
        File outputFile = new File(destFilePath);
        LOGGER.debug("** outputFile: {}", outputFile.getAbsolutePath());

        try {
            if (inputFile.renameTo(outputFile)) {
                LOGGER.debug("** #renameTo() succeed.");
            } else {
                LOGGER.debug("** #renameTo() failed.");
            }
        } catch (SecurityException e) {
           LOGGER.debug("** an error occured. {}", e.getMessage());
        } catch (NullPointerException e) {
           LOGGER.debug("** an error occured. {}", e.getMessage());
        }
    }
}
