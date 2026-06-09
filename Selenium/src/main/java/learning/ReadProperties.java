package learning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadProperties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
//		 Properties properties = new Properties();
//		 properties.load(new FileInputStream("./letCodeFrench.properties"));
//		 String property = properties.getProperty("welcome");
//		 System.out.println(property);
		
		Properties properties = new Properties();
		properties.load(new FileInputStream("./locators.properties"));
		WebDriver driver = new ChromeDriver();
		driver.get("https://mpulse.co.in/login");
		driver.findElement(By.name("username")).sendKeys(properties.getProperty("Username"));
		driver.findElement(By.name("password")).sendKeys(properties.getProperty("Password"));
		driver.findElement(By.name("login_form")).click();
		driver.quit();
		 
	}

}
