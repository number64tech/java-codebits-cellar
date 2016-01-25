package jp.number64.fileoperation;

import jp.number64.fileoperation.RunningFileClassSampleTest.TestRenameTo;

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
    TestRenameTo.class,
})
public class RunningFileClassSampleTest extends FileTestBase {

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class TestRenameTo {
        private static final Logger LOGGER = LoggerFactory.getLogger(TestRenameTo.class);

        @Test
        public void case01() {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
        }
    }

    @Override
    public String getTestClassName() {
        return "FileClassSampleTest";
    }
}
