package stepDefinitions;

import apiEngine.endPoints.IRestResponse;
import apiEngine.endPoints.request.Authentication;
import apiEngine.model.responses.Token;
import cucumber.TestContext;
import enums.Context;
import io.cucumber.java.en.When;

public class AuthSteps extends BaseSteps {

    private final Authentication authentication;

    public AuthSteps(TestContext testContext) {
        super(testContext);
        authentication = testContext.getRequestManager().getAuthentication();
    }

    @When("User sent authentication and receive token")
    public void getAuthenticationToken() {
        getScenarioContext().getDataManager().getAuthentication().getAdminAuthentication();
        IRestResponse<Token> restResponse = authentication.sentAuthentication(getScenarioContext()
                .getDataManager().getAuthentication().getAdminAuthentication());
        getScenarioContext().setContext(Context.TOKEN, restResponse.getBody().token);
    }
}
