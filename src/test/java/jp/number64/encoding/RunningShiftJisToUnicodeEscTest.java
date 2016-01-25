package jp.number64.encoding;

import static org.junit.Assert.*;

import java.io.IOException;

import jp.number64.encoding.RunningShiftJisToUnicodeEscTest.ShiftJISInputTest;
import jp.number64.encoding.RunningShiftJisToUnicodeEscTest.UnicodeEscapeTest;

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
    public static final class ShiftJISInputTest {
        private static final Logger LOGGER = LoggerFactory.getLogger(ShiftJISInputTest.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            ShiftJisToUnicodeEsc testTarget = new ShiftJisToUnicodeEsc();
            testTarget.setUp("");

            assertEquals(null, "");
        }
    }

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class UnicodeEscapeTest {
        private static final Logger LOGGER = LoggerFactory.getLogger(UnicodeEscapeTest.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            ShiftJisToUnicodeEsc testTarget = new ShiftJisToUnicodeEsc();
            testTarget.setUp("");

            assertEquals(null, "");
        }
    }

    // ----------------------------------------------------------------------------------------
    public static String getMethodName(final Throwable thisMethod) {
        StackTraceElement stackTrace = thisMethod.getStackTrace()[0];
        return stackTrace.getMethodName();
    }
}
