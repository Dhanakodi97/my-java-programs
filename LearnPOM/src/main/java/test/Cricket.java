package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cricket{
	@Test()
	public void findCricket(){ 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Foodball",Keys.ENTER);
		List<WebElement> Foodball = driver.findElements(By.xpath("//*[contains(text(),'foodball') or contains(text(),'Foodball')]"));
		System.out.println(Foodball.size());
		//driver.quit();
	}

}
