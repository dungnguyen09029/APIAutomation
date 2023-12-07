package utilities;

public class LibraryManager {

    private static LibraryManager instance;
    private AssertUtils assertUtils;
    private UrlUtils urlUtils;
    private StringUtils stringUtils;
    private NumberUtils numberUtils;
    private DateUtils dateUtils;

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

    public UrlUtils getUrlUtils() {
        return (urlUtils == null) ? urlUtils = new UrlUtils() : urlUtils;
    }

    public StringUtils getStringUtils() {
        return (stringUtils == null) ? stringUtils = new StringUtils() : stringUtils;
    }

    public DateUtils getDateUtils() {
        return (dateUtils == null) ? dateUtils = new DateUtils() : dateUtils;
    }

    public NumberUtils getNumberUtils() {
        return (numberUtils == null) ? numberUtils = new NumberUtils() : numberUtils;
    }

}
