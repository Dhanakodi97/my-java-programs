package Javaselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Mpulse {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedrive.exe");
	
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://mpulse.co.in/login");
 
        // Maximize the browser fa fa-bell 
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("MNW3368");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Dhana#321");
        driver.findElement(By.xpath("//button[@name='login_form']")).click();
        driver.findElement(By.xpath("//span[text()='Food Order  ']")).click(); //text based xpath
        driver.findElement(By.xpath("//a[text()='  Book now                                     ']")).click(); //text based xpath
        driver.findElement(By.xpath("(//input[@class='breakfast'])[1]/ancestor::td")).click(); //ancestor xpath
        driver.findElement(By.xpath("(//input[@class='breakfast'])[2]/parent::div")).click(); //parent xpath
        driver.findElement(By.xpath("(//td[@title='FREE'])[4]/div/input")).click(); // child xpath
        driver.findElement(By.xpath("(//td[@title='FREE'])[6]/child::div/input")).click(); // child xpath another way
//        driver.findElement(By.xpath("(//input[@id='myCheckbox' and @class='breakfast'])[last()-3]")).click(); //Condition xpath and last()
//        driver.findElement(By.xpath("//i[@class='fa fa-forward']")).click();
       
        
//        driver.findElement(By.xpath("//i[@class='fa fa-cutlery ']")).click();
//        driver.findElement(By.xpath("//i[@class='fa fa-bell ']")).click();
        //driver.findElement(By.xpath("//i[@class='fa fa-bell ']")).click();
        //driver.findElement(By.xpath("//i[@class='fa fa-bell ' and @aria-hidden='true']")).click();
        //driver.findElement(By.xpath("//i[@class='fa fa-area-chart ']")).click();
//        driver.quit();


	}
}
