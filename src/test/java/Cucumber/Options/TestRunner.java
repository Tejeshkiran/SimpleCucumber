package Cucumber.Options;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FeatureFile/GoogleApis.feature",
        glue = {"stepDefinitions"}, tags = "@Regression")

//@Regression
//tags = "@Addplace or @DeletePlace"
public class TestRunner {


}