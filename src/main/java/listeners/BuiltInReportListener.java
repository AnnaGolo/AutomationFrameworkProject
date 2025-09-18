package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BuiltInReportListener implements ITestListener, IReporter {

    private void attachScreenshot(ITestResult result, WebDriver driver) {
        if (!(driver instanceof TakesScreenshot ts)) return;

        try {
            byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
            Path dir = Paths.get("target", "screenshots");
            Files.createDirectories(dir);
            String stamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
            String fileName = result.getMethod().getMethodName() + "_" + stamp + ".png";
            Path file = dir.resolve(fileName);
            Files.write(file, bytes);

            String abs = file.toAbsolutePath().toString().replace("\\", "/");
            Reporter.log("<br><b>Screenshot:</b> <a href='file://" + abs + "'>open</a><br>");
            Reporter.log("<img src='file://" + abs + "' height='300'/>");
        } catch (IOException ignored) { }
    }

    private WebDriver resolveDriver(ITestResult result) {
        Object test = result.getInstance();

        for (Class<?> c = test.getClass(); c != null; c = c.getSuperclass()) {
            try {
                var f = c.getDeclaredField("driver");
                f.setAccessible(true);
                Object v = f.get(test);
                if (v instanceof WebDriver) return (WebDriver) v;
            } catch (NoSuchFieldException ignored) {
            } catch (Exception e) { break; }
        }
        for (Class<?> c = test.getClass(); c != null; c = c.getSuperclass()) {
            try {
                var m = c.getDeclaredMethod("getDriver");
                m.setAccessible(true);
                Object v = m.invoke(test);
                if (v instanceof WebDriver) return (WebDriver) v;
            } catch (NoSuchMethodException ignored) {
            } catch (Exception e) { break; }
        }
        return null;
    }
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = resolveDriver(result);
        if (driver != null) {
            attachScreenshot(result, driver);
        } else {
            Reporter.log("No WebDriver found for screenshot");
        }
    }
}
