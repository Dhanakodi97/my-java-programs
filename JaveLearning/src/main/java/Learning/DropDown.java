package Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		//driver.manage().wait();
		WebElement fruits = driver.findElement(By.id("fruits"));
		Select myFruits = new Select(fruits);
		myFruits.selectByVisibleText("Apple");
		myFruits.selectByVisibleText("Banana");
		WebElement selFruits = myFruits.getFirstSelectedOption();
		System.out.println("My selection : " + selFruits.getText());
		System.out.println(myFruits.isMultiple());
		
		
		WebElement Country = driver.findElement(By.id("country"));
		Select myCountry = new Select(Country);
		myCountry.selectByVisibleText("India");
		WebElement SelCountry = myCountry.getFirstSelectedOption();
		System.out.println(SelCountry.getText());
		
		WebElement heros = driver.findElement(By.id("superheros"));
		Select myHeros = new Select(heros);
		boolean isMul = myHeros.isMultiple();
		System.out.println("Is Multiple "+isMul);
		myHeros.selectByIndex(1);
		myHeros.selectByValue("bt");
		myHeros.selectByIndex(5);
		List<WebElement> allHeros =  myHeros.getAllSelectedOptions();
		//System.out.println(allHeros);
		for (WebElement WebElement : allHeros) {
			System.out.println(WebElement.getText());
		}
		
		

	}

}
