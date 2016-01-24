package jp.number64.batch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class BatchBase {

    protected static final Properties config = new Properties();

    public BatchBase() throws RuntimeException {
        try (InputStream in = BatchBase.class.getResourceAsStream(BatchConsts.PROPERTIES_CLASSPATH)) {
            if (in == null) {
                throw new RuntimeException("resource: " + BatchConsts.PROPERTIES_CLASSPATH + " not found.");
            }
            config.load(in);
        } catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
