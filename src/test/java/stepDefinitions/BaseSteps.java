package stepDefinitions;

import cucumber.ScenarioContext;
import cucumber.TestContext;

public class BaseSteps {

    protected TestContext testContext;
    private ScenarioContext scenarioContext;

    public BaseSteps(TestContext testContext) {
        this.testContext = testContext;
        scenarioContext = testContext.getScenarioContext();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
