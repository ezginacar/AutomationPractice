package runner;


import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        glue = {"src/test/java/stepDefinitions"},
        plugin = "json:target/cucumber-reports/CucumberTestReport.json",
        dryRun = false

        )

public class TestRunner {



}
