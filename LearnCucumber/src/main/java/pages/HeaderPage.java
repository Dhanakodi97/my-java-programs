package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HeaderPage extends DriverInstance{
	
	
	@Given("User clicks on the login link")
	public void userClicksOnTheLoginLink() {
		driver.findElement(By.xpath("//span[text()=' Login ']")).click();
	    
	}	
	
	@Given("User search a {string}")
	public void userSearchA(String book) {
		driver.findElement(By.xpath("//input[@placeholder='Search books or authors']")).sendKeys(book);		
	    driver.findElement(By.xpath("//span[@class='mdc-list-item__primary-text']")).click();
	    //WebElement search = wait.until(ExpectedConditions.visibilityOf(searchOption));
	    //searchOption.click();
	    
	}
	
	@Then("the cart badge should be updated")
	public void theCartBadgeShouldBeUpdated() {
		WebElement notifyBar = driver.findElement(By.xpath("//div[@class='cdk-overlay-container']"));
//		wait.until(ExpectedConditions.visibilityOf(notifyBar));
//		wait.until(ExpectedConditions.invisibilityOf(notifyBar));
		String text = driver.findElement(By.cssSelector("#mat-badge-content-0")).getText();
		System.out.println("The Number of bookd : " + text);
	    Assert.assertEquals(Integer.parseInt(text)>0, true);
		//driver.quit();
}
	

}
