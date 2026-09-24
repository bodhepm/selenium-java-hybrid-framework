package com.pratik.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pratik.framework.base.BaseTest;
import com.pratik.framework.pages.LoginPage;
import com.pratik.framework.pages.ProductsPage;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.pratik.framework.utilities.excel.ExcelUtils;

public class LoginDataDrivenTest extends BaseTest {

	@DataProvider(name = "loginData")
	public Object[][] getLoginData() throws IOException {

	    String filePath = "testdata/LoginData.xlsx";

	    Workbook workbook = ExcelUtils.getWorkbook(filePath);

	    Sheet sheet = ExcelUtils.getSheet(workbook, "LoginData");

	    int rowCount = ExcelUtils.getRowCount(sheet);

	    Object[][] data = new Object[rowCount - 1][2];

	    for (int i = 1; i < rowCount; i++) {

	        data[i - 1][0] =
	                ExcelUtils.getCellValue(sheet, i, 0);

	        data[i - 1][1] =
	                ExcelUtils.getCellValue(sheet, i, 1);
	    }

	    workbook.close();

	    return data;
	}

    @Test(dataProvider = "loginData",groups = "smoke")
    public void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        
        ProductsPage productsPage = new ProductsPage(getDriver());
        
        Assert.assertEquals(productsPage.getProductsTitle(), "Products");
        
    
    }
}