package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class BinaryIoTest {

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class BinaryInputTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(BinaryInputTest.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            CheckedFile checkedFilePath = CheckedFile.generateCheckedFile("");
            BinaryIo testTarget = new BinaryIo();

            List<Byte> result = testTarget.inputAsBinary(checkedFilePath);
            assertEquals(result, null);
        }
    }

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class ConvertTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(ConvertTest.class);
        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            BinaryIo testTarget = new BinaryIo();

            String result = testTarget.formatBinaryToHexDump(new ArrayList<Byte>());
            assertEquals(result, null);
        }
    }
}
