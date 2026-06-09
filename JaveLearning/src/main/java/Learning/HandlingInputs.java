package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingInputs {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/edit");
		driver.manage().window().maximize();
		driver.findElement(By.id("fullName")).sendKeys("Dhanakodi");
		driver.findElement(By.id("join")).sendKeys(" Person",Keys.TAB);
		String myValue =  driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(myValue);
		driver.findElement(By.id("clearMe")).clear();
		driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		
	}

}
