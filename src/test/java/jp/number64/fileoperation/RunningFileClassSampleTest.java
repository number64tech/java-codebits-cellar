package jp.number64.fileoperation;

import java.io.IOException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RunWith(Suite.class)
//@SuiteClasses({
//    TestRenameTo.class,
//})
public class RunningFileClassSampleTest {

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class RenameToTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(RenameToTest.class);

        @Test
        public void case01() {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
        }

        @Before
        public void doBefore() throws IOException {
            levelOffSandBox();
        }
    }
}
