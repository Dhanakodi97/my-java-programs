package igpWebScrapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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

public class IGP2 {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//	Read Data from Excel file
		File file = new File("./Input/IGP.xlsx");
		FileInputStream fis = new FileInputStream(file);

		Workbook book = new XSSFWorkbook(fis);
		Sheet inputSheet = book.getSheet("Sheet1");		
		int rowCount = inputSheet.getPhysicalNumberOfRows();  // Read upto n no. of rows 

		//	Store the input data as list which have more data
		List<String> inputPid = new ArrayList<>(), inputCity = new ArrayList<>(), inputName = new ArrayList<>(), inputSize = new ArrayList<>(), 
				productCode = new ArrayList<>(), url = new ArrayList<>(), uom = new ArrayList<>(), multiplier = new ArrayList<>();
		
		//	Create excel for storing output data
		
		Workbook outputBook =  new XSSFWorkbook();
		Sheet outputSheet = outputBook.createSheet("Output Data") ;

		Row createHeader = outputSheet.createRow(0);

		createHeader.createCell(0).setCellValue("Input Pid");
		createHeader.createCell(1).setCellValue("Input City");
		createHeader.createCell(2).setCellValue("Input Name");
		createHeader.createCell(3).setCellValue("Input Size");
		createHeader.createCell(4).setCellValue("Product code");
		createHeader.createCell(5).setCellValue("Product URL");
		createHeader.createCell(6).setCellValue("Product name");
		createHeader.createCell(7).setCellValue("MRP");
		createHeader.createCell(8).setCellValue("SP");
		createHeader.createCell(9).setCellValue("UOM");
		createHeader.createCell(10).setCellValue("Multiplier");
		createHeader.createCell(11).setCellValue("Availability");
		createHeader.createCell(12).setCellValue("Offer");

		/*
			driver.get("https://igp.com");
			try {
				WebElement pincode = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[contains(text(),'Where to deliver')]"))));
				pincode.click();
				Thread.sleep(1000);
				WebElement pincodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Pincode / Location')]")));
				pincodeInput.sendKeys("122018");
				WebElement clickButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Apply']")));
				clickButton.click();
				System.out.println("Pincode set in 1st attempt");
			}catch (Exception e) {
				WebElement setPincode = driver.findElement(By.xpath("//input[@placeholder='Pincode/Location']"));
				setPincode.sendKeys("122018");
				System.out.println("Pincode set in 2nd attempt");
			}
			*/
		
			int outputRowNum = 1;	
		
		for (int i = 0; i < rowCount; i++) {
			Row row = inputSheet.getRow(i);

			if(i == 0 || row == null) {
				continue;
			}

			String pid = getCellValue(row.getCell(0));
			String city = getCellValue(row.getCell(1));
			String name = getCellValue(row.getCell(2));
			String size = getCellValue(row.getCell(3));
			String code = getCellValue(row.getCell(4));
			String url1 = getCellValue(row.getCell(5));
			String uom1 = getCellValue(row.getCell(6));
			String multiplier1 = getCellValue(row.getCell(7));
			
			inputPid.add(pid);
			inputCity.add(city);
			inputName.add(name);
			inputSize.add(size);
			productCode.add(code);
			url.add(url1);
			uom.add(uom1);
			multiplier.add(multiplier1);
			
			if (url1 == null || url1.isEmpty() || url1.equalsIgnoreCase("NA")) {
				System.out.println("Failed: No URL for product ID: " + pid);
				
			    Row outputRow = outputSheet.createRow(outputRowNum++);
			    outputRow.createCell(0).setCellValue(pid);
			    outputRow.createCell(1).setCellValue(city);
			    outputRow.createCell(2).setCellValue(name);
			    outputRow.createCell(3).setCellValue(size);
			    outputRow.createCell(4).setCellValue(code);
			    outputRow.createCell(5).setCellValue(url1 == null ? "NA" : url1);
			    outputRow.createCell(6).setCellValue("NA"); // product name
			    outputRow.createCell(7).setCellValue("NA"); // mrp
			    outputRow.createCell(8).setCellValue("NA"); // sp
			    outputRow.createCell(9).setCellValue(uom1 == null || uom1.isEmpty() ? "NA" : uom1); // uom
			    outputRow.createCell(10).setCellValue(multiplier1 == null || multiplier1.isEmpty() ? "NA" : multiplier1); // multiplier
			    outputRow.createCell(11).setCellValue("NA"); // availability
			    outputRow.createCell(12).setCellValue("NA"); // offer
			    continue;
			}

			try {
				driver.get(url1);				
				System.out.println("Processing Data extraction for :"+ url1);
				
				WebElement pincode = driver.findElement(By.xpath("//input[@placeholder='Pincode/Location']"));
				pincode.clear();
				pincode.sendKeys("122018");
			
				WebElement productName = driver.findElement(By.xpath("//h1[@itemprop='name']"));
				String nameText = productName.getText();
				System.out.println(nameText);
				
				
				String mrpText = "NA";
				String spText = "NA";
				String offerText = "NA";
				String availability = "NA";
				// mrp
				try {					
					WebElement mrp = driver.findElement(By.xpath("//div[contains(@class,'prod-price-container')]//span[contains(@class,'striked-price Paragraph-16-M--Regular strikethrough')]"));
					 mrpText = mrp.getText().replace("₹", "").trim();
					System.out.println(mrpText);
				
				}
				catch (Exception e) {
					WebElement mrp = driver.findElement(By.xpath("//div[contains(@class,'prod-price-container')]//div[contains(@class,'prod-price Paragraph-24-2XL--Semibold')]"));
					 mrpText = mrp.getText().replace("₹", "").trim();
					System.out.println(mrpText);
				}
				
				//sp
				try {
					WebElement sp = driver.findElement(By.xpath("//div[contains(@class,'prod-price-container')]//div[contains(@class,'prod-price Paragraph-24-2XL--Semibold')]"));
					 spText = sp.getText().replace("₹", "").trim();
					System.out.println(spText);
					}
					catch (Exception e) {
						WebElement sp = driver.findElement(By.xpath("//div[contains(@class,'prod-price-container')]//span[contains(@class,'striked-price Paragraph-16-M--Regular strikethrough')]"));
						 spText = sp.getText().replace("₹", "").trim();
						System.out.println(spText);
					}
				
				// availability
				WebElement addToCart = driver.findElement(By.xpath("//button[@title='ADD TO CART']"));
				if(addToCart.isEnabled() && addToCart.isDisplayed()) {
					availability = "1";
					System.out.println(availability);
				}else {
					availability = "0";
					System.out.println(availability);
				}
				
				// offer
					try {
					WebElement offer = driver.findElement(By.xpath("//div[contains(@class,'discount-container-blue')]//span"));
					 offerText = offer.getText();
					System.out.println(offerText);
					}
					catch (Exception e) {
						System.out.println("NA");
					}
			
							
			Row outputRow = outputSheet.createRow(outputRowNum++);
		    outputRow.createCell(0).setCellValue(pid);
		    outputRow.createCell(1).setCellValue(city);
		    outputRow.createCell(2).setCellValue(name);
		    outputRow.createCell(3).setCellValue(size);
		    outputRow.createCell(4).setCellValue(code);
		    outputRow.createCell(5).setCellValue(url1);
		    outputRow.createCell(6).setCellValue(nameText);
		    outputRow.createCell(7).setCellValue(mrpText);
		    outputRow.createCell(8).setCellValue(spText);
		    outputRow.createCell(9).setCellValue(uom1);
		    outputRow.createCell(10).setCellValue(multiplier1);
		    outputRow.createCell(11).setCellValue(availability);
		    outputRow.createCell(12).setCellValue(offerText);
			}
			catch (Exception e) {
				System.out.println("Failed to fetch product details for product ID: " + pid);
			}
			
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
		String outputFilePath = ".\\Output\\IGP_OutputData_" + timestamp + ".xlsx";
		FileOutputStream outFile = new FileOutputStream(outputFilePath);
		outputBook.write(outFile);
        outFile.close();
		
        driver.quit();
	}
	
	
		public static String getCellValue(Cell cell) {
			if (cell == null) return "";
			if (cell.getCellType() == CellType.STRING) return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC) return String.valueOf(cell.getNumericCellValue());
			return "";
		}

}
