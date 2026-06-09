package org.mpulse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends MpulseBase {
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	//RemoteWebDriver driver = null;
	//Locators
	public boolean getLoginLabel() {
		driver = new ChromeDriver();
		return driver.findElement(By.xpath("//h3[@class='org_title text-uppercase']")).isDisplayed();
		//return false;
	}
	//Actions
	public LoginPage enterUserName(String usern) {
		driver.findElement(By.name("username")).sendKeys(usern);
		return this;
	}
	public LoginPage enterPassword(String pass) {
		driver.findElement(By.name("password")).sendKeys(pass);
		return this;
	}
	public DashboardPage clickSignIn() {
		driver.findElement(By.name("login_form")).click();
		return new DashboardPage();
	}
	public ForgetPasswordPage forgetPassword(String forget) {
		driver.findElement(By.xpath("//a[text()='I forgot my password']")).click();
		return new ForgetPasswordPage();
	}
	public void login(String usern,String pass) {
		enterUserName(usern);
		enterPassword(pass);
		clickSignIn();
	}

}
