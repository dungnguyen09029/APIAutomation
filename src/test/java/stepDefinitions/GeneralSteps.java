package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class GeneralSteps {

    private TestContext testContext;

    public GeneralSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("The response status code should be {int}")
    public void verifyResponseCode(int code) {
        int statusCode = testContext.getRestResponse().getStatusCode();
        Assert.assertEquals(statusCode, code);
    }
}
