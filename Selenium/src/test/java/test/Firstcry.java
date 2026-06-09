package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Firstcry {
	@Test

	public void website() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.firstcry.com/babyhug-disney/babyhug-disney-cotton-woven-full-sleeves-night-suit-with-mickey-mouse-print-yellow/18053548/product-detail");
		WebElement run = driver.findElement(By.xpath("/html/body/app-productdetail-rvp[1]/span/section[1]/section[1]/section[2]/section[1]/h1"));
		String name = run.getText();
	
		System.out.println(name);
		driver.quit();

	}

}
