package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./Features/Customers.feature",
				 glue = "stepDefinations",
				 monochrome = true,
				 dryRun = false,
				 plugin = "pretty"
				)



public class TestRunner {

}
