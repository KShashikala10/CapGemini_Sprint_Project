package ecom.SwagLabs.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ecom.SwagLabs.baseClass.BaseClass;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        captureNegativeScreenshot(result, "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureNegativeScreenshot(result, "FAIL");
    }

    private void captureNegativeScreenshot(
            ITestResult result, String status) {

        // Check whether this is a negative test case
        boolean isNegative = false;


        // Check the test groups
        for (String group : result.getMethod().getGroups()) {

            if (group.equalsIgnoreCase("Nev")
                    || group.equalsIgnoreCase("Negative")) {

                isNegative = true;
                break;
            }
        }

        // Do not capture screenshots for other tests
        if (!isNegative) {
            //System.out.println(
                  //  "Screenshot skipped: Not a negative test.");
            return;
        }

        System.out.println("Negative test detected. Capturing screenshot...");

        // Get the WebDriver from BaseClass
        Object testClass = result.getInstance();

        if (testClass instanceof BaseClass) {

            WebDriver driver =
                    ((BaseClass) testClass).driver;

            if (driver != null) {
                try {
                    ScreenshotUtility su =
                            new ScreenshotUtility();

                    String screenshotName =
                            result.getMethod().getMethodName()
                            + "_" + status;

                    su.takeScreenshot(
                            driver, screenshotName);

                } catch (Exception e) {
                    System.out.println(
                            "Unable to capture negative test screenshot.");

                    e.printStackTrace();
                }
            } else {
                System.out.println(
                        "Screenshot skipped: WebDriver is null.");
            }

        } else {
            System.out.println(
                    "Screenshot skipped: Test class does not extend BaseClass.");
        }
    }
}
