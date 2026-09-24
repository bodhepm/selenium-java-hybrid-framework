package com.pratik.framework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pratik.framework.driver.DriverFactory;
import com.pratik.framework.driver.DriverManager;
import com.pratik.framework.utilities.ConfigReader;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        ConfigReader.loadProperties();

        DriverFactory.createDriver(
                ConfigReader.getProperty("browser"));

        DriverManager.getDriver().manage().window().maximize();

        DriverManager.getDriver().get(
                ConfigReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}