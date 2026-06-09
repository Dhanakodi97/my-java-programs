package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInstance {
    public static WebDriver driver;
    public static WebDriverWait wait;
    

    public static void initializeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        }
    }
}
