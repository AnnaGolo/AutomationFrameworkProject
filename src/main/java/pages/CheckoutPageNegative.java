package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageNegative extends BasePage {
    private final By checkoutTitleText = By.xpath("//span[@class=\"title\"]");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.xpath("//input[@placeholder=\"Last Name\"]");
    private final By zipCodeField = By.id("postal-code");
    private final By contunueButton = By.id("continue");
    private final By closeErrorMessage = By.xpath("//button[@data-test=\"error-button\"]");

    public CheckoutPageNegative(WebDriver driver) {
            super.driver = driver;
        }
    public void addFirstNameNeg(String anna) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).click();
        driver.findElement(firstNameField).sendKeys("Anna");

    }
    public void addLastNameNeg(String g) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).click();
        driver.findElement(lastNameField).sendKeys("G");
    }

    public void addZipCodeNeg(String number) {
        driver.findElement(zipCodeField).clear();
        driver.findElement(zipCodeField).click();
        driver.findElement(zipCodeField).sendKeys("76894");
    }

    public void clickContinueButton() {
        driver.findElement(contunueButton).click();
    }
    public void closeErrorMessage() {
        driver.findElement(closeErrorMessage).click();
    }
    public void openCheckoutPageFromCartNeg() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        BackPackProductPage backPackProductPage = new BackPackProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        inventoryPage.addProductToTheCart();
        inventoryPage.clickBackPackPackTitle();
        backPackProductPage.clickCartIcon();
        cartPage.clickCheckoutButton();
    }
}
