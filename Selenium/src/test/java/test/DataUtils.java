package test;

import org.testng.annotations.DataProvider;

import readExcel.DataProvInteg;

public class DataUtils {
	@DataProvider(name="login")
	public String[][] getData() {
		String[][] excelData = DataProvInteg.getExcelData();
//		String[][] data = new String[2][2];
//		data[0][0]="mnw3368";
//		data[0][1]="Dhana@123";
//		
//		data[1][0]="mnw3037";
//		data[1][1]="Raghs#123";
		return excelData;
	}
}
