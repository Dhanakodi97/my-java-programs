package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationReport {

	public static void main(String[] args) {
		// blank html
		ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
		// report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		//extent.cre
		ExtentTest test = extent.createTest("TC001 - BioData1");
		test.assignAuthor("Dhanakodi");
		test.assignCategory("Admin");
		test.pass("Enter the name");
		test.pass("Enter the Age");
		test.pass("Enter the Sex");
		ExtentTest test2 = extent.createTest("TC002 - BioData2");
		test2.pass("Enter the name");
		test2.pass("Enter the Age");
		test2.pass("Enter the Sex");
		test2.fail("The person is Criminal");
		
		
		extent.flush();
		

	}

}
