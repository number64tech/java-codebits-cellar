package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckedDirTest extends FileTestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckedDirTest.class);

    @Test
    public void case01() throws IOException {
        String tempDirName = "temp";
        File tempTarget = new File(sandBox.getAbsolutePath() + File.separator + tempDirName);
        assertTrue(tempTarget.mkdir());
        CheckedDirectory.generateCheckedDirectory(tempTarget.getAbsolutePath());
        LOGGER.debug("** case01 OK.");
    }

    @Test(expected = IOException.class)
    public void case02() throws IOException {
        LOGGER.debug("** case02 expected = IOException.class");
        CheckedDirectory.generateCheckedDirectory("not/exist");
    }

    @Test(expected = IOException.class)
    public void case03() throws IOException {
        LOGGER.debug("** case03 expected = IOException.class");
        String tempFileName = "temp.txt";
        File tempTarget = new File(sandBox.getAbsolutePath() + File.separator + tempFileName);
        assertTrue(tempTarget.createNewFile());
        CheckedDirectory.generateCheckedDirectory(tempTarget.getAbsolutePath());
    }

    @Before
    public void doBefore() throws IOException {
        levelOffSandBox();
    }
}
