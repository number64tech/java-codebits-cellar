package jp.number64.fileoperation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamBinaryIo {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamBinaryIo.class);

    private int colSize = 32;
    public void setColSize(int newSize) {
        this.colSize = newSize;
    }
    public int getColSize() {
        return this.colSize;
    }

    public List<Integer> inputAsBinary(CheckedFile targetFile) throws IOException {
        LOGGER.debug("** start #inputAsBinary()");

        StringBuffer logString = new StringBuffer();
        List<Integer> result = new ArrayList<>();
        try (BufferedInputStream bufStr = new BufferedInputStream(new FileInputStream(targetFile)))    {
            int logCounter = 0;
            while(true) {
                Integer readResult = Integer.valueOf(bufStr.read());
                if (readResult == -1) {
                    break;
                }
                result.add(Integer.valueOf(readResult));
                logCounter++;
                logString.append(readResult.toString()).append(" ");
                if (logCounter % colSize == 0) {
                    logString.append(System.lineSeparator());
                    logCounter = 0;
                }
            }
        } catch (IOException e) {
            throw e;
        }

        LOGGER.debug(logString.toString());
        LOGGER.debug("** end #inputAsBinary()");
        return result;
    }

    public String formatBinaryForHexDump(List<Integer> input) {
        LOGGER.debug("** start #formatBinaryForHexDump()");
        StringBuilder result = new StringBuilder();

        // padding
        int paddingSize = colSize - ((input.size()) % colSize);
        paddingSize = (paddingSize == colSize ? 0 : paddingSize);
        for (int i=0 ; i<paddingSize ; i++) {
            input.add(null);
        }

        // convert to HexString
        int colCounter = 0;
        for (Integer value : input) {
            if (value == null) {
                result.append("..");
            } else if (value < 0x10) {
                result.append("0").append(Integer.toHexString(value).toUpperCase());
            } else {
                result.append(Integer.toHexString(value).toUpperCase());
            }
            colCounter++;
            if (colCounter % colSize == 0) {
                result.append(System.lineSeparator());
                colCounter = 0;
            } else if (colCounter % 8 == 0) {
                result.append("-");
            } else {
                result.append(" ");
            }
        }

        LOGGER.debug("** end #formatBinaryForHexDump()");
        return result.toString();
    }
}
