package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SubmitForm {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.get("https://mpulse.co.in/login");
        driver.manage().window().maximize();
        WebElement activeElement = driver.switchTo().activeElement();
        activeElement.sendKeys("MNW3368",Keys.TAB,"Dhana#123",Keys.ENTER);
        
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("MNW3368");
//        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Dhana#123");
//        driver.findElement(By.xpath("//button[@name='login_form']")).submit();
	}	

}
