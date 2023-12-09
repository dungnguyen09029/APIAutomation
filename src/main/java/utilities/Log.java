package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger logger = LogManager.getLogger();

    public static void startTestCase() {
        logger.info("Start testcase: ");
        logger.info("-----------------------------------------------------------------------------------");
    }

    public static void endTestCase() {
        logger.info("-----------------------------------------------------------------------------------");
        logger.info("End testcase: ");
    }

    public static void logInfo(String message) {
        String prefix = "Thread: " + Thread.currentThread().getName() + " --- ";
        logger.info(prefix + message);
    }

    public static void logWarning(String message) {
        logger.warn(message);
    }

    public static void logDebug(String message) {
        logger.debug(message);
    }

    public static void logFatal(String message) {
        logger.fatal(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    public static String getLogPath(String scenarioName) {
        String fileLogName = String.format("%s--%s.html", scenarioName, System.currentTimeMillis());
        String logLocation = "log/";
        return logLocation + fileLogName;
    }
}
