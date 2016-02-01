package jp.number64.fileoperation;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import jp.number64.TestBase;

import org.junit.Before;

public abstract class FileTestBase extends TestBase {
    protected static final String WORKING_DIRECTORY_CATEGORY = "fileoperation";

    protected File sandBox = null;

    /** very strange method. who did make this? no one else but me.  */
    @Before
    public void createSandbox() throws IOException {
        Path dir = new File(WORKING_DIRECTORY_BASE + File.separator + WORKING_DIRECTORY_CATEGORY).toPath();
        String prefix = getTestClassName();
        vacateTarget(dir, prefix, 0);
        sandBox = Files.createTempDirectory(dir, prefix).toFile();
        sandBox.deleteOnExit();
    }

    /** 'vacate O': means to be empty O */
    public void vacateTarget(Path dir, String prefix, int depth) throws IOException {
        if (depth == 10) {
            throw new IOException("too deep. " + dir.toString());
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, prefix + "*")) {
            for(Path target : stream) {
                File targetFile = target.toFile();
                if (!targetFile.isFile()) {
                    vacateTarget(targetFile.toPath(), "", ++depth);
                }
                if (!targetFile.delete()) {
                    throw new IOException("failed to delete: " + targetFile.getAbsolutePath());
                }
            }
        }
    }

    public String getTestClassName() {
        String className = this.getClass().getName();
        return className.contains("$") ? className.replaceAll(".*\\$", "") : className.replaceAll(".*\\.", "");
    };
}

