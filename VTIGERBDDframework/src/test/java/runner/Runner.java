package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".\\src\\test\\java\\features"},
glue = {"stepDefinition"},
dryRun = false,
tags = "@SmokeTest or @Functional"
		)
public class Runner extends AbstractTestNGCucumberTests{


}
