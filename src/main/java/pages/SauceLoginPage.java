package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");

    public SauceLoginPage(WebDriver driver) {
        super(driver);
    }
    public SauceLoginPage open(){
        driver.get("https://www.saucedemo.com/");
        return this;
    }
    public void login(String standardUser, String secretSauce) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(standardUser);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(secretSauce);
        driver.findElement(loginBtn).click();

    }

}
