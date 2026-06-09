package testNgBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MpulseLogin {
	RemoteWebDriver driver;
	@Parameters({"username","password","browser"})
	@Test
	public void login(String usern, String pass,String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("browser is not defined");
			break;
		}
		
		System.out.println(usern + " "+ pass);
		driver.get("https://mpulse.co.in/login");
		driver.findElement(By.name("username")).sendKeys(usern);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("login_form")).click();
		String title = driver.getTitle();
		System.out.println("The Title is" + title);
	
	}

}
