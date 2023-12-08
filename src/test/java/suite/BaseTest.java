package suite;

import cucumber.TestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected TestContext testContext;

    public BaseTest() {
        testContext = new TestContext();
    }

    // Follow this method to run test case without cucumber
    @BeforeSuite
    public void beforeSuite() {

    }

    @AfterSuite
    public void afterSuite() {

    }
}
