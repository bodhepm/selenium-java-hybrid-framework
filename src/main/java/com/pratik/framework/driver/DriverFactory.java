package com.pratik.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	public static WebDriver createDriver(String browser){
		
		WebDriver driver;
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		else {
			
			throw new IllegalArgumentException("Browser not supported: "+browser);
		}
		
		DriverManager.setDriver(driver);
		
		return driver;
		
	}

}
