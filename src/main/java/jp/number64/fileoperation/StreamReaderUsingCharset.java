package jp.number64.fileoperation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <br>
 * @see java.nio.charset.Charset
 * @see java.nio.charset.StandardCharsets
 */
public class StreamReaderUsingCharset {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamReaderUsingCharset.class);

    /** Input file as Specified Charset, Return chars as (Unicode) CharBuffer.
     * @param charset charset of input target textfile
     * @param targetFile input target textfile
     * @param bufferSize size of {@link CharBuffer#allocate(int)}
     */
    public String inputAsSpecifiedCharSet(Charset charset, CheckedFile targetFile) throws IOException {
        //CharBuffer result = CharBuffer. CharBuffer();

        // three-piece set. somewhat classical...
        // when reader#close() is called by try-with-resources syntax, reader#close() calls InputStreamReader#close(),
        // and InputStreamReader#close() calls FileInputStream#close().
        try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(new FileInputStream(targetFile), charset))) {
            while(true) {
                Integer readResult = Integer.valueOf(reader.read());
                if (readResult == -1) {
                    break;
                }
                LOGGER.debug("readResult: {} {}", Integer.toHexString(readResult), Character.getName(readResult));
            }
        } catch (IOException e) {
            throw e;
        }

        return null;
    }

    public String convertToEncodedBytesString(Charset charset, String input) {
        return null;
    }

    /** ShiftJIS */
    public String inputAsShiftJISWinExtended(CheckedFile targetFile) throws IOException {
        LOGGER.debug("** start #inputAsShiftJISWinExtended()");
        Charset charset = Charset.forName("Windows-31j");
        String result = inputAsSpecifiedCharSet(charset, targetFile);
        return result;
    }

    /** EUC-JP */
    public String inputAsEucJp(CheckedFile targetFile) throws IOException {
        LOGGER.debug("** start #inputAsEucJp()");
        Charset charset = Charset.forName("EUC-JP");
        String result = inputAsSpecifiedCharSet(charset, targetFile);
        return result;
    }

    //--------------------------------------------------------------------------------------------------------

    /**  */
    public static void listupAvailabeCharsets() {
        LOGGER.debug("Default Charset is [{}]", Charset.defaultCharset().name());
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Set<String> keySet = charsets.keySet();
        LOGGER.debug("AvailableCharsets: ");
        for (String key : keySet) {
            LOGGER.debug("KEY:[{}]\t VALUE:[{}]", key, charsets.get(key).name());
        }
    }
}

