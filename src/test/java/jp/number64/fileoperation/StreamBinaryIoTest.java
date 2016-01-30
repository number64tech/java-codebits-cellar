package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class StreamBinaryIoTest {

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class BinaryInputTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(BinaryInputTest.class);

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            createSandbox();
            File testInput = new File(sandBox.getAbsolutePath() + File.separator + "bin.txt");
            try (FileOutputStream writer = new FileOutputStream(testInput)) {
                writer.write(1);
                writer.write(2);
                writer.write(3);
            } catch (Exception e) {
                LOGGER.debug("{}", e);
                fail();
            }
            CheckedFile checkedFilePath = CheckedFile.generateCheckedFile(testInput.getAbsolutePath());

            StreamBinaryIo testTarget = new StreamBinaryIo();
            List<Integer> result = testTarget.inputAsBinary(checkedFilePath);
            assertEquals(3, result.size());
            assertEquals(Integer.valueOf(1), result.get(0));
            assertEquals(Integer.valueOf(2), result.get(1));
            assertEquals(Integer.valueOf(3), result.get(2));
        }
    }

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class FormatTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(FormatTest.class);
        /** padding */
        @Test
        public void case01CheckPadding() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            StreamBinaryIo testTarget = new StreamBinaryIo();

            testTarget.setColSize(5);
            List<Integer> input = new ArrayList<>();
            input.add(Integer.valueOf(1));
            input.add(Integer.valueOf(2));
            input.add(Integer.valueOf(3));
            testTarget.formatBinaryForHexDump(input);

            assertEquals(5, input.size());
            assertEquals(Integer.valueOf(1), input.get(0));
            assertEquals(Integer.valueOf(2), input.get(1));
            assertEquals(Integer.valueOf(3), input.get(2));
            assertEquals(null, input.get(3));
            assertEquals(null, input.get(4));
        }

        /** convert */
        @Test
        public void case02CheckConversion() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            StreamBinaryIo testTarget = new StreamBinaryIo();
            testTarget.setColSize(9);

            List<Integer> pattern01Null = new ArrayList<>();
            pattern01Null.add(null);
            String result01 = testTarget.formatBinaryForHexDump(pattern01Null);
            assertTrue(result01.startsWith(".."));

            List<Integer> pattern02Short = new ArrayList<>();
            pattern02Short.add(Integer.valueOf(0));
            pattern02Short.add(Integer.valueOf(15));
            String result02 = testTarget.formatBinaryForHexDump(pattern02Short);
            assertTrue(result02.startsWith("00 0F"));

            List<Integer> pattern03Separator = new ArrayList<>();
            pattern03Separator.add(null);
            String result03 = testTarget.formatBinaryForHexDump(pattern03Separator);
            assertEquals((2+1)*8-1, result03.indexOf("-"));

            List<Integer> pattern04NewLine = new ArrayList<>();
            for (int i=0 ; i<100 ; i++) {
                pattern04NewLine.add(Integer.valueOf(1));
            }
            String result04 = testTarget.formatBinaryForHexDump(pattern04NewLine);
            assertEquals((2+1)*9-1, result04.indexOf(System.lineSeparator()));
        }
    }

    /**  */
    public static final class DrivingCodeBit extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(DrivingCodeBit.class);

        @Ignore
        @Test
        public void dumpShiftJIS() throws IOException {
            CheckedFile checkedFilePath =
                CheckedFile.generateCheckedFile("src/test/resources/fileoperation/tochigi_sjis_crlf.csv");
            StreamBinaryIo testTarget = new StreamBinaryIo();
            List<Integer> byteList = testTarget.inputAsBinary(checkedFilePath);
            String result = testTarget.formatBinaryForHexDump(byteList);
            LOGGER.debug("\n{}", result);
        }
        @Ignore
        @Test
        public void dumpEucJp() throws IOException {
            CheckedFile checkedFilePath =
                CheckedFile.generateCheckedFile("src/test/resources/fileoperation/tochigi_eucjp_lf.csv");
            StreamBinaryIo testTarget = new StreamBinaryIo();
            List<Integer> byteList = testTarget.inputAsBinary(checkedFilePath);
            String result = testTarget.formatBinaryForHexDump(byteList);
            LOGGER.debug("\n{}", result);
        }
        @Ignore
        @Test
        public void dumpJis() throws IOException {
            CheckedFile checkedFilePath =
                CheckedFile.generateCheckedFile("src/test/resources/fileoperation/tochigi_jis_lf.csv");
            StreamBinaryIo testTarget = new StreamBinaryIo();
            List<Integer> byteList = testTarget.inputAsBinary(checkedFilePath);
            String result = testTarget.formatBinaryForHexDump(byteList);
            LOGGER.debug("\n{}", result);
        }
        @Ignore
        @Test
        public void dumpUtf8() throws IOException {
            CheckedFile checkedFilePath =
                CheckedFile.generateCheckedFile("src/test/resources/fileoperation/tochigi_utf8_lf.csv");
            StreamBinaryIo testTarget = new StreamBinaryIo();
            List<Integer> byteList = testTarget.inputAsBinary(checkedFilePath);
            String result = testTarget.formatBinaryForHexDump(byteList);
            LOGGER.debug("\n{}", result);
        }
        @Ignore
        @Test
        public void dumpUtf32() throws IOException {
            CheckedFile checkedFilePath =
                CheckedFile.generateCheckedFile("src/test/resources/fileoperation/tochigi_utf32_lf.csv");
            StreamBinaryIo testTarget = new StreamBinaryIo();
            List<Integer> byteList = testTarget.inputAsBinary(checkedFilePath);
            String result = testTarget.formatBinaryForHexDump(byteList);
            LOGGER.debug("\n{}", result);
        }
    }
}
