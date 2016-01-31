package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckedFileTest extends FileTestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckedFileTest.class);

    @Test
    public void case01() throws IOException {
        String tempFileName = "temp.txt";
        File tempTarget = new File(sandBox.getAbsolutePath() + File.separator + tempFileName);
        assertTrue(tempTarget.createNewFile());
        CheckedFile.generateCheckedFile(tempTarget.getAbsolutePath());
        LOGGER.debug("** case01 OK.");
    }

    /** not exsit file */
    @Test(expected = IOException.class)
    public void case02() throws IOException {
        LOGGER.debug("** case02 expected = IOException.class");
        CheckedFile.generateCheckedFile("/dummy.txt");
    }

    /** not file (but directory) */
    @Test(expected = IOException.class)
    public void case03() throws IOException {
        LOGGER.debug("** case03 expected = IOException.class");
        CheckedFile.generateCheckedFile(sandBox.getAbsolutePath());
    }
}
