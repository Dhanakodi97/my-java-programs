package Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("cricket",Keys.ENTER);
		List<WebElement> Crickets = driver.findElements(By.xpath("//*[contains(text(),'cricket') or contains(text(),'Cricket')]"));
		System.out.println(Crickets.size());
		for (WebElement cricket : Crickets) {
			String text1 = cricket.getText();
			System.out.println(text1);
		}
		
		driver.quit();
		

	}

}
