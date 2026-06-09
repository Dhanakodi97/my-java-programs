package LearnJava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class MavenJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.google.com");
 
        // Maximize the browser
        driver.manage().window().maximize();
        
        driver.quit();
        

	}

}
	