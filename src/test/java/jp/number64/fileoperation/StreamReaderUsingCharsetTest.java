package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

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
public class StreamReaderUsingCharsetTest {
    public static final String START_LOG = "** START: {}";

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class ShiftJISInputTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(ShiftJISInputTest.class);
        private static final Charset USING_CHARSET = Charset.forName("Windows-31j");

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            levelOffSandBox();
            File testInput = new File(sandBox.getAbsolutePath() + File.separator + "sjis01.txt");
            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(testInput), USING_CHARSET)) {
                writer.write("\u3066\u3059\u3068");
            }
            CheckedFile checkedFilePath = CheckedFile.generateCheckedFile(testInput.getAbsolutePath());
            StreamReaderUsingCharset testTarget = new StreamReaderUsingCharset();
            CharBuffer result = testTarget.inputAsShiftJISWinExtended(checkedFilePath);

            assertEquals("\u3066", String.valueOf(result.get()));
            assertEquals("\u3059", String.valueOf(result.get()));
            assertEquals("\u3068", String.valueOf(result.get()));
            result.rewind();
            assertEquals("\u3066", String.valueOf(result.get()));
            result.mark();
            assertEquals("\u3059", String.valueOf(result.get()));
            assertEquals("\u3068", String.valueOf(result.get()));
            result.reset();
            assertEquals("\u3059", String.valueOf(result.get()));
        }
    }

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class EucJpInputTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(EucJpInputTest.class);
        private static final Charset USING_CHARSET = Charset.forName("EUC-JP");

        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            levelOffSandBox();
            File testInput = new File(sandBox.getAbsolutePath() + File.separator + "euc.txt");
            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(testInput), USING_CHARSET)) {
                writer.write("\u3044\u30fc\u3086\u30fc\u3057\u30fc");
            }
            CheckedFile checkedFilePath = CheckedFile.generateCheckedFile(testInput.getAbsolutePath());
            StreamReaderUsingCharset testTarget = new StreamReaderUsingCharset();
            CharBuffer result = testTarget.inputAsEucJp(checkedFilePath);

            assertEquals("\u3044", String.valueOf(result.get()));
            assertEquals("\u30fc", String.valueOf(result.get()));
            assertEquals("\u3086", String.valueOf(result.get()));
            assertEquals("\u30fc", String.valueOf(result.get()));
            assertEquals("\u3057", String.valueOf(result.get()));
            assertEquals("\u30fc", String.valueOf(result.get()));
            assertEquals(0, result.get());
        }
    }

    //------------------------------------------------------------------------------------------------------

    /**  */
    public static final class ListUp {
        public void experiment() {
            StreamReaderUsingCharset.listupAvailabeCharsets();
        }
    }

    /**  */
    public static final class Dump {
        private static final Logger LOGGER = LoggerFactory.getLogger(Dump.class);
        public void experiment() throws IOException {
            CheckedFile checkedFilePath =
                CheckedFile.generateCheckedFile("src/test/resources/fileoperation/tochigi_sjis_crlf.csv");
            StreamReaderUsingCharset testTarget = new StreamReaderUsingCharset();
            CharBuffer result = testTarget.inputAsShiftJISWinExtended(checkedFilePath);
            while(result.hasRemaining()) {
                LOGGER.debug("readResult: {}", String.valueOf(result.get()));
            }
        }
    }
}
