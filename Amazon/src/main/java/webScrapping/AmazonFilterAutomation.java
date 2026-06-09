package webScrapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonFilterAutomation {
    public static void main(String[] args) throws IOException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("https://www.amazon.in");
            driver.manage().window().maximize();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("earphones");
            driver.findElement(By.id("nav-search-submit-button")).click();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Earphone Datas");
            Row firstRow = sheet.createRow(0);
            firstRow.createCell(0).setCellValue("Particulars");
            firstRow.createCell(1).setCellValue("Filters");
            firstRow.createCell(2).setCellValue("Values");
            
            
            List<WebElement> header =  driver.findElements(By.xpath("//span[@class='a-size-base a-color-base puis-bold-weight-text']"));
            int rowNum = 1;
            for (int i = 0; i <=20; i++) {
    			WebElement item = header.get(i); 
    			firstRow.createCell(0).setCellValue(rowNum++);
    			
    			//Row row = sheet.createRow(rowNum++);
    			// Click the product to go to the product page
    			item.click();
    			
            }	
    			FileOutputStream fileOut = new FileOutputStream(new File(".\\Output\\Amazon_output.xlsx"));
				workbook.write(fileOut);
				fileOut.close();
				System.out.println("Excel file created successfully!");
				driver.quit();
		
        }
    
}