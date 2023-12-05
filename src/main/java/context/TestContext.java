package context;

import io.restassured.response.Response;
import response.ResponseHandler;

public class TestContext {

    private ScenarioContext scenarioContext;
    private ResponseHandler responseHandler;

    public TestContext() {
        scenarioContext = new ScenarioContext();
    }

    public void setResponseHandler(Response response) {
        responseHandler = new ResponseHandler(response);
    }

    public ResponseHandler getResponseHandler() {
        return responseHandler;
    }
}
