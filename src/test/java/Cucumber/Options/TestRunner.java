package Cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FeatureFile",
        plugin = "json:target/jsonReports/Cucumber_Reports.json",
        glue = {"StepDefinitions"})
//tags = "@Regression"
public class TestRunner {
}
