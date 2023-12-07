package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue = {"stepDefinitions"},
        tags = "@API",
        monochrome = true
)

public class BookingRunner extends AbstractTestNGCucumberTests {
//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass(ITestContext context) {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() {
//        testNGCucumberRunner.finish();
//    }
}

