package pages;

import org.apache.commons.io.input.TaggedReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    private final By checkoutTitleText = By.xpath("//span[@class=\"title\"]");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.xpath("//input[@placeholder=\"Last Name\"]");
    private final By zipCodeField = By.id("postal-code");
    private final By contunueButton = By.id("continue");
    private final By cancelButton = By.className("cancel");
    private final By checkoutButton = By.xpath("//button[@data-test =\"checkout\"]");

    public CheckoutPage(WebDriver driver) {
        super.driver = driver;
    }
    public String checkoutTitleText() {
        return driver.findElement(checkoutTitleText).getText();
    }
    public void addFirstName(String anna) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).click();
        driver.findElement(firstNameField).sendKeys("Anna");

    }
    public void addLastName(String g) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).click();
        driver.findElement(lastNameField).sendKeys("G");
    }
    public void addZipCode(String number) {
        driver.findElement(zipCodeField).clear();
        driver.findElement(zipCodeField).click();
        driver.findElement(zipCodeField).sendKeys("76894");
    }
    public void clickContinueButton() {
        driver.findElement(contunueButton).click();
    }
    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
    public void openCheckoutPage() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        BackPackProductPage backPackProductPage = new BackPackProductPage(driver);
        inventoryPage.addProductToTheCart();
        backPackProductPage.clickCartIcon();
    }
    public void openCheckoutPageFromCart() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        BackPackProductPage backPackProductPage = new BackPackProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        inventoryPage.addProductToTheCart();
        inventoryPage.clickBackPackPackTitle();
        backPackProductPage.clickCartIcon();
        cartPage.clickCheckoutButton();

    }
}
