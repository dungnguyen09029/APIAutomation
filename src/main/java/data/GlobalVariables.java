package data;

import utilities.LibraryManager;

public class GlobalVariables {

    public static final String BASE_URL = LibraryManager.getInstance().getConfigReader().getBaseUrl();
    public static final String PROTOCOL = LibraryManager.getInstance().getConfigReader().getProtocol();
    public static final String BASE_URL_PREFIX = LibraryManager.getInstance().getConfigReader().getUrlPrefix();
    public static final String SEPARATOR = "/";

    public static final boolean isSoftAssert = LibraryManager.getInstance().getConfigReader().getSoftAssertStatus();
}
