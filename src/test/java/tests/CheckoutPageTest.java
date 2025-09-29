package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

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
    public void fillOutForm()  {
        checkoutPage.openCheckoutPageFromCart();
        checkoutPage.addFirstName("Anna");
        checkoutPage.addLastName("G");
        checkoutPage.fillOutForm("56748");
        checkoutPage.clickContinueButton();
    }
    @Test
    public void clickCancelButton() {
        checkoutPage.openCheckoutPageFromCart();
        checkoutPage.clickCancelButton();
        Assert.assertEquals(checkoutPage.getCurrentUrl(),"https://www.saucedemo.com/cart.html" );
    }

    @AfterMethod
    public void tearD() {
        if (driver != null)
            driver.quit();
    }
}
