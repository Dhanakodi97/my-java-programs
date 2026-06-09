package Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFindElements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		List<WebElement> labels = driver.findElements(By.tagName("label"));
		WebElement lastElement = labels.get(labels.size()-1);
		System.out.println(lastElement.getText());
		int size = labels.size();
		if (size == 6) {
			System.out.println("Test case is passed");
		}
		else{
			System.out.println("Test case is failed");
		}
		for (WebElement label : labels) {
			String text = label.getText();
			System.out.println(text);
			
			
		};
	}

}
