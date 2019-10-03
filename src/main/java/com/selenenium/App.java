package com.selenenium;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

@SuppressWarnings("unused")
public class App {
	static 
	{
		System.setProperty("webdriver.gecko.driver", "/home/pavithra/Downloads/Pavithra/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/home/pavithra/Downloads/Pavithra/chromedriver");

	}
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriver driver = new FirefoxDriver();
		
		//get web page provided
		driver.get("https://www.howzat.com/assets/lp10.html");
        
		//Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,2000)");
        
		driver.findElement(By.xpath("/html/body/div/div[4]/a/img")).click();
		driver.findElement(By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-header/ion-toolbar/div[2]/ion-row/img")).click();
		driver.findElement(By.xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-header/ion-toolbar/div[2]/ion-row/img")).click();
		
		Thread.sleep(1000);
	    driver.close();
	}
}
