package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        glue = {"stepDefinitions","base"},
        tags = "@test"
        )

public class TestRunner {



}
