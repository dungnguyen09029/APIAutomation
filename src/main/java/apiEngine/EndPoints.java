package apiEngine;

import data.GlobalVariables;
import utilities.LibraryManager;

public class EndPoints {

    protected LibraryManager libraryManager;
    protected String baseUrl;

    public EndPoints() {
        libraryManager = LibraryManager.getInstance();
        baseUrl = GlobalVariables.PROTOCOL + GlobalVariables.BASE_URL_PREFIX + GlobalVariables.BASE_URL;
    }
}
