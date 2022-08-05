package swag.labs.test.checkout;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.labs.test.BaseTest;
import swag.labs.test.domain.Checkout;
import swag.labs.test.pageobjects.LoginPage;
import swag.labs.test.utils.dataproviders.CheckoutDataProvider;

public class CheckoutTest extends BaseTest {

	LoginPage loginPage;

	@BeforeMethod
	public void setUp() throws IOException {
		loginPage = new LoginPage(driver, wait);
	}
	
	@Test(dataProvider = "checkout-test-data", dataProviderClass = CheckoutDataProvider.class)
	public void testCheckout(String successCheckoutURL, Checkout checkout) throws IOException {
		String checkoutCompleteURL = loginPage
									.loginUser(checkout.getUser().getUsername(), checkout.getUser().getPassword())
									.addToCart(checkout.getItemsToBuy())
									.goToCheckout()
									.continueToCheckout(checkout.getUser().getFirstName(),
											checkout.getUser().getLastName(), checkout.getUser().getPostalCode())
									.finishCheckout()
									.getCurrentUrl();
		
		assertEquals(successCheckoutURL, checkoutCompleteURL);
	}
}