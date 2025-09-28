package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class CheckoutPageTest {
    private CheckoutPage checkoutPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BasePage.createChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage login = new SauceLoginPage(driver);
        login.login("standard_user", "secret_sauce");
        checkoutPage = new CheckoutPage(driver);
    }
    @Test
    public void checkoutTitleText() {
        checkoutPage.openCheckoutPageFromCart();
        Assert.assertEquals(checkoutPage.checkoutTitleText(), "Checkout: Your Information");
    }
    @Test
    public void fillOutForm() throws InterruptedException {
        checkoutPage.openCheckoutPageFromCart();
        checkoutPage.addFirstName("Anna");
        checkoutPage.addLastName("G");
        checkoutPage.addZipCode("56748");
        checkoutPage.clickContinueButton();
    }
    @AfterMethod
    public void tearD() {
        if (driver != null)
            driver.quit();
    }
}
