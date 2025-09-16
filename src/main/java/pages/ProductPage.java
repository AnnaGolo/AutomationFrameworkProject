package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By sauceLabsBackpackProduct = By.id("Sauce Labs Backpack");
    private final By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By appLogo = By.cssSelector(".app_logo");
    private final By title = By.xpath("//span[@class='title']");
    private final By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
    private final By packPackprice = By.xpath("(//div[@data-test= 'inventory-item-price'])[1]");
    private final By backPackImage = By.xpath("//img[@data-test=\"inventory-item-sauce-labs-backpack-img\"]");
    private final By filterDropdown = By. xpath("//select[@class=\"product_sort_container\"]");
    private final By removeProductButton = By.id("id=\"remove-sauce-labs-backpack\"");
    private final By twitterIcon = By.id("//a[@data-test=\"social-twitter\"]");
    private final By facebookIcon = By.xpath("//a[@data-test=\"social-facebook\"]");
    private final By linkedInIcon = By.xpath("//a[@data-test=\"social-linkedin\"]");
    private final By footerCopy = By.cssSelector(".footer_copy");
    private final By burgerIcon = By.id("react-burger-menu-btn");
    private final By allItemsButton = By.id("inventory_sidebar_link");
    private final By aboutButton = By.id("about_sidebar_link");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By resetButton = By.id("reset_sidebar_link");


    public ProductPage(WebDriver driver) {
        super(driver);

}

}
}

