package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "rerun:target/cucumber-reports/rerun.txt"
        })

public class SuiteRunner {

}
