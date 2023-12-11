package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import utilities.Log;

@CucumberOptions(
        features = "src/test/resources/functionalTests/TSParallel001",
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/RunParallel001.html",
                "json:target/cucumber-reports/RunParallel001.json"
        }
)

public class RunParallel001 extends AbstractTestNGCucumberTests {
        @BeforeTest
        public void setupTest() {
                Log.startTestSet("Test Parallel 001");
        }

        @AfterTest
        public void endTest() {
                Log.endTestSet("Test Parallel 001");
        }

//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }
}

