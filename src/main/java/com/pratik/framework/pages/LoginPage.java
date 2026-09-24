package com.pratik.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.pratik.framework.utilities.WaitUtils;

public class LoginPage {
	
	private WebDriver driver;
	private WaitUtils waitUtils;
	
	//locators
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	//constructor
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		this.waitUtils = new WaitUtils(driver);
	}

	//actions
	public void enterUsername(String usernameValue) {
		waitUtils.waitForElementVisible(username).sendKeys(usernameValue);
	}
	
	public void enterPassword(String passwordValue) {
		waitUtils.waitForElementVisible(password).sendKeys(passwordValue);
	}
	
	public void clickLogin() {
		waitUtils.waitForElementClickable(loginButton).click();
	}
	
	
}
