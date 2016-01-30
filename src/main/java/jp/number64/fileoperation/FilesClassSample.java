package jp.number64.fileoperation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilesClassSample {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilesClassSample.class);

    /**
     * Capture a web page, and Write it to local file. <br>
     * @param targetUri InputStream target
     * @param outputPath Output target (filepath)
     * @return captured text
     * @see java.nio.file.Files#copy(java.nio.file.Path, java.io.OutputStream)
     */
    public String captureAndSaveWebPage(String targetUri, String outputPath) throws IOException {
        LOGGER.debug("** captureAndSaveWebPage");

        LOGGER.debug("** URI: {}", targetUri);
        LOGGER.debug("** FILEPATH: {}", outputPath);

        File outputFile = new File(outputPath);
        if (!outputFile.getParentFile().isDirectory()) {
            throw new IOException("Invalid path: not directory.");
        }
        Path path = outputFile.toPath();

        URI uri = URI.create(targetUri);

        try (InputStream in = uri.toURL().openStream()) {
           // Long captureSize = Files.copy(uri.in, target, options)

        }

        return null;
    }


}
