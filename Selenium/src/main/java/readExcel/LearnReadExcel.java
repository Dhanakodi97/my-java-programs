package readExcel;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LearnReadExcel {

	public static void main(String[] args) throws IOException {
		//Automatically using no. of rows and colums
		String fileLocation = "./test-data/read-Excel.xlsx";
		XSSFWorkbook wbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		//This is the without header file, because apache-poi using this method
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("The last Row number is : " + lastRowNum);
		//This is the With header file, This is phycally how much rows is there of that excel
		int physicalNumRow = sheet.getPhysicalNumberOfRows();
		System.out.println("The Physically last row : "+physicalNumRow);
		//Now find number of columns or cell value
		//Cell value not find straight, its find row to cell value
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("The last cell number is ; "+lastCellNum);
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				//String value = cell.getStringCellValue();
				System.out.println(value);
			}
		}
		
		
		//We manually using no.of rows and column value
//		String fileLocation = "./test-data/read-Excel.xlsx";
//		XSSFWorkbook wbook = new XSSFWorkbook(fileLocation);
//		XSSFSheet sheet = wbook.getSheetAt(0);
//		for (int i = 1; i <=37; i++) {
//			XSSFRow row = sheet.getRow(i);
//			for (int j = 0; j < 2; j++) {
//				XSSFCell cell = row.getCell(j);
//				String value = cell.getStringCellValue();
//				System.out.println(value);
//			}
//		}
	}
}
