package testNgBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProv {
	@DataProvider(name="login")
	public String[][] getData() {
		String[][] data = new String[2][2];
		data[0][0]="mnw3368";
		data[0][1]="Dhana@123";
		
		data[1][0]="mnw3037";
		data[1][1]="Raghs#123";
		return data;
	}
	@Test(dataProvider = "login" )
	public void login(String usern, String pass) {
		WebDriver driver = new ChromeDriver();
		System.out.println(usern + " "+ pass);
		driver.get("https://mpulse.co.in/login");
		driver.findElement(By.name("username")).sendKeys(usern);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("login_form")).click();
		String title = driver.getTitle();
		System.out.println("The Title is" + title);
		driver.quit();
	}

}
