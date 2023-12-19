package apiEngine.endPoints;

import data.GlobalVariables;
import utilities.LibraryManager;
import utilities.Log;

public class BaseEndPoints {

    protected String baseUrl;
    protected LibraryManager libraryManager;

    public BaseEndPoints() {
        baseUrl = GlobalVariables.PROTOCOL + GlobalVariables.BASE_URL_PREFIX + GlobalVariables.BASE_URL;
        Log.logInfo("Base URL: " + baseUrl);
        libraryManager = LibraryManager.getInstance();
    }
}
