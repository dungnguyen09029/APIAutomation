package utilities;

import data.GlobalVariables;

public class UrlUtils {

    public String buildBaseUrl() {
        return GlobalVariables.PROTOCOL + GlobalVariables.BASE_URL_PREFIX + GlobalVariables.BASE_URL;
    }

    public String buildEndPoint(String endpoint) {
        return GlobalVariables.SEPARATOR + endpoint;
    }
}
