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

public class OpenApp 
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
		caps.setCapability("app", "/home/pavithra/eclipse-workspace/selenenium/apk/selendroid-test-app-0.12.0.apk");
		caps.setCapability("appWaitDuration",30000);
		caps.setCapability("adbExecTimeout",300000);
		
		RemoteWebDriver driver= new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"),caps);	
		
		Thread.sleep(5000);
	    driver.close();
	}		
}

