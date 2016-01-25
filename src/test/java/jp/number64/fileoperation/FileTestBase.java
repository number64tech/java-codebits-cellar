package jp.number64.fileoperation;

import java.io.File;
import java.io.IOException;

import jp.number64.TestBase;

public abstract class FileTestBase extends TestBase {
    protected static final String WORKING_DIRECTORY_CATEGORY = "fileoperation";

    protected File sandBox = null;

    /** Construct and levelOff SANDBOX.   a mere working directory. */
    public void levelOffSandBox() throws IOException {
        sandBox = new File(WORKING_DIRECTORY_BASE
            + File.separator + WORKING_DIRECTORY_CATEGORY
            + File.separator + getTestClassName());

        if (!sandBox.exists()) {
            if (!sandBox.mkdirs()) {
                throw new IOException("Can't create directory [" + sandBox.getAbsolutePath() + "]");
            }
            return;
        }

        File[] toysOnSandbox = sandBox.listFiles();
        for (File toy : toysOnSandbox) {
            if (!toy.delete()) {
                throw new IOException("Can't cleanup sandbox. cause: delete failure. [" + toy.getAbsolutePath() + "]");
            }
        }
    }

    /** It should return testclassname based on implemented class name. */
    public abstract String getTestClassName();
}

