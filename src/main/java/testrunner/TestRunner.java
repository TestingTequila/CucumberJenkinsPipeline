package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features", tags = "@Sanity", glue = "stepdefinitions", dryRun = false, plugin = {"pretty", "html:target/Login.html", "junit:target/Login.xml", "json:target/Login.json"})
public class TestRunner {
}
