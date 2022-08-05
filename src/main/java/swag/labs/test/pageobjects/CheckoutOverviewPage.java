package swag.labs.test.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage extends BasePage{
    private final By checkoutOverviewText = By.xpath("//span[contains(text(),'Checkout: Overview')]");
    private final By productName = By.id("item_4_title_link");
    private final By productDescription = By.className("inventory_item_desc");
    private final By productPrice = By.className("inventory_item_price");
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    public CheckoutCompletePage finishCheckout(){
        driver.findElement(finishButton).click();
        return new CheckoutCompletePage(driver, wait);
    }
}
