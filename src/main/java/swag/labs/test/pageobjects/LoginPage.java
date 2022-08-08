package swag.labs.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import swag.labs.test.fileparsers.PropertyFileParser;

import java.io.IOException;

public class LoginPage extends BasePage {

    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    private final By errorMessageEmptyUsernameField = By.xpath("//h3[contains(text(),'Epic sadface: Username is required')]");


    public LoginPage(WebDriver driver, WebDriverWait wait) throws IOException {
        super(driver, wait);
        String baseURL = PropertyFileParser.readPropety("/url-test-data/url.properties", "baseURL");
        driver.get(baseURL);
    }
    
    public PLPPage loginUser(String username, String password)  {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new PLPPage(driver, wait);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isInvalidLoginErrorMessageDisplayed(){
        return driver.findElement(errorMessageEmptyUsernameField).isDisplayed();
    }
}
