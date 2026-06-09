package Learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.switchTo().alert().accept();             NoAlertPresentExeption
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
		//Thread.sleep(2000);
		//driver.switchTo().alert().accept(); 
		//This is accept access only, but this process is fast, so we printing the	alert messages so we use another way
		Alert alert = driver.switchTo().alert();
		//System.out.println(driver.getCurrentUrl());       UnhandledAlertException
		String text = alert.getText();
		System.out.println("The Simple Alert text "+ text);
		alert.accept();	

	}

}
