
package learnJava;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/gp/bestsellers/garden/4297301031/ref=zg_bs_nav_garden_2_3638817031");
		driver.manage().window().maximize();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet datas = workbook.createSheet("AmazonDatas");
		Row headerRow = datas.createRow(0);
		headerRow.createCell(0).setCellValue("Product URL");
		headerRow.createCell(1).setCellValue("Product Name");
		headerRow.createCell(2).setCellValue("MRP");
//		headerRow.createCell(3).setCellValue("SP");		
//		headerRow.createCell(4).setCellValue("Offer");
		int rowNum = 1;
		List<WebElement> items = driver.findElements(By.xpath("//a[@class='image-holder']"));
		for (int i = 0; i <=20; i++) {
			WebElement item = items.get(i); 
			Row row = datas.createRow(rowNum++);
			// Click the product to go to the product page
			item.click();
			// Switch to the new tab
			
			Set<String> windowHandles = driver.getWindowHandles();
			String originalTab = driver.getWindowHandle(); // Store the handle of the original tab
			// Switch to the new tab 
			for (String handle : windowHandles) {
				if (!handle.equals(originalTab)) {
					driver.switchTo().window(handle); // Switch to the new tab
					break;
				}
			}
			String productUrl = driver.getCurrentUrl();
			row.createCell(0).setCellValue(productUrl);
			System.out.println("Product URL :" + productUrl);
			// Getting Product Name
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
			WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class = 'a-size-large product-title-word-break']")));
			String productTitle = titleElement.getText();
			row.createCell(1).setCellValue(productTitle);
			System.out.println("Product Title: " + productTitle);
			// Getting MRP
						
							WebDriverWait waitMRP = new WebDriverWait(driver, Duration.ofSeconds(10));
							WebElement productMRP = waitMRP.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-price-whole']")));
							String mrp = productMRP.getText();
							row.createCell(2).setCellValue(mrp);
							System.out.println("MRP: " + mrp);
						
//						
					FileOutputStream fileOut = new FileOutputStream(new File(".\\Output\\Amazon_output"));
					workbook.write(fileOut);
					fileOut.close();
					System.out.println("Excel file created successfully!");
					// Close the main browser window
			
	}
		driver.quit();
	}
	
}
