package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigation {

	public static void main(String[] args) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/buttons");
		driver.manage().timeouts().implicitlyWait(0, null)
		//driver.navigate().to("https://mpulse.co.in/login");
		driver.manage().window().maximize();
		String Url = driver.getCurrentUrl();
		System.out.println("Button page URL: " + Url);
		Thread.sleep(3000);
		driver.findElement(By.id("home")).click();
		String homeUrl = driver.getCurrentUrl();
		System.out.println("Home page URL : "+ homeUrl);
		Thread.sleep(3000);
		driver.navigate().back();	
		System.out.println("Navigate back URL : "+driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.navigate().forward();
		System.out.println("Navigate forward URL : "+driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("Navigate refresh URL : "+driver.getCurrentUrl());
		Thread.sleep(3000);
		driver.navigate().to("https://mpulse.co.in/login");
		Navigation nav = driver.navigate();
		nav.back();                                 
		
// Handling Buttons concept workout with letcode.in website
		//Get the X and Y co-ordinates location
//		driver.findElement(By.id("position")).getLocation();
//								OR
		WebElement ele = driver.findElement(By.id("position"));
		Point point = ele.getLocation();
		int x = point.getX();
		int y = point.getY();
		System.out.println("X location is " + x);
		System.out.println("Y location is " + y);
		
		//Find the color of the button
		WebElement btnColor = driver.findElement(By.id("color"));
		String color =  btnColor.getCssValue("background-color");
		System.out.println(color);
		
		//Find the height and width
		Rectangle rect = driver.findElement(By.id("property")).getRect();
		Dimension dime = rect.getDimension();
		System.out.println("The Dimension is " + dime);
		System.out.println("The Dimension of height is " + dime.getHeight());
		System.out.println("The Dimension of width is " + dime.getWidth());
//									OR
//		Rectangle rect = driver.findElement(By.id("property")).getRect();
		System.out.println("Height " + rect.getHeight());
		System.out.println("Width " + rect.getWidth());
		System.out.println("Dimension " + rect.getDimension());
		
		// Confirm button is disabled
		boolean btn = driver.findElement(By.id("isDisabled")).isEnabled();
		System.out.println(btn);
		
		driver.quit();

	}

}
