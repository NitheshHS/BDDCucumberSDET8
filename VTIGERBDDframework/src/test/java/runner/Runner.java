package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".\\src\\test\\java\\features\\Organization.feature"},
glue = {"stepDefinition","hook"},
dryRun = false,
//tags = "@SmokeTest and @Functional",
plugin = {"pretty", "html:target/cucumberreport.html",
		"json:target/cucumber.json"},
monochrome = true
		)
public class Runner extends AbstractTestNGCucumberTests{
	
}
