package jp.number64.fileoperation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryIo {
    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryIo.class);

    public List<Byte> inputAsBinary(CheckedFile targetFile) throws IOException {
        LOGGER.debug("** start #inputAsBinary()");

        List<Byte> result = new ArrayList<>();
        try (BufferedInputStream bufStr = new BufferedInputStream(new FileInputStream(targetFile)))    {
            while(true) {
                Integer readResult = Integer.valueOf(bufStr.read());
                if (readResult == -1) {
                    break;
                }
                result.add(Byte.valueOf(readResult.byteValue()));
            }
        } catch (IOException e) {
            throw e;
        }

        LOGGER.debug("** end #inputAsBinary()");
        return null;
    }

    public String formatBinaryToHexDump(List<Byte> input) {
        return null;
    }

}
