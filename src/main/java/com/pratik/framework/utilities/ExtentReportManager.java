package com.pratik.framework.utilities;

import com.pratik.framework.utilities.ConfigReader;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
    	
    	ConfigReader.loadProperties();

        if (extent == null) {
        	

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            
            extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
            extent.setSystemInfo("Environment",
                    ConfigReader.getProperty("env"));
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }

        return extent;
    }
}