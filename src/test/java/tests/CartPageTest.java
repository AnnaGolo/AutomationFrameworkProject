package tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CartPageTest extends BasePage {
    private CartPage cartPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BasePage.createChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage login = new SauceLoginPage(driver);
        login.login("standard_user", "secret_sauce");
        cartPage = new CartPage(driver);
    }

    @Test
    public void getTitleText() {
        cartPage.openCartPage();
        cartPage.getTitleText();
        String expectedResult = "Your Cart";
        Assert.assertEquals(cartPage.getTitleText(), expectedResult);
    }

    @Test
    public void getQuantityText() {
        cartPage.openCartPage();
        cartPage.getQuantityText();
        String expectedResult = "QTY";
        Assert.assertEquals(cartPage.getQuantityText(), expectedResult);
    }

    @Test
    public void getDescriptionText() {
        cartPage.openCartPage();
        String expectedResult = "Description";
        Assert.assertEquals(cartPage.getDescriptionText(), expectedResult);
    }
    @Test
    public void getQuantity() {
        cartPage.openCartPage();
        String expectedResult = "1";
        Assert.assertEquals(cartPage.getQuantity(), expectedResult);
    }
    @Test
    public void getProductTitle() {
        cartPage.openCartPage();
        String expectedResult = "Sauce Labs Backpack";
        Assert.assertEquals(cartPage.getProductTitle(),expectedResult);
    }
    @Test
    public void getProductDescriptionText() {
        cartPage.openCartPage();
        String expectedResult = "carry.allTheThings() with the sleek, " +
                "streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        Assert.assertEquals(cartPage.getProductDescriptionText(),expectedResult);
    }
    @Test
    public void getBackPackPrice() {
        cartPage.openCartPage();
        String expectedResult = "$29.99";
        Assert.assertEquals(cartPage.getBackPackPrice(), expectedResult);
    }
    @Test
    public void clickRemoveButton() {
        cartPage.openCartPage();
        cartPage.clickRemoveButton();
        Assert.assertFalse(cartPage.productTitleIsDisplayed());
    }
    @Test
    public void  clickContinueShoppingButton() {
        cartPage.openCartPage();
        cartPage.clickContinueShoppingButton();
        driver.getCurrentUrl();
        String expectedResult = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
    }
    @Test
    public void clickCheckoutButton() {
        cartPage.openCartPage();
        cartPage.clickCheckoutButton();
        driver.getCurrentUrl();
        String expectedResult = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedResult);
    }
    @AfterMethod
    public void tearD() {
        if (driver != null)
            driver.quit();
    }
}

