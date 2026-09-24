package com.pratik.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.pratik.framework.utilities.WaitUtils;

public class ProductsPage {
	
	private WebDriver driver;
	private WaitUtils waitUtils;
	
	//locators
	private By productsTitle = By.className("title");
	private By backpack = By.id("add-to-cart-sauce-labs-backpack");
	private By cartBadge = By.className("shopping_cart_badge");
	
	//constructor
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		this.waitUtils = new WaitUtils(driver);
	}

	//actions
	public String getProductsTitle() {
		
		return waitUtils.waitForElementVisible(productsTitle).getText();
	}
	
	public void addBackpackToCart() {
		waitUtils.waitForElementClickable(backpack).click();
	}
	
	public String getCartItemCount() {
		return waitUtils.waitForElementVisible(cartBadge).getText();
	}
}
