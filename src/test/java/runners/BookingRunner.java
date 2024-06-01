package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Log;

@CucumberOptions(
        features = "src/test/resources/functionalTests/booking",
        glue = {"stepDefinitions"},
        tags = "@API",
        plugin = {
//                "pretty",
//                "html:target/cucumber-reports/BookingRunner.html",
//                "rerun:target/cucumber-reports/rerun.txt",
//                "json:target/cucumber-reports/BookingRunner.json"
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)

public class BookingRunner extends AbstractTestNGCucumberTests {
        @BeforeTest
        public void setupTest() {
                Log.startTestSet("Start Booking Test Set");
        }

        @AfterTest
        public void endTest() {
                Log.endTestSet("End Booking Test Set");
        }
}

