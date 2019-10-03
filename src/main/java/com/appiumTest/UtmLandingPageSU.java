package com.appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UtmLandingPageSU 
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
		driver.get("https://www.howzat.com/assets/lp29.html?utm_source=mbapps2win&utm_medium=CPL&utm_campaign=mbhowzat-apps2win-t20Match-Eng-lp29&utm_content=English-apps2win-howzat-lp29");
		
		driver.findElement(By.xpath("/html/body/div/div[1]/a/img")).click();
		
		Thread.sleep(1000);
        //driver.close();
	}	
}
