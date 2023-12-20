package stepDefinitions;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import utilities.AssertUtils;
import utilities.LibraryManager;

public class BaseSteps {

    protected TestContext testContext;
    private final ScenarioContext scenarioContext;
    private final AssertUtils assertUtils;
    private LibraryManager libraryManager;

    public BaseSteps(TestContext testContext) {
         this.testContext = testContext;
        scenarioContext = testContext.getScenarioContext();
        assertUtils = testContext.getLibraryManager().getAssertUtils();
        libraryManager = testContext.getLibraryManager();
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

    public AssertUtils getAssertUtils() {
        return assertUtils;
    }

    public LibraryManager getLibraryManager() {
        return libraryManager;
    }
}
