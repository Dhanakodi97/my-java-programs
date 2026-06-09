package learning;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Smart Watch",Keys.ENTER);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("SmartPhone");
		//Create a header row
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Product URL");
		header.createCell(1).setCellValue("Product Name");
		header.createCell(2).setCellValue("MRP");
		header.createCell(3).setCellValue("Sales Price");
		header.createCell(4).setCellValue("Offer");
		int rowNum=1; //(Because of 0th row are header
		List<WebElement> items = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//Iterate the items
		for (int i = 0;i<=0 ; i++) {
			WebElement item = items.get(i);
			//Row row = sheet.createRow(rowNum++);
			Row row = sheet.createRow(rowNum++);
			item.click();
			Set<String> windowHandle = driver.getWindowHandles();
			String tab = driver.getWindowHandle();
			for (String handle : windowHandle) {
				if(!handle.equals(tab)) {
				driver.switchTo().window(handle); // Switch to New Tab
				break;		
				}
			}
			
			String productUrl = driver.getCurrentUrl();
			row.createCell(0).setCellValue(productUrl);
			System.out.println("Product URL :" + productUrl);
			//Getting Product Name
			//WebDriver wait = new WebDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-size-large product-title-word-break']")));
			String productTitle = titleElement.getText();
			row.createCell(1).setCellValue(productTitle);
			System.out.println("Product Title: "+ productTitle);
			//Getting MRP
			
				WebDriverWait waitMRP = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement productMRP = waitMRP.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-price a-text-price']")));
				String mrp = productMRP.getText();
				row.createCell(2).setCellValue(mrp);
				System.out.println("MRP: " + mrp);
			//Getting sales price	
				WebDriverWait waitSP = new WebDriverWait(driver, Duration.ofSeconds(10)); 
				WebElement productSP = waitSP.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")));
				String sp = productSP.getText();
				row.createCell(3).setCellValue(sp);
				System.out.println("SP: " + sp);
			//Getting Offer
				WebDriverWait waitOffer = new WebDriverWait(driver, Duration.ofSeconds(10)); 
				WebElement offer = waitOffer.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-size-large a-color-price savingPriceOverride aok-align-center reinventPriceSavingsPercentageMargin savingsPercentage']")));
				String productOffer = offer.getText();
				//productOffer.replaceAll("%", "percent");
				row.createCell(4).setCellValue(productOffer);
				//System.out.println("Offer: " + productOffer);
				
				String repl = productOffer.replaceAll("%", " Offer");
				System.out.println("Offer: " + repl);
			
			
			driver.close();
			driver.switchTo().window(tab);
			Thread.sleep(2000);
		}
		FileOutputStream fileOut = new FileOutputStream(new File(".\\Output\\Amazon.xlsx"));
		workbook.write(fileOut);
		fileOut.close();
		System.out.println("Excel file created successfully!");
		driver.quit();

	}

}

