package com.lao.appium.android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {

    public static AndroidDriver driver;

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
        capabilities.setCapability(MobileCapabilityType.UDID, "voovsc65y5cyjzey");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 13 5G");

        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.miui.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.miui.calculator.cal.CalculatorActivity");

        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        @SuppressWarnings("deprecation")
		URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, capabilities);

        System.out.println("✅ Calculator app launched successfully!");

        // Perform 2 + 3 = 
        driver.findElement(By.id("com.miui.calculator:id/btn_2")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_plus")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_3")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_equal")).click();

        // Get and print result
        String result = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
        System.out.println("Calculation Result: " + result);

        // Close the driver
        driver.quit();
    }
}
