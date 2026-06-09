package mpulseSteps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MpulseLoginSteps{
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User should navigate to the application login")
	public void userShouldNavigateToTheApplicationLogin() {
		//driver = new ChromeDriver();
		driver.get("https://mpulse.co.in/login");
		driver.manage().window().maximize();
		wait =new  WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("User enter the username as MNW3368")
	public void userEnterTheUsernameAsMNW3368() {
		driver.findElement(By.id("username")).sendKeys("MNW3368");
		
	}


	@Given("User enter the password as Dhana!123")
	public void userEnterThePasswordAsDhana() {
		driver.findElement(By.id("password")).sendKeys("Dhana!123");

	}
	
	@When("User click the login button")
	public void userClickTheLoginButton() {
		driver.findElement(By.xpath("//button[@name='login_form']")).click();
	    
	}
	@Then("login should be success")
	public void loginShouldBeSuccess() {
		WebElement text = driver.findElement(By.xpath("//a[@class='dropdown-toggle emp__name']"));
		wait.until(ExpectedConditions.visibilityOf(text));
		
		//driver.quit();
	}
	@Given("User enter the username as MNW3037")
	public void userEnterTheUsernameAsMNW3037() {
		driver.findElement(By.id("username")).sendKeys("MNW3037");
	  
	}
	@Given("User enter the password as Raghs!123")
	public void userEnterThePasswordAsRaghs(){
		driver.findElement(By.id("password")).sendKeys("Raghs!12345");
	}
//	@But("login should be fail")
//	public void loginShouldBeFail() {
//		System.out.println("Login should be Fail");
//	    
//		driver.quit();
//	}
	
	@When("login should be fail")
	public void loginShouldBeFail() {
		System.out.println("Login should be Fail");
		
		driver.quit();
	}

	
	
	
}
