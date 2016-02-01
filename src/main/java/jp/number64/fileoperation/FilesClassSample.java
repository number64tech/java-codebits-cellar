package jp.number64.fileoperation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilesClassSample {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilesClassSample.class);


    /**
     * Capture a web page, and Write it to local file. <br>
     * @param targetUri InputStream target
     * @param outputPath Output target (filepath)
     * @return a copy of captured file
     * @see java.nio.file.Files#copy(java.nio.file.Path, java.io.OutputStream)
     */
    public Path captureAndSaveWebPage(String targetUri, String outputPath) throws IOException {
        LOGGER.debug("** captureAndSaveWebPage");

        LOGGER.debug("** URI: {}", targetUri);
        LOGGER.debug("** FILEPATH: {}", outputPath);

        Path tempPath = new File(outputPath + ".tmp").toPath();
        URI uri = URI.create(targetUri);

        Path returnFile = null;
        try (InputStream in = uri.toURL().openStream()) {
            long capturedSize = Files.copy(in, tempPath);
            LOGGER.debug("** captureSize: {}", capturedSize);

            returnFile = new File(outputPath).toPath();
            Files.copy(tempPath, returnFile,
                StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
        }

        return returnFile;
    }
}
