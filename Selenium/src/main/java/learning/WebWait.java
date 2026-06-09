package learning;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// ALERT IS PRESENT CONCEPT
//		driver.get("https://letcode.in/waits");
//		driver.findElement(By.id("accept")).click();
//		Alert until = wait.until(ExpectedConditions.alertIsPresent());
//		wait.until(ExpectedConditions.)
//		System.out.println(until.getText());
//		until.accept();
		
		//INVISIBILITY
		driver.get("https://letcode.in/signin");
		driver.findElement(By.name("email")).sendKeys("kodimath123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Dhana@1997");
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		WebElement toast = driver.findElement(By.xpath("//div[@role='alertdialog']"));
		//driver.close();
		wait.until(ExpectedConditions.visibilityOf(toast));
		
		
		

	}

}
