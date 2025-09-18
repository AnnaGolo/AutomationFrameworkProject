package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

        public class ReportManager {
            private static ExtentReports extent;

            public static ExtentReports getInstance() {
                if (extent == null) {

                    String reportPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "ExtentReport.html";

                    ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
                    spark.config().setDocumentTitle("Automation Report");
                    spark.config().setReportName("UI Test Suite");
                    spark.config().setTheme(Theme.STANDARD);

                    extent = new ExtentReports();
                    extent.attachReporter(spark);

                    extent.setSystemInfo("OS", System.getProperty("os.name"));
                    extent.setSystemInfo("Java Version", System.getProperty("java.version"));
                }
                return extent;
            }
        }



