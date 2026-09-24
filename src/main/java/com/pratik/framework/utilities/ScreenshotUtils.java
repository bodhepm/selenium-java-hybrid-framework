package com.pratik.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String folderPath = "screenshots";
        String filePath = folderPath + "/" + testName + "_" + System.currentTimeMillis() + ".png";

        try {
            Files.createDirectories(Paths.get(folderPath));

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path destination = Paths.get(filePath);

            Files.copy(source.toPath(), destination);

            return destination.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}