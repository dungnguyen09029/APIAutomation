package apiEngine.endPoints;

import data.GlobalVariables;

public class BaseEndPoints {

    protected String baseUrl;

    public BaseEndPoints() {
        baseUrl = GlobalVariables.PROTOCOL + GlobalVariables.BASE_URL_PREFIX + GlobalVariables.BASE_URL;
    }
}
