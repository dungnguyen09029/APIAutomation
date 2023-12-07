package apiEngine.endpoint;

import utilities.LibraryManager;

public class EndPoints {

    protected LibraryManager libraryManager;
    protected String baseUrl;

    public EndPoints() {
        libraryManager = LibraryManager.getInstance();
        baseUrl = libraryManager.getUrlUtils().buildBaseUrl();
    }
}
