package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Log;

@CucumberOptions(
        features = "src/test/resources/functionalTests/update",
        glue = {"stepDefinitions"},
        tags = "@API",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/UpdateBookRunner.html",
                "rerun:target/cucumber-reports/rerun.txt",
                "json:target/cucumber-reports/UpdateBookRunner.json"
        }
)

public class UpdateBookRunner extends AbstractTestNGCucumberTests {
        @BeforeTest
        public void setupTest() {
                Log.startTestSet("Start Update Booking Test Set");
        }

        @AfterTest
        public void endTest() {
                Log.endTestSet("End Update Booking Test Set");
        }
}
