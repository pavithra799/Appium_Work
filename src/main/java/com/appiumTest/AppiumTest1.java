package com.appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTest1 
{
	
	static 
	{
		System.setProperty("webdriver.gecko.driver", "/home/pavithra/Downloads/Pavithra/geckodriver");
		System.setProperty("webdriver.chrome.driver", "//home/pavithra/Downloads/Pavithra/chromedriver");

	}
	@SuppressWarnings("rawtypes")
	AndroidDriver driver;
	
	@SuppressWarnings("rawtypes")
	@BeforeClass
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("udid", "J8AAGF075449GVP"); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		//caps.setCapability("app", "/home/pavithra/Downloads/APK Files/IndiaMART.apk");
		 caps.setCapability("appWaitDuration",30000);
		 caps.setCapability("adbExecTimeout",300000);
		 
		 caps.setCapability("autoDismissAlerts", true);
		 caps.setCapability("autoGrantPermissions", true);		 
		 caps.setCapability("autoAcceptAlerts", true);
		 
		 ChromeOptions options = new ChromeOptions();
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 prefs.put("profile.default_content_settings.popups", 0);
		 options.setExperimentalOption("prefs", prefs);
		 
		 /* caps.setCapability("appWaitActivity",
		 * "SplashActivity, SplashActivity,OtherActivity, *, *.SplashActivity");
		 * 
		 * AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new
		 * URL("http://localhost:4723/wd/hub"), caps);
		 */
		
		RemoteWebDriver driver= new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"),caps);
		driver.get("https://www.howzat.com/assets/lp10.html");
		
		driver.findElement(By.xpath("/html/body/div/div[4]/a/img")).click();
		
		/*WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();*/
		
		Thread.sleep(5000);
	    driver.close();
	}		
}





















/*
 * @Test public void testDownload() throws InterruptedException { WebDriver
 * driver=new ChromeDriver();
 * driver.get("https://www.howzat.com/assets/lp10.html"); //Scroll down
 * JavascriptExecutor js = (JavascriptExecutor) driver; Thread.sleep(1000);
 * js.executeScript("window.scrollBy(0,2000)");
 * 
 * driver.findElement(By.xpath("/html/body/div/div[4]/a/img")).click();
 * driver.findElement(By.xpath(
 * "/html/body/ion-app/ng-component/ion-nav/page-login/ion-header/ion-toolbar/div[2]/ion-row/img"
 * )).click(); driver.findElement(By.xpath(
 * "/html/body/ion-app/ng-component/ion-nav/page-login/ion-header/ion-toolbar/div[2]/ion-row/img"
 * )).click();
 * 
 * }
 */
