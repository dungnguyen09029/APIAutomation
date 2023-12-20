package utilities;

public class LibraryManager {

    private static LibraryManager instance;
    private AssertUtils assertUtils;
    private APIJsonUtils apiJsonUtils;
    private StringUtils stringUtils;

    public static LibraryManager getInstance() {
        if (instance == null) {
            //synchronized block to remove overhead
            synchronized (LibraryManager.class) {
                if (instance == null) {
                    // if instance is null, initialize
                    instance = new LibraryManager();
                }
            }
        }
        return instance;
    }

    public AssertUtils getAssertUtils() {
        return (assertUtils == null) ? assertUtils = new AssertUtils() : assertUtils;
    }

    public ConfigReader getConfigReader() {
        return ConfigReader.getInstance();
    }

    public APIJsonUtils getApiJsonUtils() {
        return (apiJsonUtils == null)? apiJsonUtils = new APIJsonUtils() : apiJsonUtils;
    }

    public StringUtils getStringUtils() {
        return (stringUtils == null)? stringUtils = new StringUtils() : stringUtils;
    }

}
