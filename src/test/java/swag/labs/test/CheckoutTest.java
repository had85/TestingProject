package swag.labs.test;

import jsonFilesParser.JSONManagement;
import static org.testng.Assert.*;

import org.openqa.selenium.devtools.v101.domstorage.model.Item;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.*;

import java.io.IOException;
import java.util.List;

public class CheckoutTest extends BaseTest{

    LoginPage loginPage;
    String username;
    String password;
    String firstName;
    String lastName;
    String postalCode;
    String successCheckoutURL;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);

        username = JSONManagement.readProperty("username");

        password = JSONManagement.readProperty("password");

        firstName = JSONManagement.readProperty("firstName");

        lastName = JSONManagement.readProperty("lastName");

        postalCode = JSONManagement.readProperty("postalCode");

        successCheckoutURL = JSONManagement.readProperty("successCheckoutURL");

    }

    @Test
    public void testCheckout() throws IOException {

        PLPPage plpPage = loginPage.loginUser(username,password);
        String productNamePLP = plpPage.getProductName();
        //List<String> itemsToBuy = jsonFileParser.parse("items_for_cart.json");
        YourCartPage yourCartPage = plpPage.addToCart(itemsToBuy);
        String productNameCart = yourCartPage.getProductName();
        assertEquals(productNamePLP, productNameCart);
        CheckoutInformationPage checkoutInformationPage = yourCartPage.goToCheckout();
        checkoutInformationPage.continueToCheckout(firstName,lastName,postalCode);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver, wait);
        checkoutOverviewPage.finishCheckout();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver, wait);
        assertEquals(successCheckoutURL, checkoutCompletePage.getCurrentUrl());



    }
}
