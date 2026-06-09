package hooks;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import base.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;

public class Hooks extends DriverInstance {
	
	@BeforeStep
	public void beforeSteps(Scenario scenario) {
		//scenario.log("Started - Dhanakodi");
	}
	
	@AfterStep
	public void afterSteps(Scenario scenario) {
		//scenario.log("Finished - Dhanakodi");
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		String name = scenario.getName();
		System.out.println("Scenario name :" + name);
		System.out.println("ID : "+ scenario.getId());
		System.out.println("Lines : " + scenario.getName());
		System.out.println("URI : "+ scenario.getUri());
		//System.out.println("Tag names: " + scenario.getSourceTagNames());
	}
	
	@After("@cleanUp")
	public void cartCleanUp(Scenario scenario) {
		scenario.log("Before cleaning Cart Data");
//		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenshotAs, "image/png", "Success screenshot");
		
		
		
		
		driver.findElement(By.id("mat-badge-content-0")).click();
		driver.findElement(By.xpath("//button[@class='mat-elevation-z4 mdc-button mdc-button--raised mat-mdc-raised-button mat-unthemed mat-mdc-button-base']")).click();
		String text = driver.findElement(By.tagName("mat-card-title")).getText();
		Assert.assertEquals(text, "Your shopping cart is empty.");
		scenario.log("After cleaning Cart Data");
//		byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenshotAs, "image/png", "Success screenshot");

		
	}
	                                         
	
	@After
	public void afterScenario(Scenario scenario) {
		boolean failed = scenario.isFailed();
		System.out.println("Is Failed : "+ failed);
//		byte[] screenshotAs = driver.getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenshotAs, "image/png", "Success screenshot");
//		driver.quit();
		
		
		// Take screenshot if the scenario failed
        if (failed) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        } 
        
        Status status = scenario.getStatus();
        System.out.println("Result: " + status);
        

        if (driver != null) {
            driver.quit();
        }	
		
		
	}

}
