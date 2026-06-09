package Learning;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/buttons");
		WebElement ele = driver.findElement(By.id("home"));
		File pagesrc = ele.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/img.png");	
		FileHandler.copy(pagesrc, dest);
		
		WebElement ele1 = driver.findElement(By.className("has-background-white-ter"));
		File pagesrc1 = ele1.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./snaps/img1.png");	
		FileHandler.copy(pagesrc1, dest1);
		
		
		
		driver.quit();

	}

}