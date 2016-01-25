package jp.number64;

public abstract class TestBase {
    public static final String START_LOG = "** START: {}";
    protected static final String WORKING_DIRECTORY_BASE = "./var";

    public static String getMethodName(final Throwable thisMethod) {
        StackTraceElement stackTrace = thisMethod.getStackTrace()[0];
        return stackTrace.getMethodName();
    }
}
