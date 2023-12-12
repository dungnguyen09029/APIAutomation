package stepDefinitions;

import cucumber.TestContext;
import data.GlobalVariables;
import io.cucumber.java.en.Then;

public class GeneralSteps extends BaseSteps {

    public GeneralSteps(TestContext testContext) {
        super(testContext);
    }

    @Then("The response status code should be {int}")
    public void verifyResponseCode(int code) {
        int statusCode = testContext.getRestResponse().getStatusCode();
        getAssertUtils().assertEquals(statusCode, code);
    }

    @Then("User assert all issue")
    public void assertAll() {
        if (GlobalVariables.isSoftAssert)
            getAssertUtils().getSoftAssert().assertAll();
    }
}
