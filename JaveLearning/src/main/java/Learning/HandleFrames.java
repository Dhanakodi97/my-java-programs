package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/frame");
		//frame index concept
		//driver.switchTo().frame(0); 
		//frame(id or name is there is this applicable, if not applicable means we use xpath
		WebElement myframe = driver.findElement(By.xpath("//iframe[@src='frameUI']"));
		driver.switchTo().frame(myframe);
		driver.findElement(By.name("fname")).sendKeys("Dhanakodi");
		driver.findElement(By.name("lname")).sendKeys("Sunraj");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dhanakodis17@gmail.com");
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).sendKeys("S");
		
	

}

}