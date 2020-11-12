package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features"},
        plugin = { "html:target/cucumber-report/cucumber.html"},
        glue = {"stepDefinitions"}

)
public class TestCucumberRunner {
}
