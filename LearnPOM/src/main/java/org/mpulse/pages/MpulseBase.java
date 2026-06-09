package org.mpulse.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import readExcel.DataProvInteg;

public class MpulseBase {
	String URL = "https://mpulse.co.in/login";
	public RemoteWebDriver driver = null;
	
	@DataProvider(name="data")
	public String[][] dataProvider() {
		
		String[][] excelData = DataProvInteg.getExcelData("TC001");
		return excelData;
	}
	
	@BeforeMethod
	public void startApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}
	
	

}
