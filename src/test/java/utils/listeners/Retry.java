package utils.listeners;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static base.TestBase.driver;
import static utils.extentReports.ExtentTestManager.getTest;

public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                extendedReportFailOperations(iTestResult);
                return true;
            }
        }
        return false;
    }

    public void extendedReportFailOperations(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        String failureScreenShot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.SKIP, "Test failed",
                getTest().addScreenCaptureFromBase64String(failureScreenShot).getModel().getMedia().get(0));
    }
}
