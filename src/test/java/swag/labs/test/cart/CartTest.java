package swag.labs.test.cart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import swag.labs.test.BaseTest;
import swag.labs.test.domain.Checkout;
import swag.labs.test.pageobjects.LoginPage;
import swag.labs.test.utils.dataproviders.CartDataProvider;

public class CartTest extends BaseTest {

	LoginPage loginPage;
	
	String successCheckoutURL;
	
	@Factory(dataProvider = "success-checkout-url", dataProviderClass = CartDataProvider.class)
	public CartTest(String successCheckoutURL) {
		this.successCheckoutURL = successCheckoutURL;
	}

	@BeforeMethod
	public void setUp() throws IOException {
		loginPage = new LoginPage(driver, wait);
	}
	
	@Test(dataProvider = "cart-test-data", dataProviderClass = CartDataProvider.class)
	public void testAddToCart(Checkout checkout) throws IOException {
		Collection<String> productNamesInCart = loginPage
												.loginUser(checkout.getUser().getUsername(), checkout.getUser().getPassword())
												.addToCart(checkout.getItemsToBuy())
												.getAllProducNamesInCart();
		
		assertEquals(productNamesInCart, checkout.getItemsToBuyNames());
	}
}