package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

 

public class baseqa {
	
	static ThreadLocal<WebDriver> tdriver;
	
	public static WebDriver init(String browser) {
		
		  tdriver = new ThreadLocal<WebDriver>();
		  
		  if(browser.equals("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  tdriver.set(new ChromeDriver());
			  
		  }else if(browser.equals("firefox")) {
				  WebDriverManager.firefoxdriver().setup();
				  tdriver.set(new FirefoxDriver());
		  }
		
		return getdriver();
	}
	
	  
	  public synchronized static WebDriver getdriver() {
		 return tdriver.get();
	  }
	

}
