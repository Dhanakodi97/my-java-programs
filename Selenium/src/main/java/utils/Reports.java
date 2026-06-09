package utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	ExtentReports extent;
	ExtentTest test;
	String desc = "";
	String author = "";
	String category = "";
	
	@BeforeSuite
	protected void startReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	@AfterTest
	protected void endReport() {
		extent.flush();
	}
	@BeforeClass
	void createTest() {
		test = extent.createTest(desc);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	void stepReport(String status, String description) {
		switch (status.toLowerCase()) {
		case "pass":
			test.pass(description);
			break;
		case "fail":
			test.fail(description);
			break;
		case "info":
			test.info(description);
			break;	
		case "warning":
			test.warning(description);
			break;	

		default:
			System.err.println("The status is undefined");
			break;
		}
	}


}
