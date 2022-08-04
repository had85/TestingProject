package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends BasePage {

    private final By checkoutCompleteMessage = By.xpath("//span[contains(text(),'Checkout: Complete!')]");
    private final By thankYouMessage = By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]");
    private final By ponyExpressImage = By.cssSelector("#checkout_complete_container > img");
    private final By backHome = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public PLPPage goBackToProducts(){
        driver.findElement(backHome).click();
        return new PLPPage(driver, wait);
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
