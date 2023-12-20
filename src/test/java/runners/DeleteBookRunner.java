package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Log;

@CucumberOptions(
        features = "src/test/resources/functionalTests/delete",
        glue = {"stepDefinitions"},
        tags = "@API",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/DeleteBookRunner.html",
                "rerun:target/cucumber-reports/rerun.txt",
                "json:target/cucumber-reports/DeleteBookRunner.json"
        }
)

public class DeleteBookRunner extends AbstractTestNGCucumberTests {
        @BeforeTest
        public void setupTest() {
                Log.startTestSet("Start delete Booking Test Set");
        }

        @AfterTest
        public void endTest() {
                Log.endTestSet("End delete Booking Test Set");
        }
}
