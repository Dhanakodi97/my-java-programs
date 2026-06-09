package igpWebScrapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IGP {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.igp.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='country_content_cont Paragraph-14-S--Regular ']")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("pincode")).sendKeys("637503");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='apply-btn redirect-url Paragraph-12-XS--Semibold caps']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        FileInputStream file = new FileInputStream(new File(".\\Input\\IGPInputChatGpt.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        
        Workbook outputBook =  new XSSFWorkbook();
		Sheet outputSheet = outputBook.createSheet("Output Data") ;

        // Create header
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            headerRow = sheet.createRow(0);
        }
        headerRow.createCell(1).setCellValue("Product Name");
        headerRow.createCell(2).setCellValue("MRP");
        headerRow.createCell(3).setCellValue("SP");
        headerRow.createCell(4).setCellValue("Offer");
        headerRow.createCell(5).setCellValue("Availability");

        
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            String url = row.getCell(0).getStringCellValue();
            System.out.println("Opening URL: " + url);
            driver.get(url);

            try {
                // Product Name
//                WebElement nameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='prod-name Heading-5--Bold ']")));
//                String name = nameEl.getText();
//                row.createCell(1).setCellValue(name);
                
                WebDriverWait waitName = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    			WebElement name = waitName.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='prod-name Heading-5--Bold ']")));
    			String productName = name.getText();
    			row.createCell(1).setCellValue(productName);
    			System.out.println("Product Name: " + productName);

                // MRP
                try {
//                	 WebElement mrpEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='striked-price Paragraph-16-M--Regular strikethrough ']")));
//                     String mrp = mrpEl.getText();
//                     row.createCell(2).setCellValue(mrp);
                     WebDriverWait waitMrp = new WebDriverWait(driver, Duration.ofSeconds(10)); 
         			 WebElement mrp = waitMrp.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='striked-price Paragraph-16-M--Regular strikethrough ']")));
         			 String productMrp = mrp.getText();
         			 row.createCell(2).setCellValue(productMrp);
         			 System.out.println("Product Mrp: " + productMrp);
                     
                     
				} catch (Exception e) {
					e.getStackTrace();
					List<WebElement> spMrp =  driver.findElements(By.xpath("//div[@class='prod-price Paragraph-24-2XL--Semibold   ']"));
        			String productSp = spMrp.isEmpty() ? "N/A" : spMrp.get(0).getText();
        			row.createCell(2).setCellValue(productSp);
        			System.out.println("Product Mrp: " + productSp);
//					System.out.println("The offer MRP in not available");
				}
               

                // Selling Price
              
                try {
//                	WebElement spEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='prod-price Paragraph-24-2XL--Semibold  ']")));
//                    String sp = spEl.getText();
//                    row.createCell(3).setCellValue(sp);
//                    
                    WebDriverWait waitSp = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        			WebElement spMrp = waitSp.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='prod-price Paragraph-24-2XL--Semibold   ']")));
        			String productSp = spMrp.getText();
        			row.createCell(3).setCellValue(productSp);
        			System.out.println("Product Sell Price: " + productSp);
        			
        			
        			
				} catch (Exception e) {
					WebDriverWait waitSp2 = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        			WebElement spMrp2 = waitSp2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='prod-price Paragraph-24-2XL--Semibold  ']")));
        			String productSp2 = spMrp2.getText();
        			row.createCell(3).setCellValue(productSp2);
        			System.out.println("Product Sell Price: " + productSp2);
				}
//                WebElement spEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='prod-price Paragraph-24-2XL--Semibold   ']//div[@class='prod-price Paragraph-24-2XL--Semibold  ']")));
//                String sp = spEl.getText();
//                row.createCell(3).setCellValue(sp);

                // Offer
                List<WebElement> offerEls = driver.findElements(By.xpath("//span[@class='discount-percent Paragraph-12-XS--Semibold']"));
                String offer = offerEls.isEmpty() ? "N/A" : offerEls.get(0).getText();
                row.createCell(4).setCellValue(offer);
                
                WebElement addToCart = driver.findElement(By.xpath("//button[@title='ADD TO CART']"));
				String availability;
				if(addToCart.isEnabled() && addToCart.isDisplayed()) {
					
					availability = "1";
					row.createCell(5).setCellValue(availability);
					System.out.println(availability);
				}else {
					availability = "0";
					row.createCell(5).setCellValue(availability);
					System.out.println(availability);
				}

            } catch (Exception e) {
                System.out.println("Error processing URL: " + url);
                e.printStackTrace();
            }
        }

        // Save output file
        FileOutputStream out = new FileOutputStream(new File(".\\Output\\IGPOutputChatGpt.xlsx"));
        workbook.write(out);
        out.close();
        workbook.close();
        file.close();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        String timestamp = dateFormat.format(new Date());
//		String outputFilePath = ".\\Output\\IGP_OutputData_" + timestamp + ".xlsx";
//		FileOutputStream outFile = new FileOutputStream(outputFilePath);
//		outputBook.write(outFile);
//        outFile.close();

        driver.quit();
        System.out.println("Scraping complete.");
    }
}
