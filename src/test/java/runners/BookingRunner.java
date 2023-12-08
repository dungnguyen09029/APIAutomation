package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/functionalTests/Booking.feature",
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

public class BookingRunner extends AbstractTestNGCucumberTests { }

