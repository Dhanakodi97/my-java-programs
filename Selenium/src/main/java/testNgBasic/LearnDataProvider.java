package testNgBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import learning.DataUtils;

public class LearnDataProvider extends DataUtils{
	//Concept 1: Use Extend keyword and extends a class to another class
	//Concept 2: Use @Test Annotations and use DataProviderClass = classname.class
	//ie) @Test(dataProvider = "login",dataProviderClass = DataUtils.class
	
	@Test(dataProvider = "getData",dataProviderClass = DataUtils.class)
	public void login(String data[]) {
		System.err.println("Username: "+ data[0]);		
		System.err.println("Password: "+ data[1]);
		WebDriver driver = new ChromeDriver();
		System.out.println(data[0] + " "+ data[1]);
		driver.get("https://mpulse.co.in/login");
		driver.findElement(By.name("username")).sendKeys(data[0]);
		driver.findElement(By.name("password")).sendKeys(data[1]);
		driver.findElement(By.name("login_form")).click();
		String title = driver.getTitle();
		System.out.println("The Title is" + title);
		driver.quit();
	}
	

}
