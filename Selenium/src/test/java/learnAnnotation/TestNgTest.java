	package learnAnnotation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgTest {
  @Test(dataProvider = "login")
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
  public void myTest() {
	  System.out.println("My Test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
  }
  @DataProvider(name="login")
  public String[][] login() {
	  String[][] data = new String[2][2];
		data[0][0]="mnw3368";
		data[0][1]="Dhana@123";
		
		data[1][0]="mnw3037";
		data[1][1]="Raghs#123";
		return data;
	  
  }

}
