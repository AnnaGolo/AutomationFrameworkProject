package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public abstract class BasePage{
        protected WebDriver driver;
        protected WebDriverWait wait;

        public BasePage(WebDriver driver){
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
            public String getTitle(){
                return driver.getTitle();
        }
            public String getCurrentUrl(){
            return driver.getCurrentUrl();
        }
        public void click (By locator){
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }
        public void typeText(By locator, String text){
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
        }
        public String get(By locator){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        }
        public boolean isDisplayed(By locator){
            try {
                return driver.findElement(locator).isDisplayed();
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return false;
            }
        }
        public static WebDriver createChromeDriver(){
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs",prefs);

            options.addArguments("--incognito");
            return new ChromeDriver(options);
        }
    }

