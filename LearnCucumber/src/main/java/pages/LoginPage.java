package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.DriverInstance;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends DriverInstance {
	@Given("User should navigate to the application")
	public void userShouldNavigateToTheApplication() {
	    // Write code here that turns the phrase above into concrete actions

	}
	@Given("User should login as {string} and {string}")
	public void userShouldLoginAsAnd(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Given("User should navigate to the application login")
	public void userShouldNavigateToTheApplicationLogin() {
	    // Write code here that turns the phrase above into concrete actions

	}
	@Given("User enter the username as Ortoni")
	public void userEnterTheUsernameAsOrtoni() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("User enter the password as Pass1234")
	public void userEnterThePasswordAsPass1234() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	@Given("User enter the username as Sidhu")
	public void userEnterTheUsernameAsDhana() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("ortoni");
		
	}


	@Given("User enter the password as Dhana@1997")
	public void userEnterThePasswordAsPass() {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("pass1234");

	}
	
	@When("User click the login button")
	public void userClickTheLoginButton() {
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	    
	}
	@Then("login should be success")
	public void loginShouldBeSuccess() {
		WebElement text = driver.findElement(By.xpath("//span[text()=' ortoni']"));
		wait.until(ExpectedConditions.visibilityOf(text));
		
		//driver.quit();
	}
	@Given("User enter the username as Dhanakodi")
	public void userEnterTheUsernameAsDhanakodi() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Dhanakodi");
	  
	}
	@Given("User enter the password as Dhana@1997")
	public void userEnterThePasswordAsDhana1997(){
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Dhana@1997");
	}
	@But("login should be fail")
	public void loginShouldBeFail() {
		System.out.println("Login should be Fail");
	    
		driver.quit();
	}

}
