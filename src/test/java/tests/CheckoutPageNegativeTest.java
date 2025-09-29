package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckoutPageNegative;
import pages.SauceLoginPage;

public class CheckoutPageNegativeTest {
    private CheckoutPageNegative checkoutPageNegative;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BasePage.createChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage login = new SauceLoginPage(driver);
        login.login("standard_user", "secret_sauce");
        checkoutPageNegative = new CheckoutPageNegative(driver);
    }
    @Test
    public void noFirstNameTest() {
        checkoutPageNegative.openCheckoutPageFromCartNeg();
        checkoutPageNegative.addLastNameNeg("g");
        checkoutPageNegative.addZipCodeNeg("76894");
        checkoutPageNegative.clickContinueButton();
        WebElement error = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]"));
        Assert.assertTrue(error.isDisplayed());
    }
    @Test
    public void noLastNameTest() {
        checkoutPageNegative.openCheckoutPageFromCartNeg();
        checkoutPageNegative.addFirstNameNeg("");
        checkoutPageNegative.addZipCodeNeg("76894");
        checkoutPageNegative.clickContinueButton();
        WebElement error = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]"));
        Assert.assertTrue(error.isDisplayed());
    }
    @Test
    public void noZipCodeTest() {
        checkoutPageNegative.openCheckoutPageFromCartNeg();
        checkoutPageNegative.addFirstNameNeg("");
        checkoutPageNegative.clickContinueButton();
        WebElement error = driver.findElement(By.xpath("//div[@class=\"error-message-container error\"]"));
        Assert.assertTrue(error.isDisplayed());
    }
    @Test
    public void closeErrorMessageTest() {
        checkoutPageNegative.openCheckoutPageFromCartNeg();
        checkoutPageNegative.addFirstNameNeg("Anna");
        checkoutPageNegative.addZipCodeNeg("76894");
        checkoutPageNegative.clickContinueButton();
        checkoutPageNegative.closeErrorMessage();
    }
    @AfterMethod
    public void tearD() {
        if (driver != null)
            driver.quit();
    }
}

