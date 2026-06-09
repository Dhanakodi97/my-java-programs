package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = {"src/test/java/featuresMpulse"},
		dryRun = true,
		glue = {"mpulseSteps"},
		snippets = io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE,
		monochrome = true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}		
		
		
		)

public class RunnerMpulse extends AbstractTestNGCucumberTests{
	

}
