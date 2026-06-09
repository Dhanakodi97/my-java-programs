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

public class AmazonFilterChatGpt2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("earphones");
        driver.findElement(By.id("nav-search-submit-button")).click();
        
        // Create Workbook and Sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Earphone Filters");

        // Create Header Row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Final Keyword for Search");
        headerRow.createCell(1).setCellValue("Attribute");
        headerRow.createCell(2).setCellValue("Value");
        
        int rowNum = 1;

        // Find all Filter Sections
        List<WebElement> filterSections = driver.findElements(By.xpath("//div[@id='s-refinements']//div[@class='a-section a-spacing-none']"));
        
        for (WebElement section : filterSections) {
            try {
                // Get Filter Category Name
                WebElement titleElement = section.findElement(By.xpath(".//span[@class='a-size-base a-color-base puis-bold-weight-text']"));
                String filterName = titleElement.getText().trim();

                if (!filterName.isEmpty()) {
                    
                    // Check and Click See More if available
                    List<WebElement> seeMoreLinks = section.findElements(By.xpath(".//span[@class='a-expander-prompt']"));
                    if (!seeMoreLinks.isEmpty()) {
                        seeMoreLinks.get(0).click();
                        Thread.sleep(1000); // wait for 1 second after clicking
                    }
                    
                    // Now find all Filter Options again
                    List<WebElement> options = section.findElements(By.xpath(".//span[@class='a-size-base a-color-base']"));
                    
                    for (WebElement option : options) {
                        String optionName = option.getText().trim();
                        if (!optionName.isEmpty() && !optionName.equals(filterName)) {
                            // Create New Row
                            Row row = sheet.createRow(rowNum++);
                            row.createCell(0).setCellValue("Earphones");
                            row.createCell(1).setCellValue(filterName);
                            row.createCell(2).setCellValue(optionName);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Skipped one section due to: " + e.getMessage());
                continue;
            }
        }
        
        // Write to Excel
        File file = new File(".\\Output\\Amazon_Earphone_Filters2.xlsx");
        file.getParentFile().mkdirs(); // create Output folder if not exists
        FileOutputStream fileOut = new FileOutputStream(file);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        
        System.out.println("✅ Excel file created successfully with filters and values!");
        driver.quit();
    }
}
