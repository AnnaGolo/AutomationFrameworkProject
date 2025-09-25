package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
    private final By titleText = By.className("title");
    private final By quantityText = By.className("cart_quantity_label");
    private final By descriptionText = By.xpath("//div[@data-test='cart-desc-label']");
    private final By productQuantityField = By.className("cart_quantity");
    private final By productTitle = By.xpath("//div[@data-test='inventory-item-name']");
    private final By productDescriptionText = By.className("inventory_item_desc");
    private final By itemPrice = By.className("inventory_item_price");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    private final By addToCartButton = By.id("add-to-cart");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public String getTitleText() {
        return driver.findElement(titleText).getText();
    }
    public boolean productQuantityFielsIsDisplayed(){
        driver.findElement(productQuantityField).isDisplayed();
        return false;
    }
    public String getQuantityText() {
        return driver.findElement(quantityText).getText();
    }
    public String getDescriptionText() {
        return driver.findElement(descriptionText).getText();
    }
    public String getQuantity() {
        return driver.findElement(productQuantityField).getText();
    }
    public boolean productTitleIsDisplayed() {
        Assert.assertTrue(driver.findElement(titleText).isDisplayed());
        return false;
    }
    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }
    public String getProductDescriptionText() {
        return driver.findElement(productDescriptionText).getText();
    }
    public String getBackPackPrice() {
        return driver.findElement(itemPrice).getText();
    }
    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }
    public void  clickContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
        driver.getCurrentUrl();
    }
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
        driver.getCurrentUrl();
    }
    public void openCartPage(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        BackPackProductPage backPackProductPage = new BackPackProductPage(driver);
        inventoryPage.addProductToTheCart();
        backPackProductPage.clickCartIcon();
    }
}

