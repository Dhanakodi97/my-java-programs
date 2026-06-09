package pages;

import org.openqa.selenium.By;

import base.DriverInstance;
import io.cucumber.java.en.When;

public class HomePage extends DriverInstance {
	
	@When("User add the book to the cart")
	public void userAddTheBookToTheCart() throws InterruptedException {
		
			driver.findElement(By.xpath
			("//span[@class='mdc-button__label']")).click();
		//WebElement cart = wait.until(ExpectedConditions.visibilityOf(addCart));
		Thread.sleep(2000);
		//addCart.click();
	   
	}

}
