package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BackPackProductPage;
import pages.BasePage;
import pages.InventoryPage;
import pages.SauceLoginPage;

public class BackPackProductPageTest {
    private BackPackProductPage backPackProductPage;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BasePage.createChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage login = new SauceLoginPage(driver);
        login.login("standard_user", "secret_sauce");
        backPackProductPage = new BackPackProductPage(driver);
    }
    @Test
    public void backToProductsPageIsDispalyed() {
        Assert.assertTrue(backPackProductPage.backToProductsPageIsDisplayed());
    }
    @Test
    public void backToProductsButtonIsClickable(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.isProductTitleButtonIsClickable();
        backPackProductPage.backToProductsPage();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
    @Test
    public void backToProductsButtonIsDisplayed(){
        Assert.assertTrue(backPackProductPage.backToProductsPageIsDisplayed());
    }
    @Test
    public void AppLogoIsDisplayed() {
        Assert.assertTrue(backPackProductPage.backToProductsPageIsDisplayed());
    }
    @Test
    public void ProductNameIsDisplayed() {
        Assert.assertTrue(backPackProductPage.backToProductsPageIsDisplayed());
    }
    @Test
    public void ProductImageIsDisplayed() {
        Assert.assertTrue(backPackProductPage.ProductNameIsDisplayed());
    }
    @Test
    public void RemoveButtonIsDisplayed() {
        Assert.assertTrue(backPackProductPage.backToProductsPageIsDisplayed());
    }
    public void CartIconIsDisplayed() {
        Assert.assertTrue(backPackProductPage.backToProductsPageIsDisplayed());
    }
    
    @AfterMethod
    public void tearD() {
        if (driver != null)
            driver.quit();
    }
}