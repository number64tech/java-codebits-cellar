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
public class RunningCheckedFileTest extends FileTestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunningCheckedFileTest.class);

    @Test
    public void case01() throws IOException {
        String tempFileName = "temp.txt";
        File tempTarget = new File(sandBox.getAbsolutePath() + File.separator + tempFileName);
        assertTrue(tempTarget.createNewFile());
        CheckedFile.generateCheckedFile(tempTarget.getAbsolutePath());
        LOGGER.debug("** case01 OK.");
    }

    @Test(expected = IOException.class)
    public void case02() throws IOException {
        CheckedFile.generateCheckedFile("/dummy.txt");
        LOGGER.debug("** case02 OK.");
    }

    @Test(expected = IOException.class)
    public void case03() throws IOException {
        CheckedFile.generateCheckedFile(sandBox.getAbsolutePath());
        LOGGER.debug("** case03 OK.");
    }

    @Before
    public void doBefore() throws IOException {
        levelOffSandBox();
    }

    @Override
    public String getTestClassName() {
        return "RunningCheckedFileTest";
    }
}
