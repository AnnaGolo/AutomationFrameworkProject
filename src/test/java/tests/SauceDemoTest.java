package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SauceLoginPage;

public class SauceDemoTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearD() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void loginThePage(){
            new SauceLoginPage(driver)
                    .open()
                    .login("standard_user","secret_sauce");
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        }
    }

