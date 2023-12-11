package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Log;

@CucumberOptions(
        features = "src/test/resources/functionalTests/CreateBooking.feature",
        glue = {"stepDefinitions"},
        tags = "@API",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/BookingRunner.html",
                "rerun:target/cucumber-reports/rerun.txt",
                "json:target/cucumber-reports/BookingRunner.json"
        }
)

public class BookingRunner extends AbstractTestNGCucumberTests {
        @BeforeTest
        public void setupTest() {
                Log.startTestSet("Create Booking Test Set");
        }

        @AfterTest
        public void endTest() {
                Log.endTestSet("Create Booking Test Set");
        }
}

