package learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/table");
		WebElement table = driver.findElement(By.id("simpletable"));
		List<WebElement> headers =  table.findElements(By.tagName("th"));
		for (WebElement header : headers) {
			String text = header.getText();
			System.out.println(text);
			
		}
		List<WebElement> allRows = table.findElements(By.xpath("//table[@id='simpletable']/tbody/tr"));
		int size = allRows.size();
		System.out.println(size);
		if (size == 3) {
			System.out.println("Pass");
		}else 
			System.out.println("Fail");
		for (WebElement row : allRows) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			WebElement firstColumn = columns.get(0);
			System.out.println(firstColumn.getText());
//			WebElement secondColumn = columns.get(1);
//			System.out.println(secondColumn.getText());
			
		}
		for (int i = 0; i < size; i++) {
			List<WebElement> rows = allRows.get(i).findElements(By.tagName("td"));
			WebElement lastName = rows.get(1);
			String text = lastName.getText();
			System.out.println(text);
			if(text.equals("Kodi")) {
				WebElement input = rows.get(3).findElement(By.tagName("input"));
				input.click();
			}
			
		}
		
		//driver.quit();
		
	}

}
