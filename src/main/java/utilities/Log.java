package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger logger = LogManager.getLogger();

    public static void startTestSet(String testSuite) {
        logger.info("-----------------------------------------------------------------------------------");
        logger.info("Start test set: " + testSuite + "---- Thread ID: " + getPrefix());
    }

    public static void endTestSet(String testSuite) {
        logger.info("End test set: " + testSuite + "---- Thread ID: " + getPrefix());
        logger.info("-----------------------------------------------------------------------------------");
    }

    public static void startTestCase(String testcaseId) {
        logger.info("Start testcase ID: " + testcaseId + "---- Thread ID: " + getPrefix());
        logger.info("-----------------------------------------------------------------------------------");
    }

    public static void endTestCase(String testcaseId) {
        logger.info("-----------------------------------------------------------------------------------");
        logger.info("End testcase ID: "  +testcaseId + "---- Thread ID: " + getPrefix());
    }

    private static String getPrefix() {
        return "Thread ID: " + Thread.currentThread().getId() + " --- ";
    }

    public static void logInfo(String message) {
        String prefix = getPrefix();
        logger.info(prefix + message);
    }

    public static void logWarning(String message) {
        String prefix = getPrefix();
        logger.warn(prefix + message);
    }

    public static void logDebug(String message) {
        String prefix = getPrefix();
        logger.debug(prefix + message);
    }

    public static void logFatal(String message) {
        String prefix = getPrefix();
        logger.fatal(prefix + message);
    }

    public static void logError(String message) {
        String prefix = getPrefix();
        logger.error(prefix + message);
    }
}
