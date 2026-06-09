package testRun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/Features/login.feature"},
		dryRun = !true,
		glue = {"mpulseSteps"},
		snippets = io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE,
		monochrome = true
		

		)

public class Run extends AbstractTestNGCucumberTests{
	
}
