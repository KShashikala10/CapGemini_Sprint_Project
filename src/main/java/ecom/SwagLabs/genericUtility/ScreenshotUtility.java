package ecom.SwagLabs.genericUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

    public void takeScreenshot(
            WebDriver driver, String testName) throws IOException {

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        // Include milliseconds to avoid filename collisions
        String time = new SimpleDateFormat(
                "yyyyMMdd_HHmmss_SSS").format(new Date());

        File destination = new File(
                "./Screenshots/" + testName + "_" + time + ".png");

        // Create the Screenshots folder if it does not exist
        destination.getParentFile().mkdirs();

        FileHandler.copy(source, destination);

        System.out.println(
                "Screenshot saved: "
                + destination.getAbsolutePath());
    }
}
