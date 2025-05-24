package maven_diares.MAven_single;

import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
    	ScreenshotUtility ScreenshotUtility = new ScreenshotUtility();
        ExtentTest test = (ExtentTest) result.getAttribute("test");
        String screenshotPath = maven_diares.MAven_single.ScreenshotUtility.captureScreenshot(
			BaseTest.getDriver(), result.getName());
        test.fail(result.getThrowable());
        test.addScreenCaptureFromPath(screenshotPath);
    }

	
}