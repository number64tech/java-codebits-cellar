package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.number64.fileoperation.BinaryIo;
import jp.number64.fileoperation.CheckedFile;
import jp.number64.fileoperation.RunningBinaryIoTest.BinaryInputTest;
import jp.number64.fileoperation.RunningBinaryIoTest.ConvertTest;

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
    BinaryInputTest.class,
    ConvertTest.class
})
public class RunningBinaryIoTest {
    public static final String START_LOG = "** START: {}";

    /**  */
    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public static final class BinaryInputTest {
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
    public static final class ConvertTest {
        private static final Logger LOGGER = LoggerFactory.getLogger(ConvertTest.class);
        @Test
        public void case01() throws IOException {
            LOGGER.debug(START_LOG, getMethodName(new Throwable()));
            BinaryIo testTarget = new BinaryIo();

            String result = testTarget.formatBinaryToHexDump(new ArrayList<Byte>());
            assertEquals(result, null);
        }
    }

    // ----------------------------------------------------------------------------------------
    public static String getMethodName(final Throwable thisMethod) {
        StackTraceElement stackTrace = thisMethod.getStackTrace()[0];
        return stackTrace.getMethodName();
    }
}
