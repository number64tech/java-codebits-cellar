package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.IOException;

import jp.number64.fileoperation.RunningShiftJisToUnicodeEscTest.ShiftJISInputTest;
import jp.number64.fileoperation.RunningShiftJisToUnicodeEscTest.UnicodeEscapeTest;

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
    ShiftJISInputTest.class,
    UnicodeEscapeTest.class,
})
public class RunningShiftJisToUnicodeEscTest {
    public static final String START_LOG = "** START: {}";

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class ShiftJISInputTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(ShiftJISInputTest.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            assertEquals(null, "");
        }

        @Override
        public String getTestClassName() {
            return "ShiftJISInputTest";
        }
    }

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class UnicodeEscapeTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(UnicodeEscapeTest.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            assertEquals(null, "");
        }

        @Override
        public String getTestClassName() {
            return "UnicodeEscapeTest";
        }
    }
}
