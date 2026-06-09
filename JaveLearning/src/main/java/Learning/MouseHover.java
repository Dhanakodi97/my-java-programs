package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@role='button']")).click();
		Thread.sleep(2000);	
		WebElement elect = driver.findElement(By.xpath("//span[.='Electronics']"));  ////div[@aria-label='Electronics'] 
		Actions builder = new Actions(driver);
		builder.moveToElement(elect).perform();
		
	}

}
