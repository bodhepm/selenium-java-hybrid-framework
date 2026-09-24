package com.pratik.tests;

import org.testng.annotations.Test;
import com.pratik.framework.base.BaseTest;
import com.pratik.framework.pages.LoginPage;
import com.pratik.framework.pages.ProductsPage;
import org.testng.Assert;
import com.pratik.framework.retry.RetryAnalyzer;

public class LoginTest extends BaseTest{
	
	@Test(groups="smoke", retryAnalyzer = RetryAnalyzer.class)
	public void validLoginTest()  {

	    LoginPage loginPage = new LoginPage(getDriver());

	    loginPage.enterUsername("standard_user");
	    

	    loginPage.enterPassword("secret_sauce");
	  

	    loginPage.clickLogin();
	    
	
		
		ProductsPage productsPage = new ProductsPage(getDriver());
		
		Assert.assertEquals(productsPage.getProductsTitle(),"Products");
	
		productsPage.addBackpackToCart();
		
		Assert.assertEquals(productsPage.getCartItemCount(), "1");
		

	}
	
	

}
