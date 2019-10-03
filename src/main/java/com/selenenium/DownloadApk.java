package com.selenenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadApk 
{
	static 
	{
		System.setProperty("webdriver.gecko.driver", "/home/pavithra/Downloads/Pavithra/geckodriver");
		System.setProperty("webdriver.chrome.driver", "//home/pavithra/Downloads/Pavithra/chromedriver");

	}
	static WebDriver driver; // create object of
	private static String downloadPath = System.getProperty("user.dir");

	public static WebDriver ChromeProfile(String downloadPath) {

	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", downloadPath);

	ChromeOptions options = new ChromeOptions();
	HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	options.setExperimentalOption("prefs", chromePrefs);
	options.addArguments("--test-type");
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	cap.setCapability(ChromeOptions.CAPABILITY, options);

	Map<String, Object> deviceMetrics = new HashMap<String, Object>();
	deviceMetrics.put("width", 360);
	deviceMetrics.put("height", 640);
	deviceMetrics.put("pixelRatio", 3.0);
	Map<String, Object> mobileEmulation = new HashMap<String, Object>();
	mobileEmulation.put("deviceMetrics", deviceMetrics);
	mobileEmulation.put("userAgent",
	"Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");

	options.setExperimentalOption("mobileEmulation", mobileEmulation);
	driver = new ChromeDriver(options);

	return driver;

	}

	public static void main(String[] args) throws InterruptedException {

	WebDriver driver = DownloadApk.ChromeProfile(downloadPath);
	System.out.println("Apk Will be downloaded here" + downloadPath);
	driver.get("https://www.howzat.com/assets/lp29.html?utm_source=mbapps2win&utm_medium=CPL&utm_campaign=mbhowzat-apps2win-t20Match-Eng-lp29&utm_content=English-apps2win-howzat-lp29");
	driver.findElement(By.xpath("/html/body/div/div[1]/a/img")).click();

	}
}
