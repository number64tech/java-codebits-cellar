package jp.number64.fileoperation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

    /** Input file as Specified Charset, Keep chars as Unicode (= 'String' default). */
    public String inputAsSpecifiedCharSet(Charset charset, CheckedFile targetFile) throws IOException {

        // three-piece set. somewhat classical...
        // when reader#close() is called by try-with-resources syntax, reader#close() calls InputStreamReader#close(),
        // and InputStreamReader#close() calls FileInputStream#close().
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(targetFile), "MS932"))) {

        } catch (IOException e) {
            throw e;
        }

        return null;
    }

    /*
    CharBuffer  decode(ByteBuffer bb)
    Convenience method that decodes bytes in this charset into Unicode characters.

    ByteBuffer  encode(CharBuffer cb)
    Convenience method that encodes Unicode characters into bytes in this charset.

    ByteBuffer  encode(String str)
    Convenience method that encodes a string into bytes in this charset.

    */

    public String convertStringToEncodedBytes(Charset charset, String input) {
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

    /**
     * Listup
        AvailableCharsets:
        KEY:[Big5]       VALUE:[Big5]
        KEY:[Big5-HKSCS] VALUE:[Big5-HKSCS]
        KEY:[CESU-8]     VALUE:[CESU-8]
        KEY:[EUC-JP]     VALUE:[EUC-JP]
        KEY:[EUC-KR]     VALUE:[EUC-KR]
        KEY:[GB18030]    VALUE:[GB18030]
        KEY:[GB2312]     VALUE:[GB2312]
        KEY:[GBK]        VALUE:[GBK]
        KEY:[IBM-Thai]   VALUE:[IBM-Thai]
        KEY:[IBM00858]   VALUE:[IBM00858]
        KEY:[IBM01140]   VALUE:[IBM01140]
        KEY:[IBM01141]   VALUE:[IBM01141]
        KEY:[IBM01142]   VALUE:[IBM01142]
        KEY:[IBM01143]   VALUE:[IBM01143]
        KEY:[IBM01144]   VALUE:[IBM01144]
        KEY:[IBM01145]   VALUE:[IBM01145]
        KEY:[IBM01146]   VALUE:[IBM01146]
        KEY:[IBM01147]   VALUE:[IBM01147]
        KEY:[IBM01148]   VALUE:[IBM01148]
        KEY:[IBM01149]   VALUE:[IBM01149]
        KEY:[IBM037]     VALUE:[IBM037]
        KEY:[IBM1026]    VALUE:[IBM1026]
        KEY:[IBM1047]    VALUE:[IBM1047]
        KEY:[IBM273]     VALUE:[IBM273]
        KEY:[IBM277]     VALUE:[IBM277]
        KEY:[IBM278]     VALUE:[IBM278]
        KEY:[IBM280]     VALUE:[IBM280]
        KEY:[IBM284]     VALUE:[IBM284]
        KEY:[IBM285]     VALUE:[IBM285]
        KEY:[IBM290]     VALUE:[IBM290]
        KEY:[IBM297]     VALUE:[IBM297]
        KEY:[IBM420]     VALUE:[IBM420]
        KEY:[IBM424]     VALUE:[IBM424]
        KEY:[IBM437]     VALUE:[IBM437]
        KEY:[IBM500]     VALUE:[IBM500]
        KEY:[IBM775]     VALUE:[IBM775]
        KEY:[IBM850]     VALUE:[IBM850]
        KEY:[IBM852]     VALUE:[IBM852]
        KEY:[IBM855]     VALUE:[IBM855]
        KEY:[IBM857]     VALUE:[IBM857]
        KEY:[IBM860]     VALUE:[IBM860]
        KEY:[IBM861]     VALUE:[IBM861]
        KEY:[IBM862]     VALUE:[IBM862]
        KEY:[IBM863]     VALUE:[IBM863]
        KEY:[IBM864]     VALUE:[IBM864]
        KEY:[IBM865]     VALUE:[IBM865]
        KEY:[IBM866]     VALUE:[IBM866]
        KEY:[IBM868]     VALUE:[IBM868]
        KEY:[IBM869]     VALUE:[IBM869]
        KEY:[IBM870]     VALUE:[IBM870]
        KEY:[IBM871]     VALUE:[IBM871]
        KEY:[IBM918]     VALUE:[IBM918]
        KEY:[ISO-2022-CN]    VALUE:[ISO-2022-CN]
        KEY:[ISO-2022-JP]    VALUE:[ISO-2022-JP]
        KEY:[ISO-2022-JP-2]  VALUE:[ISO-2022-JP-2]
        KEY:[ISO-2022-KR]    VALUE:[ISO-2022-KR]
        KEY:[ISO-8859-1]     VALUE:[ISO-8859-1]
        KEY:[ISO-8859-13]    VALUE:[ISO-8859-13]
        KEY:[ISO-8859-15]    VALUE:[ISO-8859-15]
        KEY:[ISO-8859-2]     VALUE:[ISO-8859-2]
        KEY:[ISO-8859-3]     VALUE:[ISO-8859-3]
        KEY:[ISO-8859-4]     VALUE:[ISO-8859-4]
        KEY:[ISO-8859-5]     VALUE:[ISO-8859-5]
        KEY:[ISO-8859-6]     VALUE:[ISO-8859-6]
        KEY:[ISO-8859-7]     VALUE:[ISO-8859-7]
        KEY:[ISO-8859-8]     VALUE:[ISO-8859-8]
        KEY:[ISO-8859-9]     VALUE:[ISO-8859-9]
        KEY:[JIS_X0201]  VALUE:[JIS_X0201]
        KEY:[JIS_X0212-1990]     VALUE:[JIS_X0212-1990]
        KEY:[KOI8-R]     VALUE:[KOI8-R]
        KEY:[KOI8-U]     VALUE:[KOI8-U]
        KEY:[Shift_JIS]  VALUE:[Shift_JIS]
        KEY:[TIS-620]    VALUE:[TIS-620]
        KEY:[US-ASCII]   VALUE:[US-ASCII]
        KEY:[UTF-16]     VALUE:[UTF-16]
        KEY:[UTF-16BE]   VALUE:[UTF-16BE]
        KEY:[UTF-16LE]   VALUE:[UTF-16LE]
        KEY:[UTF-32]     VALUE:[UTF-32]
        KEY:[UTF-32BE]   VALUE:[UTF-32BE]
        KEY:[UTF-32LE]   VALUE:[UTF-32LE]
        KEY:[UTF-8]  VALUE:[UTF-8]
        KEY:[windows-1250]   VALUE:[windows-1250]
        KEY:[windows-1251]   VALUE:[windows-1251]
        KEY:[windows-1252]   VALUE:[windows-1252]
        KEY:[windows-1253]   VALUE:[windows-1253]
        KEY:[windows-1254]   VALUE:[windows-1254]
        KEY:[windows-1255]   VALUE:[windows-1255]
        KEY:[windows-1256]   VALUE:[windows-1256]
        KEY:[windows-1257]   VALUE:[windows-1257]
        KEY:[windows-1258]   VALUE:[windows-1258]
        KEY:[windows-31j]    VALUE:[windows-31j]
        KEY:[x-Big5-HKSCS-2001]  VALUE:[x-Big5-HKSCS-2001]
        KEY:[x-Big5-Solaris]     VALUE:[x-Big5-Solaris]
        KEY:[x-euc-jp-linux]     VALUE:[x-euc-jp-linux]
        KEY:[x-EUC-TW]   VALUE:[x-EUC-TW]
        KEY:[x-eucJP-Open]   VALUE:[x-eucJP-Open]
        KEY:[x-IBM1006]  VALUE:[x-IBM1006]
        KEY:[x-IBM1025]  VALUE:[x-IBM1025]
        KEY:[x-IBM1046]  VALUE:[x-IBM1046]
        KEY:[x-IBM1097]  VALUE:[x-IBM1097]
        KEY:[x-IBM1098]  VALUE:[x-IBM1098]
        KEY:[x-IBM1112]  VALUE:[x-IBM1112]
        KEY:[x-IBM1122]  VALUE:[x-IBM1122]
        KEY:[x-IBM1123]  VALUE:[x-IBM1123]
        KEY:[x-IBM1124]  VALUE:[x-IBM1124]
        KEY:[x-IBM1364]  VALUE:[x-IBM1364]
        KEY:[x-IBM1381]  VALUE:[x-IBM1381]
        KEY:[x-IBM1383]  VALUE:[x-IBM1383]
        KEY:[x-IBM300]   VALUE:[x-IBM300]
        KEY:[x-IBM33722]     VALUE:[x-IBM33722]
        KEY:[x-IBM737]   VALUE:[x-IBM737]
        KEY:[x-IBM833]   VALUE:[x-IBM833]
        KEY:[x-IBM834]   VALUE:[x-IBM834]
        KEY:[x-IBM856]   VALUE:[x-IBM856]
        KEY:[x-IBM874]   VALUE:[x-IBM874]
        KEY:[x-IBM875]   VALUE:[x-IBM875]
        KEY:[x-IBM921]   VALUE:[x-IBM921]
        KEY:[x-IBM922]   VALUE:[x-IBM922]
        KEY:[x-IBM930]   VALUE:[x-IBM930]
        KEY:[x-IBM933]   VALUE:[x-IBM933]
        KEY:[x-IBM935]   VALUE:[x-IBM935]
        KEY:[x-IBM937]   VALUE:[x-IBM937]
        KEY:[x-IBM939]   VALUE:[x-IBM939]
        KEY:[x-IBM942]   VALUE:[x-IBM942]
        KEY:[x-IBM942C]  VALUE:[x-IBM942C]
        KEY:[x-IBM943]   VALUE:[x-IBM943]
        KEY:[x-IBM943C]  VALUE:[x-IBM943C]
        KEY:[x-IBM948]   VALUE:[x-IBM948]
        KEY:[x-IBM949]   VALUE:[x-IBM949]
        KEY:[x-IBM949C]  VALUE:[x-IBM949C]
        KEY:[x-IBM950]   VALUE:[x-IBM950]
        KEY:[x-IBM964]   VALUE:[x-IBM964]
        KEY:[x-IBM970]   VALUE:[x-IBM970]
        KEY:[x-ISCII91]  VALUE:[x-ISCII91]
        KEY:[x-ISO-2022-CN-CNS]  VALUE:[x-ISO-2022-CN-CNS]
        KEY:[x-ISO-2022-CN-GB]   VALUE:[x-ISO-2022-CN-GB]
        KEY:[x-iso-8859-11]  VALUE:[x-iso-8859-11]
        KEY:[x-JIS0208]  VALUE:[x-JIS0208]
        KEY:[x-JISAutoDetect]    VALUE:[x-JISAutoDetect]
        KEY:[x-Johab]    VALUE:[x-Johab]
        KEY:[x-MacArabic]    VALUE:[x-MacArabic]
        KEY:[x-MacCentralEurope]     VALUE:[x-MacCentralEurope]
        KEY:[x-MacCroatian]  VALUE:[x-MacCroatian]
        KEY:[x-MacCyrillic]  VALUE:[x-MacCyrillic]
        KEY:[x-MacDingbat]   VALUE:[x-MacDingbat]
        KEY:[x-MacGreek]     VALUE:[x-MacGreek]
        KEY:[x-MacHebrew]    VALUE:[x-MacHebrew]
        KEY:[x-MacIceland]   VALUE:[x-MacIceland]
        KEY:[x-MacRoman]     VALUE:[x-MacRoman]
        KEY:[x-MacRomania]   VALUE:[x-MacRomania]
        KEY:[x-MacSymbol]    VALUE:[x-MacSymbol]
        KEY:[x-MacThai]  VALUE:[x-MacThai]
        KEY:[x-MacTurkish]   VALUE:[x-MacTurkish]
        KEY:[x-MacUkraine]   VALUE:[x-MacUkraine]
        KEY:[x-MS932_0213]   VALUE:[x-MS932_0213]
        KEY:[x-MS950-HKSCS]  VALUE:[x-MS950-HKSCS]
        KEY:[x-MS950-HKSCS-XP]   VALUE:[x-MS950-HKSCS-XP]
        KEY:[x-mswin-936]    VALUE:[x-mswin-936]
        KEY:[x-PCK]  VALUE:[x-PCK]
        KEY:[x-SJIS_0213]    VALUE:[x-SJIS_0213]
        KEY:[x-UTF-16LE-BOM]     VALUE:[x-UTF-16LE-BOM]
        KEY:[X-UTF-32BE-BOM]     VALUE:[X-UTF-32BE-BOM]
        KEY:[X-UTF-32LE-BOM]     VALUE:[X-UTF-32LE-BOM]
        KEY:[x-windows-50220]    VALUE:[x-windows-50220]
        KEY:[x-windows-50221]    VALUE:[x-windows-50221]
        KEY:[x-windows-874]  VALUE:[x-windows-874]
        KEY:[x-windows-949]  VALUE:[x-windows-949]
        KEY:[x-windows-950]  VALUE:[x-windows-950]
        KEY:[x-windows-iso2022jp]    VALUE:[x-windows-iso2022jp]
     */
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

/**

Reynolds & Postel                                             [Page 100]

RFC 1700                    Assigned Numbers                October 1994

CHARACTER SETS

These are the official names for character sets that may be used in
the Internet and may be referred to in Internet documentation.  These
names are expressed in ANSI_X3.4-1968 which is commonly called
US-ASCII or simply ASCII.  The character set most commonly use in the
Internet and used especially in protocol standards is US-ASCII, this
is strongly encouraged.  The use of the name US-ASCII is also
encouraged.

The character set names may be up to 40 characters taken from the
printable characters of US-ASCII.  However, no distinction is made
between use of upper and lower case letters.


Character Set                                               Reference
-------------                                               ---------

Name: ANSI_X3.4-1968                                   [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-6
Alias: ANSI_X3.4-1986
Alias: ISO_646.irv:1991
Alias: ASCII
Alias: ISO646-US
Alias: US-ASCII
Alias: us
Alias: IBM367
Alias: cp367

Name: ISO-10646-UCS-2
Source: the 2-octet Basic Multilingual Plane, aka Unicode
        this needs to specify network byte order: the standard
        does not specify (it is a 16-bit integer space)

Name: ISO-10646-UCS-4
Source: the full code space. (same comment about byte order,
        these are 31-bit numbers.

Name: ISO-10646-UTF-1
Source: Universal Transfer Format (1), this is the multibyte
        encoding, that subsets ASCII-7. It does not have byte
        ordering issues.

Name: ISO_646.basic:1983                                [RFC1345,KXS2]
Source: ECMA registry
Alias: ref

Name: INVARIANT                                         [RFC1345,KXS2]

Name: ISO_646.irv:1983                                  [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-2
Alias: irv

Name: BS_4730                                           [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-4
Alias: ISO646-GB
Alias: gb
Alias: uk

Name: NATS-SEFI                                         [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-8-1

Name: NATS-SEFI-ADD                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-8-2

Name: NATS-DANO                                         [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-9-1

Name: NATS-DANO-ADD                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-9-2

Name: SEN_850200_B                                      [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-10
Alias: FI
Alias: ISO646-FI
Alias: ISO646-SE
Alias: se

Name: SEN_850200_C                                      [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-11
Alias: ISO646-SE2
Alias: se2

Name: KS_C_5601-1987                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-149
Alias: KS_C_5601-1989
Alias: KSC_5601
Alias: korean

Name: ISO-2022-KR                                       [RFC1557,Choi]
Source: RFC-1557 (see also KS_C_5601-1987)

Name: EUC-KR                                            [RFC1557,Choi]
Source: RFC-1557 (see also KS_C_5861-1992)

Name: ISO-2022-JP                                      [RFC1468,Murai]
Source: RFC-1468

Name: ISO-2022-JP-2                                     [RFC1554,Ohta]
Source: RFC-1554

Name: JIS_C6220-1969-jp                                 [RFC1345,KXS2]
Source: ECMA registry
Alias: JIS_C6220-1969
Alias: iso-ir-13
Alias: katakana
Alias: x0201-7

Name: JIS_C6220-1969-ro                                 [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-14
Alias: jp
Alias: ISO646-JP

Name: IT                                                [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-15
Alias: ISO646-IT

Name: PT                                                [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-16
Alias: ISO646-PT

Name: ES                                                [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-17
Alias: ISO646-ES

Name: greek7-old                                        [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-18

Name: latin-greek                                       [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-19

Name: DIN_66003                                         [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-21
Alias: de
Alias: ISO646-DE

Name: NF_Z_62-010_(1973)                                [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-25
Alias: ISO646-FR1

Name: Latin-greek-1                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-27

Name: ISO_5427                                          [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-37

Name: JIS_C6226-1978                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-42

Name: BS_viewdata                                       [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-47

Name: INIS                                              [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-49

Name: INIS-8                                            [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-50

Name: INIS-cyrillic                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-51

Name: ISO_5427:1981                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-54

Name: ISO_5428:1980                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-55

Name: GB_1988-80                                        [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-57
Alias: cn
Alias: ISO646-CN

Name: GB_2312-80                                        [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-58
Alias: chinese

Name: NS_4551-1                                         [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-60
Alias: ISO646-NO
Alias: no

Name: NS_4551-2                                          [RFC1345,KXS2]
Source: ECMA registry
Alias: ISO646-NO2
Alias: iso-ir-61
Alias: no2

Name: NF_Z_62-010                                        [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-69
Alias: ISO646-FR
Alias: fr

Name: videotex-suppl                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-70

Name: PT2                                                [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-84
Alias: ISO646-PT2

Name: ES2                                                [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-85
Alias: ISO646-ES2

Name: MSZ_7795.3                                         [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-86
Alias: ISO646-HU
Alias: hu

Name: JIS_C6226-1983                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-87
Alias: x0208
Alias: JIS_X0208-1983

Name: greek7                                             [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-88

Name: ASMO_449                                           [RFC1345,KXS2]
Source: ECMA registry
Alias: ISO_9036
Alias: arabic7
Alias: iso-ir-89

Name: iso-ir-90                                          [RFC1345,KXS2]
Source: ECMA registry

Name: JIS_C6229-1984-a                                   [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-91
Alias: jp-ocr-a

Name: JIS_C6229-1984-b                                   [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-92
Alias: ISO646-JP-OCR-B
Alias: jp-ocr-b

Name: JIS_C6229-1984-b-add                               [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-93
Alias: jp-ocr-b-add

Name: JIS_C6229-1984-hand                                [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-94
Alias: jp-ocr-hand

Name: JIS_C6229-1984-hand-add                            [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-95
Alias: jp-ocr-hand-add

Name: JIS_C6229-1984-kana                                [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-96

Name: ISO_2033-1983                                      [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-98
Alias: e13b

Name: ANSI_X3.110-1983                                   [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-99
Alias: CSA_T500-1983
Alias: NAPLPS

Name: ISO_8859-1:1987                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-100
Alias: ISO_8859-1
Alias: ISO-8859-1
Alias: latin1
Alias: l1
Alias: IBM819
Alias: CP819

Name: ISO_8859-2:1987                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-101
Alias: ISO_8859-2
Alias: ISO-8859-2
Alias: latin2
Alias: l2

Name: T.61-7bit                                          [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-102

Name: T.61-8bit                                          [RFC1345,KXS2]
Alias: T.61
Source: ECMA registry
Alias: iso-ir-103

Name: ISO_8859-3:1988                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-109
Alias: ISO_8859-3
Alias: ISO-8859-3
Alias: latin3
Alias: l3

Name: ISO_8859-4:1988                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-110
Alias: ISO_8859-4
Alias: ISO-8859-4
Alias: latin4
Alias: l4

Name: ECMA-cyrillic                                      [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-111

Name: CSA_Z243.4-1985-1                                  [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-121
Alias: ISO646-CA
Alias: csa7-1
Alias: ca

Name: CSA_Z243.4-1985-2                                  [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-122
Alias: ISO646-CA2
Alias: csa7-2

Name: CSA_Z243.4-1985-gr                                 [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-123

Name: ISO_8859-6:1987                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-127
Alias: ISO_8859-6
Alias: ISO-8859-6
Alias: ECMA-114
Alias: ASMO-708
Alias: arabic

Name: ISO_8859-6-E                                       [RFC1556,IANA]
Source: RFC-1556

Name: ISO_8859-6-I                                       [RFC1556,IANA]
Source: RFC-1556

Name: ISO_8859-7:1987                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-126
Alias: ISO_8859-7
Alias: ISO-8859-7
Alias: ELOT_928
Alias: ECMA-118
Alias: greek
Alias: greek8

Name: T.101-G2                                            [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-128

Name: ISO_8859-8:1988                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-138
Alias: ISO_8859-8
Alias: ISO-8859-8
Alias: hebrew

Name: ISO_8859-8-E                                  [RFC1556,Nussbacher]
Source: RFC-1556

Name: ISO_8859-8-I                                  [RFC1556,Nussbacher]
Source: RFC-1556

Name: CSN_369103                                          [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-139

Name: JUS_I.B1.002                                        [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-141
Alias: ISO646-YU
Alias: js
Alias: yu

Name: ISO_6937-2-add                                      [RFC1345,KXS2]
Source: ECMA registry and ISO 6937-2:1983
Alias: iso-ir-142

Name: IEC_P27-1                                           [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-143

Name: ISO_8859-5:1988                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-144
Alias: ISO_8859-5
Alias: ISO-8859-5
Alias: cyrillic

Name: JUS_I.B1.003-serb                                   [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-146
Alias: serbian

Name: JUS_I.B1.003-mac                                    [RFC1345,KXS2]
Source: ECMA registry
Alias: macedonian
Alias: iso-ir-147

Name: ISO_8859-9:1989                                     [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-148
Alias: ISO_8859-9
Alias: ISO-8859-9
Alias: latin5
Alias: l5

Name: greek-ccitt                                         [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-150

Name: NC_NC00-10:81                                       [RFC1345,KXS2]
Source: ECMA registry
Alias: cuba
Alias: iso-ir-151
Alias: ISO646-CU

Name: ISO_6937-2-25                                       [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-152

Name: GOST_19768-74                                       [RFC1345,KXS2]
Source: ECMA registry
Alias: ST_SEV_358-88
Alias: iso-ir-153

Name: ISO_8859-supp                                       [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-154
Alias: latin1-2-5

Name: ISO_10367-box                                       [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-155

Name: latin6                                              [RFC1345,KXS2]
Source: ECMA registry
Alias: iso-ir-157
Alias: l6

Name: latin-lap                                           [RFC1345,KXS2]
Source: ECMA registry
Alias: lap
Alias: iso-ir-158

Name: JIS_X0212-1990                                      [RFC1345,KXS2]
Source: ECMA registry
Alias: x0212
Alias: iso-ir-159

Name: DS_2089                                             [RFC1345,KXS2]
Source: Danish Standard, DS 2089, February 1974
Alias: DS2089
Alias: ISO646-DK
Alias: dk

Name: us-dk                                               [RFC1345,KXS2]

Name: dk-us                                               [RFC1345,KXS2]

Name: JIS_X0201                                           [RFC1345,KXS2]
Alias: X0201

Name: KSC5636                                             [RFC1345,KXS2]
Alias: ISO646-KR

Name: DEC-MCS                                             [RFC1345,KXS2]
Source: VAX/VMS User's Manual,
        Order Number: AI-Y517A-TE, April 1986.
Alias: dec

Name: hp-roman8                                           [RFC1345,KXS2]
Source: LaserJet IIP Printer User's Manual,
        HP part no 33471-90901, Hewlet-Packard, June 1989.
Alias: roman8
Alias: r8

Name: macintosh                                           [RFC1345,KXS2]
Source: The Unicode Standard ver1.0, ISBN 0-201-56788-1, Oct 1991
Alias: mac

Name: IBM037                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp037
Alias: ebcdic-cp-us
Alias: ebcdic-cp-ca
Alias: ebcdic-cp-wt
Alias: ebcdic-cp-nl

Name: IBM038                                              [RFC1345,KXS2]
Source: IBM 3174 Character Set Ref, GA27-3831-02, March 1990
Alias: EBCDIC-INT
Alias: cp038

Name: IBM273                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP273

Name: IBM274                                              [RFC1345,KXS2]
Source: IBM 3174 Character Set Ref, GA27-3831-02, March 1990
Alias: EBCDIC-BE
Alias: CP274

Name: IBM275                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: EBCDIC-BR
Alias: cp275

Name: IBM277                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: EBCDIC-CP-DK
Alias: EBCDIC-CP-NO

Name: IBM278                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP278
Alias: ebcdic-cp-fi
Alias: ebcdic-cp-se

Name: IBM280                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP280
Alias: ebcdic-cp-it

Name: IBM281                                              [RFC1345,KXS2]
Source: IBM 3174 Character Set Ref, GA27-3831-02, March 1990
Alias: EBCDIC-JP-E
Alias: cp281

Name: IBM284                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP284
Alias: ebcdic-cp-es

Name: IBM285                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP285
Alias: ebcdic-cp-gb

Name: IBM290                                              [RFC1345,KXS2]
Source: IBM 3174 Character Set Ref, GA27-3831-02, March 1990
Alias: cp290
Alias: EBCDIC-JP-kana

Name: IBM297                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp297
Alias: ebcdic-cp-fr

Name: IBM420                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990,
        IBM NLS RM p 11-11
Alias: cp420
Alias: ebcdic-cp-ar1

Name: IBM423                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp423
Alias: ebcdic-cp-gr

Name: IBM424                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp424
Alias: ebcdic-cp-he

Name: IBM437                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp437
Alias: 437

Name: IBM500                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP500
Alias: ebcdic-cp-be
Alias: ebcdic-cp-ch

Name: IBM850                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp850
Alias: 850

Name: IBM851                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp851
Alias: 851

Name: IBM852                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp852
Alias: 852

Name: IBM855                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp855
Alias: 855

Name: IBM857                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp857
Alias: 857

Name: IBM860                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp860
Alias: 860

Name: IBM861                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp861
Alias: 861
Alias: cp-is

Name: IBM862                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp862
Alias: 862

Name: IBM863                                              [RFC1345,KXS2]
Source: IBM Keyboard layouts and code pages, PN 07G4586 June 1991
Alias: cp863
Alias: 863

Name: IBM864                                              [RFC1345,KXS2]
Source: IBM Keyboard layouts and code pages, PN 07G4586 June 1991
Alias: cp864

Name: IBM865                                              [RFC1345,KXS2]
Source: IBM DOS 3.3 Ref (Abridged), 94X9575 (Feb 1987)
Alias: cp865
Alias: 865

Name: IBM868                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP868
Alias: cp-ar

Name: IBM869                                              [RFC1345,KXS2]
Source: IBM Keyboard layouts and code pages, PN 07G4586 June 1991
Alias: cp869
Alias: 869
Alias: cp-gr

Name: IBM870                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP870
Alias: ebcdic-cp-roece
Alias: ebcdic-cp-yu

Name: IBM871                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP871
Alias: ebcdic-cp-is

Name: IBM880                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp880
Alias: EBCDIC-Cyrillic

Name: IBM891                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp891

Name: IBM903                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp903

Name: IBM904                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: cp904
Alias: 904

Name: IBM905                                              [RFC1345,KXS2]
Source: IBM 3174 Character Set Ref, GA27-3831-02, March 1990
Alias: CP905
Alias: ebcdic-cp-tr

Name: IBM918                                              [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP918
Alias: ebcdic-cp-ar2

Name: IBM1026                                             [RFC1345,KXS2]
Source: IBM NLS RM Vol2 SE09-8002-01, March 1990
Alias: CP1026

Name: EBCDIC-AT-DE                                        [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-AT-DE-A                                      [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-CA-FR                                        [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-DK-NO                                        [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-DK-NO-A                                      [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-FI-SE                                        [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-FI-SE-A                                      [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-FR                                           [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-IT                                           [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-PT                                           [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-ES                                           [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-ES-A                                         [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-ES-S                                         [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-UK                                           [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: EBCDIC-US                                           [RFC1345,KXS2]
Source: IBM 3270 Char Set Ref Ch 10, GA27-2837-9, April 1987

Name: UNKNOWN-8BIT                                             [RFC1428]

Name: MNEMONIC                                            [RFC1345,KXS2]
Source: RFC 1345, also known as "mnemonic+ascii+38"

Name: MNEM                                                [RFC1345,KXS2]
Source: RFC 1345, also known as "mnemonic+ascii+8200"

Name: VISCII                                                   [RFC1456]
Source: RFC 1456

Name: VIQR                                                     [RFC1456]
Source: RFC 1456

Name: KOI8-R                                                   [RFC1489]
Source: RFC 1489, based on GOST-19768-74, ISO-6937/8,
        INIS-Cyrillic, ISO-5427.

Name: UNICODE-1-1                                              [RFC1641]
Source: RFC 1641

Name: UNICODE-1-1-UTF-7                                        [RFC1642]
Source: RFC 1642
*/
