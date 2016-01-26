package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.File;
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
public class StreamBinaryIoTest {

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class DrivingCodeBit extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(DrivingCodeBit.class);

        @Test
        public void doIt() throws IOException {
            CheckedFile checkedFilePath = CheckedFile.generateCheckedFile("fileoperation/tochigi_sjis_crlf.csv");
            StreamBinaryIo testTarget = new StreamBinaryIo();
            List<Byte> textToByteList = testTarget.inputAsBinary(checkedFilePath);
            String byteListToHexString = testTarget.convertBinaryToHexString(textToByteList);
            String result = testTarget.formatHexStringForDump(byteListToHexString);
            LOGGER.debug("\n{}", result);
        }
    }

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class BinaryInputTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(BinaryInputTest.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));

            // TODO: output binarydata to file, and input it, and compare.
            File testInput = new File(sandBox.getAbsolutePath() + File.separator + "bin.txt");

            CheckedFile checkedFilePath = CheckedFile.generateCheckedFile("");
            StreamBinaryIo testTarget = new StreamBinaryIo();

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
            StreamBinaryIo testTarget = new StreamBinaryIo();

            // TODO: output binarydata to file, and input it, and compare.

            String result = testTarget.convertBinaryToHexString(new ArrayList<Byte>());
            assertEquals(result, null);
        }
    }
}
