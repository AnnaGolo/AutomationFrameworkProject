package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By searchBox = By.name("search");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage navigateToHomePage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }
}
