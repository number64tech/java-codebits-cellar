package jp.number64.batch;

import static jp.number64.batch.BatchConsts.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchFrame {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchFrame.class);

    private static Properties config = new Properties();
    static {
        try (InputStream in = BatchBase.class.getResourceAsStream(BatchConsts.PROPERTIES_CLASSPATH)) {
            if (in == null) {
                throw new RuntimeException("resource: " + BatchConsts.PROPERTIES_CLASSPATH + " not found.");
            }
            config.load(in);
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**  */
    public static void main(String[] args) {
        LOGGER.debug("** Hello JavaBatchFrame! ID:{}", config.getProperty(KEY_BATCHID_BATCHFRAME));
    }
}
