package jp.number64.batch;

import jp.number64.TestBase;
import jp.number64.batch.RunningBatchFrameTest.BatchFrameTest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Suite.class)
@SuiteClasses({
    BatchFrameTest.class,
})
public class RunningBatchFrameTest extends TestBase {

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class BatchFrameTest {
        private static final Logger LOGGER = LoggerFactory.getLogger(BatchFrameTest.class);

        @Test
        public void case01() {
            LOGGER.debug("");
            String[] args = {"",""};
            BatchFrame.main(args);
        }
    }

}
