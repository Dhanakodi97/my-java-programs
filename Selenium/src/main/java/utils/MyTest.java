 package utils;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTest extends Reports {
	@BeforeTest
	void setData() {
		desc = "My First Test";
		author = "Dhanakodi";
		category = "Admin";
	}
	
	@Test
	void myTest() {
		System.out.println("Test Begins");
		
		stepReport("pass", "Some Description");
		System.out.println("Test Ends");
	}

}
