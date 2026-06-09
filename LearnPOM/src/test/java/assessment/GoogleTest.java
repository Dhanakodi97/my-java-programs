package assessment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumBase.Base;
import seleniumBase.Browser;
import seleniumBase.Locators;

public class GoogleTest extends Base {
	
	@Test
	void searchMpulse() throws InterruptedException {
		setUp(Browser.EDGE,"https://www.google.com/");
		WebElement search = element(Locators.name,"q");
		type(search,"Mpulse.com" , Keys.ENTER);
		// Or type(element("name","q"),"Mpulse.com");
		Thread.sleep(3000);
		quit();
	}
	

}
