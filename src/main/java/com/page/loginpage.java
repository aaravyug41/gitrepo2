package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
 

public class loginpage {
	
	WebDriver driver;
	
	By Username = By.xpath("//username");
	By Password = By.xpath("//username");
	By button = By.xpath("//username");

	public loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void login() {
		driver.get("https://www.google.com");
		System.out.println("login successful");
	}

	public void verifytitle() {
		System.out.println("title verified");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "login");
		
	}

}
