package jp.number64.fileoperation;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RunWith(Suite.class)
//@SuiteClasses({
//    TestRenameTo.class,
//})
public class FilesClassSampleTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilesClassSampleTest.class);

    /**  */
    public static final class CaptureAndSaveWebPageTest extends FileTestBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(CaptureAndSaveWebPageTest.class);

        @Test
        public void case01() throws IOException {
            // a-b-c-
            String keyword = "\u3048\u30fc\u3073\u30fc\u3057\u30fc";

            // create basefile
            Path inputFile = new File(sandBox.getAbsolutePath() + File.separator + "test.txt").toPath();
            try (BufferedWriter writer = Files.newBufferedWriter(inputFile, Charset.forName("UTF-8"))){
                writer.write(keyword);
            }
            LOGGER.debug("inputFilePath: {}", inputFile.toString());

            // create resultfile
            Path resultFile = (new FilesClassSample().captureAndSaveWebPage(
                "file:" + (inputFile.toString()).replaceAll("\\\\", "/"), inputFile.toString() + ".result"));
            LOGGER.debug("outputFilePath: {}", inputFile.toString() + ".result");
            LOGGER.debug("resultFilePath: {}", resultFile.toString());

            // compare files
            try (BufferedReader reader = Files.newBufferedReader(resultFile, Charset.forName("UTF-8"))){
                String line = reader.readLine();
                LOGGER.debug("readResult: {}", line);
                assertTrue(line.equals(keyword));
            }
        }
    }

    //-------------------------------------------------------------------------------------------------

    /** experiment */
    public static final class Experiment extends FileTestBase {
        public void exp01GetGoogle() throws Exception {
            Path resultPath = (new FilesClassSample().captureAndSaveWebPage(
                "http://google.com/", sandBox.getAbsolutePath() + File.separator + "google.txt"));
            LOGGER.debug("copied file: {}", resultPath.toString());
        }
    }
}
