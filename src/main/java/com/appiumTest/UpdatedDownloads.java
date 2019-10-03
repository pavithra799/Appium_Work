package com.appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class UpdatedDownloads 
{
	 static AppiumDriver<MobileElement> driver;

	    @BeforeClass
	    public void setUp() throws MalformedURLException {
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("udid", "J8AAGF075449GVP"); //Give Device ID of your mobile phone
			caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
			caps.setCapability("app", "/home/pavithra/eclipse-workspace/selenenium/apk/selendroid-test-app-0.12.0.apk");
			caps.setCapability("appWaitDuration",30000);
			caps.setCapability("adbExecTimeout",300000);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
	        // System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
	        // capabilities.setCapability("appPackage", "com.android.chrome");
	        // capabilities.setCapability("appActivity",
	        // "com.google.android.apps.chrome.Main");
	        URL url = new URL("http://127.0.0.1:4723/wd/hub");

	        driver = new AppiumDriver<MobileElement>(url, caps);
	    }

	    public boolean isElementPresent(By locator) {
	        MobileElement newEle = findByWait(locator);
	        if (newEle == null)
	            return false;
	        else
	            return true;
	    }

	    public MobileElement findByWait(By locatn) {
	        MobileElement ele = null;
	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	        try {
//	            WebDriverWait wait = new WebDriverWait(driver, 60);
//	            wait.until(ExpectedConditions.presenceOfElementLocated(locatn));
	            ele = driver.findElement(locatn);
//	            Log.info("found element " + ele);
	        } catch (Exception e) {
//	            Log.info("not able to find element : " + e.getMessage());
	        }
	        return ele;
	    }

	    @Test
	    public void testCal() throws Exception {
	        driver.get("https://www.howzat.com");
	        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div/a")).click();
			Thread.sleep(5000);
	        driver.context("NATIVE_APP");
	        if (isElementPresent(By.id("android:id/button1"))) {
	            driver.findElement(By.id("android:id/button1")).click();
	            driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	        } else if (isElementPresent(By.id("com.android.chrome:id/positive_button"))) {

	            driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
	            // driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();

	        }

	        driver.findElement(By.id("com.android.chrome:id/button_primary")).click();
	    }

	    @AfterClass
	    public void teardown() {
	        // close the app
	        driver.quit();
	    }
}
