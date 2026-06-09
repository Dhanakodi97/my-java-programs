package com.lao.appium.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {
	
	//AppiumDriver
	//protected static AndroidDriver driver;
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("PlatformVersion", "15.0	");
//		capabilities.setCapability("udid", "voovsc65y5cyjzey");
//		capabilities.setCapability("deviceName", "Redmi Note 13 5G");
//		capabilities.setCapability("appPackage", "com.miui.calculator");
//		capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
		capabilities.setCapability(MobileCapabilityType.UDID, "voovsc65y5cyjzey");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 13 5G");
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.miui.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.miui.calculator.cal.CalculatorActivity");
		
		
		
		//URL url = new URL("http://127.0.0.1:4723");
		
		//driver = new AndroidDriver(url, capabilities);	
		
		URL url = new URL("http://127.0.0.1:4723");  // ✅ No /wd/hub for Appium 2.x
		driver = new AndroidDriver(url, capabilities);

		System.out.println("The Application is Started ..............");
		

	}

}
