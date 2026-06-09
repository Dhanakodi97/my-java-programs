package testRunner;   

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/features/"},
		dryRun = !true,
		glue = {"steps"},
		snippets = io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE,
		monochrome = true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			}
		//tags = "@login"

		)

public class Runner extends AbstractTestNGCucumberTests {

}
