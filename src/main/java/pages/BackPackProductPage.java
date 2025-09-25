package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BackPackProductPage extends BasePage {

    private final By appLogo = By.className("class=\"app_logo\"");
    private final By sauceLabsBackpackProductTitle = By.xpath("(//div[@class ='inventory_item_name '])[1]");
    private final By productimage = By.className("inventory_details_img");
    private final By removeButton = By.xpath("//button[@data-test= 'remove']");
    private final By cartIcon = By.xpath("//a[@data-test ='shopping-cart-link']");
    private final By backToProductsButton = By.id("back-to-products");
    private final By cartLogo = By.cssSelector(".shopping_cart_badge");
    private final By addToCardButton = By.id("add-to-cart");

    public BackPackProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean backToProductsPageIsDisplayed() {
        driver.findElement(sauceLabsBackpackProductTitle).click();
        return driver.findElement(backToProductsButton).isDisplayed();
    }
    public void backToProductsPage(){
        driver.findElement(backToProductsButton).click();
    }
    public void backToProductsButtonIsClickable(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        BackPackProductPage backPackProductPage = new BackPackProductPage(driver);
        inventoryPage = new InventoryPage(driver);
        inventoryPage.isProductTitleButtonIsClickable();
        backPackProductPage.backToProductsPage();
    }

    public void removeProductFromCart(){
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToTheCart();
        inventoryPage.isProductTitleButtonIsClickable();
        driver.findElement(removeButton).click();

    }
    public int getCartCount() {
        List<WebElement> badges = driver.findElements(cartLogo);
        if (badges.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(badges.get(0).getText());
        }
    }
    public boolean AppLogoIsDisplayed() {
        return driver.findElement(appLogo).isDisplayed();
    }
    public boolean ProductNameIsDisplayed() {
        return driver.findElement(sauceLabsBackpackProductTitle).isDisplayed();
    }
    public boolean ProductImageIsDisplayed() {
        return driver.findElement(productimage).isDisplayed();
    }
    public boolean RemoveButtonIsDisplayed() {
        return driver.findElement(removeButton).isDisplayed();
    }
    public boolean CartIconIsDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }
    public void clickCartIcon(){
        driver.findElement(cartIcon).click();
    }

}
