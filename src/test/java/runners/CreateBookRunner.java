package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Log;

@CucumberOptions(
        features = "src/test/resources/functionalTests/createBook",
        glue = {"stepDefinitions"},
        tags = "@API",
        plugin = {
//                "pretty",
//                "html:target/cucumber-reports/CreateBookRunner.html",
//                "rerun:target/cucumber-reports/rerun.txt",
//                "json:target/cucumber-reports/CreateBookRunner.json"
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)

public class CreateBookRunner extends AbstractTestNGCucumberTests {
        @BeforeTest
        public void setupTest() {
                Log.startTestSet("Start Create Booking Test Set");
        }

        @AfterTest
        public void endTest() {
                Log.endTestSet("End Create Booking Test Set");
        }
}
