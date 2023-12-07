package cucumber;

import apiEngine.RestResponse;
import apiEngine.manager.RequestManager;
import utilities.LibraryManager;

public class TestContext {

    private final ScenarioContext scenarioContext;
    private RestResponse restResponse;
    private final LibraryManager libraryManager;
    private final RequestManager requestManager;

    public TestContext() {
        scenarioContext = new ScenarioContext();
        libraryManager = LibraryManager.getInstance();
        requestManager = new RequestManager();
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

    public RequestManager getRequestManager() {
        return requestManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
