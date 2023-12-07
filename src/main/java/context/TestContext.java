package context;

import io.restassured.response.Response;
import apiEngine.endpoint.ResponseHandler;
import utilities.LibraryManager;

public class TestContext {

    private ScenarioContext scenarioContext;
    private ResponseHandler responseHandler;
    private LibraryManager libraryManager;

    public TestContext() {
        scenarioContext = new ScenarioContext();
        libraryManager = LibraryManager.getInstance();
    }

    public void setResponseHandler(Response response) {
        responseHandler = new ResponseHandler(response);
    }

    public ResponseHandler getResponseHandler() {
        return responseHandler;
    }

    public LibraryManager getLibraryManager() {
        return libraryManager;
    }
}
