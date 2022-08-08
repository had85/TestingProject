package swag.labs.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutInformationPage extends BasePage {

    private final By checkoutYourInformation = By.xpath("//span[contains(text(),'Checkout: Your Information')]");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By cancelButton = By.id("cancel");
    private final By continueButton = By.id("continue");

    public CheckoutInformationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CheckoutOverviewPage fillInformationAndGoToCheckout(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(continueButton).click();
        return new CheckoutOverviewPage(driver, wait);

    }
}
