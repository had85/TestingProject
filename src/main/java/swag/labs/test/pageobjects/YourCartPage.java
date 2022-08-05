package swag.labs.test.pageobjects;

import java.util.Collection;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourCartPage extends BasePage{

    private final By yourCartTitle = By.xpath("//span[contains(text(),'Your Cart')]");
    private final By sauceLabsBackpack = By.id("item_4_title_link");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By continueShopping = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");
    
    private final By productNames = By.cssSelector("#cart_contents_container .inventory_item_name");

    public YourCartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        driver.get("https://www.saucedemo.com/cart.html");
    }

    public CheckoutInformationPage goToCheckout(){
        driver.findElement(checkoutButton).click();
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

    public Collection<String> getAllProducNamesInCart(){
       return driver.findElements(productNames)
    		   .stream()
    		   .map(WebElement::getText)
    		   .collect(Collectors.toList());
    }

}
