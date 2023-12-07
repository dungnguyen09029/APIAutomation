package context;

import apiEngine.RestResponse;
import utilities.LibraryManager;

public class TestContext {

    private ScenarioContext scenarioContext;
    private RestResponse restResponse;
    private LibraryManager libraryManager;

    public TestContext() {
        scenarioContext = new ScenarioContext();
        libraryManager = LibraryManager.getInstance();
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }

    public RestResponse getRestResponse () {
        return restResponse;
    }

    public LibraryManager getLibraryManager() {
        return libraryManager;
    }
}
