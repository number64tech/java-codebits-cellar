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

    /** CharBuffer default capacity */
    private static final int capacity = 100;

    /** Input file as Specified Charset, Return chars as (Unicode) CharBuffer. <br>
     * three-piece set. somewhat classical... <br>
     * when reader#close() is called by try-with-resources syntax, reader#close() calls InputStreamReader#close(), <br>
     * and InputStreamReader#close() calls FileInputStream#close(). <br>
     * @param charset charset of input target textfile
     * @param targetFile input target textfile
     */
    public CharBuffer inputAsSpecifiedCharSet(Charset charset, CheckedFile targetFile) throws IOException {
        CharBuffer result = CharBuffer.allocate(capacity);

        try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(new FileInputStream(targetFile), charset))) {
            int readCount = reader.read(result);
            LOGGER.debug("** readCount: {}", readCount);
        } catch (IOException e) {
            throw e;
        }

        // after reading, position indicates last-char. rewind before return this.
        result.rewind();
        return result;
    }

    /** ShiftJIS */
    public CharBuffer inputAsShiftJISWinExtended(CheckedFile targetFile) throws IOException {
        LOGGER.debug("** start #inputAsShiftJISWinExtended()");
        Charset charset = Charset.forName("Windows-31j");
        CharBuffer result = inputAsSpecifiedCharSet(charset, targetFile);
        return result;
    }

    /** EUC-JP */
    public CharBuffer inputAsEucJp(CheckedFile targetFile) throws IOException {
        LOGGER.debug("** start #inputAsEucJp()");
        Charset charset = Charset.forName("EUC-JP");
        CharBuffer result = inputAsSpecifiedCharSet(charset, targetFile);
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
