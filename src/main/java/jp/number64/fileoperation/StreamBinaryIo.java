package jp.number64.fileoperation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamBinaryIo {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamBinaryIo.class);

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
        return result;
    }

    public String convertBinaryToHexString(List<Byte> input) {
        StringBuilder result = new StringBuilder();

        // padding
        int paddingSize = 16 - ((input.size()) % 16);
        paddingSize = (paddingSize == 16 ? 0 : paddingSize);
        for (int i=0 ; i<paddingSize ; i++) {
            input.add(null);
        }

        // convert to HexString
        for (Byte value : input) {
            if (value == null) {
                result.append("--");
                continue;
            }
            String hexString = Integer.toHexString(value.intValue());
            result.append(hexString);
        }

        return result.toString();
    }

    public String formatHexStringForDump(String hexString) {
        // convert to space-separated-value
        Pattern patternInsertSpace = Pattern.compile("^([0-9a-fA-F]{2}|-{2})(?<=([0-9a-fA-F]{2}|-{2})+)");
        Matcher matchInsertSpace = patternInsertSpace.matcher(hexString);
        String ssv = matchInsertSpace.replaceAll(" ");

        // insert new-line every 16 pieces
        Pattern patternInsertNewline = Pattern.compile("(?:(([0-9a-fA-F]{2} |-{2} ){15}([0-9a-fA-F]{2}|-{2}))) ");
        Matcher matchInsertNewline = patternInsertNewline.matcher(ssv);
        String foldedSsv = matchInsertNewline.replaceAll("\n");

        return foldedSsv;
    }

}
