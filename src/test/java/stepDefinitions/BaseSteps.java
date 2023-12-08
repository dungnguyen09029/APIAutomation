package stepDefinitions;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import utilities.AssertUtils;

public class BaseSteps {

    protected TestContext testContext;
    private final ScenarioContext scenarioContext;
    private final AssertUtils assertUtils;

    public BaseSteps(TestContext testContext) {
        this.testContext = testContext;
        scenarioContext = testContext.getScenarioContext();
        assertUtils = testContext.getLibraryManager().getAssertUtils();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public AssertUtils getAssertUtils() {
        return assertUtils;
    }
}
