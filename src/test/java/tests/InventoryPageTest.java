package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.InventoryPage;
import pages.SauceLoginPage;

public class InventoryPageTest {
    private WebDriver driver;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        driver = BasePage.createChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage login = new SauceLoginPage(driver);
        login.login("standard_user", "secret_sauce");

        inventoryPage = new InventoryPage(driver);
    }
    @Test
    public void isProductTitleDisplayed() {
        Assert.assertTrue(inventoryPage.isProductTitleDisplayed());
    }
    @Test
    public void isProductDescriptionsIsDisplayed() {
        Assert.assertTrue(inventoryPage.productDescriptionsIsDisplayed());
    }
    @Test
    public void isProductImageDisplayed() {
        Assert.assertTrue(inventoryPage.isProductImageDisplayed());
    }
    @Test
    public void isProductPriceDisplayed() {
        Assert.assertTrue(inventoryPage.isProductPriceDisplayed());
    }
    @Test
    public void getProductPrice() {
        String actualPrice = inventoryPage.getProductPrice();
        Assert.assertEquals(actualPrice, "$29.99");
    }
    @Test
    public void addProductToTheCart() {
        inventoryPage.addProductToTheCart();
    }
    @Test
    public void cartCount_initiallyZero() {
        Assert.assertEquals(inventoryPage.getCartCount(), 0);
    }
    @Test
    public void cartCount_increasesAfterAdd() {
        inventoryPage.addProductToTheCart();
        Assert.assertEquals(inventoryPage.getCartCount(), 1);
    }
    @Test
    public void cartCount_decreasesAfterRemove(){
        inventoryPage.addProductToTheCart();
        inventoryPage.removeProductFromTheCart();
        Assert.assertEquals(inventoryPage.getCartCount(), 0);
    }
    @Test
    public void dropdownMenuIsDisplayed(){
        inventoryPage.dropdownMenuIsDisplayed();
    }
    @Test
    public void  selectSortOption() {
        inventoryPage.selectSortOption("za");
        Assert.assertEquals(inventoryPage.getSelectedOption(),"Name (Z to A)");
    }
    @DataProvider(name = "sortOptions")
        public Object[] selectSortOptions () {
        return new Object[][]{
                {"za", "Name (Z to A)"},
                {"az", "Name (A to Z)"},
                {"lohi", "Price (low to high)"},
                {"hilo", "Price (high to low)"}
        };
    }
    @Test(dataProvider = "sortOptions")
    public void selectSortOption(String value, String expectedText) {
        inventoryPage.selectSortOption(value);
        Assert.assertEquals(inventoryPage.getSelectedOption(), expectedText);
    }
    @AfterMethod
    public void tearD() {
        if (driver != null)
            driver.quit();
    }
}
