package org.mpulse.test;

import org.mpulse.pages.LoginPage;
import org.mpulse.pages.MpulseBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001Login extends MpulseBase {
	@Test(dataProvider = "data")
	public void LoginTest(String[] data ) {
		
//		LoginPage lp = new LoginPage();
//		lp.enterUserName("mnw3368");
//		lp.enterPassword("Dhana@123");
		
		LoginPage lp = new LoginPage(driver);
		boolean loginLabel = lp.getLoginLabel();
		Assert.assertTrue(loginLabel);
		
		new LoginPage(driver).enterUserName(data[0]).enterPassword(data[1]).clickSignIn();
	}

}
