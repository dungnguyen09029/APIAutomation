package utilities;

public class LibraryManager {

    private static LibraryManager instance;
    private AssertUtils assertUtils;

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

}
