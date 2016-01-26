package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RunWith(Suite.class)
//@SuiteClasses({
//    TestShiftJISInput.class,
//    TestUnicodeEscape.class,
//})
public class ShiftJisToUnicodeEscTest {
    public static final String START_LOG = "** START: {}";

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class TestShiftJISInput extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(TestShiftJISInput.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            assertEquals(null, "");
        }
    }

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class TestUnicodeEscape extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(TestUnicodeEscape.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            assertEquals(null, "");
        }
    }
}
