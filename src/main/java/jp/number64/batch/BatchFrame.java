package jp.number64.batch;

import static jp.number64.batch.BatchConsts.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchFrame extends BatchBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchFrame.class);

    /**  */
    public static void main(String[] args) {
        LOGGER.debug("** Hello JavaBatchFrame! ID:{}", config.getProperty(KEY_BATCHID_BATCHFRAME));
    }
}
