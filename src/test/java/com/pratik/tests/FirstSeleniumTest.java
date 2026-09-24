package com.pratik.tests;

import org.testng.annotations.Test;

import com.pratik.framework.base.BaseTest;

public class FirstSeleniumTest extends BaseTest{
	
	@Test
	public void openApplication() {
		
		
		System.out.println("Page Title: "+getDriver().getTitle());
		
	}

}
