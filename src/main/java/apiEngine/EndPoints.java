package apiEngine;

import utilities.LibraryManager;

public class EndPoints {

    protected LibraryManager libraryManager;
    protected String baseUrl;

    public EndPoints() {
        libraryManager = LibraryManager.getInstance();
        baseUrl = libraryManager.getConfigReader().getProtocol() + libraryManager.getConfigReader().getUrlPrefix()
                + libraryManager.getConfigReader().getBaseUrl();
    }
}
