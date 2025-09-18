package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.*;


public class TestListener implements ITestListener, ISuiteListener {

        private ExtentReports extent;

        @Override
        public void onStart(ISuite suite) {
            extent = ReportManager.getInstance();   // build report once per suite
        }

        @Override
        public void onFinish(ISuite suite) {
            if (extent != null) extent.flush();     // write HTML file
        }

        @Override
        public void onTestStart(ITestResult result) {
            String name = result.getMethod().getMethodName();
            String desc = result.getMethod().getDescription() != null ? result.getMethod().getDescription() : "";
            ExtentTest test = extent.createTest(name, desc);

            // auto-tag from @Test(groups=...)
            for (String g : result.getMethod().getGroups()) test.assignCategory(g);

            ExtentManager.ExtentTestManager.set(test);
            test.log(Status.INFO, "Starting: " + name);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            ExtentManager.ExtentTestManager.get().pass("Test passed");
            ExtentManager.ExtentTestManager.remove();
        }

        @Override
        public void onTestFailure(ITestResult result) {
            ExtentTest t = ExtentManager.ExtentTestManager.get();
            t.fail(result.getThrowable());

            // Optional: if your BaseTest implements the below interface, attach a screenshot
            Object instance = result.getInstance();
            if (instance instanceof TakesScreenshotProvider) {
                try {
                    String path = ((TakesScreenshotProvider) instance)
                            .takeScreenshot(result.getMethod().getMethodName());
                    if (path != null) t.addScreenCaptureFromPath(path);
                } catch (Exception ignored) {}
            }
            ExtentManager.ExtentTestManager.remove();
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            ExtentManager.ExtentTestManager.get().skip("Skipped: " + result.getSkipCausedBy().remove(null));
            ExtentManager.ExtentTestManager.remove();
        }

        // Not used
        @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
        @Override public void onTestFailedWithTimeout(ITestResult result) { onTestFailure(result); }
        @Override public void onStart(ITestContext context) {}
        @Override public void onFinish(ITestContext context) {}

        /** Your BaseTest can implement this so the listener can request screenshots. */
        public interface TakesScreenshotProvider {
            String takeScreenshot(String name);
        }
    }

