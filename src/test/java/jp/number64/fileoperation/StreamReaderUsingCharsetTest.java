package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RunWith(Suite.class)
//@SuiteClasses({
//    TestShiftJISInput.class,
//    TestUnicodeEscape.class,
//})
public class StreamReaderUsingCharsetTest {
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
    }

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class ListUp {
        @Ignore
        @Test
        public void doIt() {
            StreamReaderUsingCharset.listupAvailabeCharsets();
        }
    }
}
