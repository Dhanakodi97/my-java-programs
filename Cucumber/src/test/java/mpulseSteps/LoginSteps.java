package mpulseSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	
	@Given("User should navigate to the application login")
	public void userShouldNavigateToTheApplicationLogin() {
		driver = new ChromeDriver();
		driver.get("https://mpulse.co.in/login");
		driver.manage().window().maximize();
	    	    
	}
	@Given("User enter the username as MNW3368")
	public void userEnterTheUsernameAsMNW3368() {
		driver.findElement(By.id("username")).sendKeys("mnw3368");
	    
	}
	@Given("User enter the password as Dhana!1234")
	public void userEnterThePasswordAsDhana() {
		driver.findElement(By.id("password")).sendKeys("Dhana!1234");
	    
	}
	@When("User click the login button")
	public void userClickTheLoginButton() {
	    driver.findElement(By.name("login_form")).click();
	}
	@Then("login should be success")
	public void loginShouldBeSuccess() {
	    WebElement pass = driver.findElement(By.xpath("//span[@style='text-transform: capitalize;']"));
	    System.out.println(pass);
	    driver.quit();
	}
//	@Given("User enter the username as MNW3037")
//	public void userEnterTheUsernameAsMNW3037() {
//		driver.findElement(By.id("username")).sendKeys("mnw3037");
//	}
//	@Given("User enter the password as Raghs!1234")
//	public void userEnterThePasswordAsRaghs() {
//		driver.findElement(By.id("password")).sendKeys("Dhana!1234");
//	}
//	
//	@When("login should be fail")
//	public void loginShouldBeFail() {
//		WebElement text = driver.findElement(By.xpath("//h5[@class='text-center error']"));
//		System.out.println(text);
//	    driver.quit();
//	}
	

}
