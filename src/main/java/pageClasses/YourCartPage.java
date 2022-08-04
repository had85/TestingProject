package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourCartPage extends BasePage{

    private final By yourCartTitle = By.xpath("//span[contains(text(),'Your Cart')]");
    private final By sauceLabsBackpack = By.id("item_4_title_link");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By continueShopping = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");

    public YourCartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CheckoutInformationPage goToCheckout(){
        driver.findElement(checkoutButton).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(CheckoutInformationPage.checkoutYourInformation));
        return new CheckoutInformationPage(driver, wait);
    }
    public void goToContinueShopping(){
        driver.findElement(continueShopping).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(PLPPage.sauceLabsBackpack));
    }
    public void removeFromCart(){
        driver.findElement(removeButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceLabsBackpack));
    }

    public String getProductName (){
        driver.findElement(sauceLabsBackpack).getText();
        return driver.findElement(sauceLabsBackpack).getText();
    }

}
