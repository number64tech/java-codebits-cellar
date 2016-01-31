package jp.number64.fileoperation;

import java.io.File;
import java.io.IOException;

import jp.number64.TestBase;

import org.junit.Before;

public abstract class FileTestBase extends TestBase {
    protected static final String WORKING_DIRECTORY_CATEGORY = "fileoperation";

    protected File sandBox = null;

    /** Construct and LevelOff SANDBOX.   a mere working directory. */
    @Before
    public void createSandbox() throws IOException {
        sandBox = new File(WORKING_DIRECTORY_BASE
            + File.separator + WORKING_DIRECTORY_CATEGORY
            + File.separator + getTestClassName());

        if (!sandBox.exists()) {
            if (!sandBox.mkdirs()) {
                throw new IOException("Can't create directory [" + sandBox.getAbsolutePath() + "]");
            }
            return;
        }

        File[] toysOnSandBox = sandBox.listFiles();
        for (File toy : toysOnSandBox) {
            if (!toy.delete()) {
                throw new IOException("Can't cleanup sandbox. cause: delete failure. [" + toy.getAbsolutePath() + "]");
            }
        }
    }

    public String getTestClassName() {
        String className = this.getClass().getName();
        return className;
    };
}

