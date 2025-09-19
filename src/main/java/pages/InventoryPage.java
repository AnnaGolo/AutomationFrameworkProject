package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage {

    private final By sauceLabsBackpackProductTitle = By.xpath("(//div[@class=\"inventory_item_name \"])[1]");
    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By productDescription = By.xpath("(//div[@class = 'inventory_item_desc'])[1]");
    private final By appLogo = By.cssSelector(".app_logo");
    private final By cartLogo = By.cssSelector(".shopping_cart_badge");
    private final By title = By.xpath("//span[@class='title']");
    private final By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
    private final By backPackprice = By.xpath("(//div[@data-test= 'inventory-item-price'])[1]");
    private final By backPackImage = By.xpath("//img[@data-test=\"inventory-item-sauce-labs-backpack-img\"]");
    private final By filterDropdown = By.xpath("//select[@class=\"product_sort_container\"]");
    private final By removeProductButton = By.xpath("//button[text()='Remove']");
    private final By twitterIcon = By.xpath("//a[@data-test ='social-twitter']");
    private final By facebookIcon = By.xpath("//a[@data-test=\"social-facebook\"]");
    private final By linkedInIcon = By.xpath("//a[@data-test=\"social-linkedin\"]");
    private final By footerCopyRight = By.cssSelector(".footer_copy");
    private final By burgerIcon = By.id("react-burger-menu-btn");
    private final By allItemsButton = By.id("inventory_sidebar_link");
    private final By aboutButton = By.id("about_sidebar_link");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By resetButton = By.id("reset_sidebar_link");
    private final By productCards = By.className("inventory_item");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public boolean appLogoPresent() {
        return driver.findElement(appLogo).isDisplayed();
    }

    public boolean isProductTitleDisplayed() {
        return driver.findElement(sauceLabsBackpackProductTitle).isDisplayed();
    }

    public boolean isProductImageDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public boolean isProductPriceDisplayed() {
        return driver.findElement(backPackprice).isDisplayed();
    }

    public boolean isBackpackPictureDisplayed() {
        return driver.findElement(backPackImage).isDisplayed();
    }

    public String getProductPrice() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(backPackprice));
        return element.getText();
    }

    public void addProductToTheCart() {
        driver.findElement(addToCartButton).click();
    }

    public int getCartCount() {
        List<WebElement> badges = driver.findElements(cartLogo);
        if (badges.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(badges.get(0).getText());
        }
    }

    public boolean isShoppingCardDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public void removeProductFromTheCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(removeProductButton));
        driver.findElement(removeProductButton).click();
    }

    public boolean productDescriptionsIsDisplayed() {
        return driver.findElement(productDescription).isDisplayed();
    }

    public boolean dropdownMenuIsDisplayed() {
        return driver.findElement(filterDropdown).isDisplayed();
    }

    public void selectSortOption(String value) {
        WebElement dropdown = driver.findElement(filterDropdown);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public String getSelectedOption() {
        WebElement dropdown = driver.findElement(filterDropdown);
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    public boolean twitterIconIsDisplayed() {
        return driver.findElement(twitterIcon).isDisplayed();
    }

    public void twitterButtonIsClickable() {
        driver.findElement(twitterIcon).click();
    }

    public boolean facebookIconIsDisplayed() {
        return driver.findElement(facebookIcon).isDisplayed();
    }

    public void facebookButtonIsClickable() {
        driver.findElement(facebookIcon).click();
    }

    public boolean linkedInIconIsDisplayed() {
        return driver.findElement(linkedInIcon).isDisplayed();
    }

    public void linkedInButtonIsClickable() {
        driver.findElement(linkedInIcon).click();
    }

    public String setFooterCopyRightText() {
        return driver.findElement(footerCopyRight).getText();
    }

    public boolean isBurgerButtonDisplayed() {
        return driver.findElement(burgerIcon).isDisplayed();
    }

    public void isBurgerButtonIsClickable() {
        driver.findElement(burgerIcon).click();
    }

    public boolean isAllItemsButtonDisplayed() {
        return driver.findElement(allItemsButton).isDisplayed();
    }

    public void isAllItemsButtonIsClickable() {
        driver.findElement(allItemsButton).click();
    }

    public boolean isLogoutButtonDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void isAboutButtonIsClickable() {
        driver.findElement(aboutButton).click();
    }

    public boolean isAboutButtonDisplayed() {
        return driver.findElement(aboutButton).isDisplayed();
    }

    public void isLogoutButtonIsClickable() {
        driver.findElement(logoutButton).click();
    }

    public boolean isResetButtonDisplayed() {
        return driver.findElement(resetButton).isDisplayed();
    }

    public void isResetButtonIsClickable() {
        driver.findElement(resetButton).click();
    }

    public int getProductCount() {
        return driver.findElements(productCards).size();
    }
}



