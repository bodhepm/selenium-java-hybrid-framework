package com.pratik.framework.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pratik.framework.base.BaseTest;
import com.pratik.framework.utilities.ExtentReportManager;
import com.pratik.framework.utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ExtentReportManager.getReportInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest baseTest =
                (BaseTest) result.getInstance();

        WebDriver driver =
                baseTest.getDriver();

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        driver, result.getName());

        test.get().fail(result.getThrowable());

        if (screenshotPath != null) {
            test.get().addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }
    
    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}