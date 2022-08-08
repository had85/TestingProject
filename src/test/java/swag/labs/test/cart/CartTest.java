package swag.labs.test.cart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import swag.labs.test.BaseTest;
import swag.labs.test.domain.CartItems;
import swag.labs.test.domain.User;
import swag.labs.test.pageobjects.LoginPage;
import swag.labs.test.utils.dataproviders.CartDataProvider;

public class CartTest extends BaseTest {

	LoginPage loginPage;
	
	String successCheckoutURL;
	
	User user;
	
	@Factory(dataProvider = "init-cart-test-data", dataProviderClass = CartDataProvider.class)
	public CartTest(String successCheckoutURL, User user) {
		this.successCheckoutURL = successCheckoutURL;
		this.user = user;
	}

	@BeforeMethod
	public void setUp() throws IOException {
		loginPage = new LoginPage(driver, wait);
	}
	
	@Test(dataProvider = "cart-items-to-add", dataProviderClass = CartDataProvider.class)
	public void testAddToCart(CartItems cartItemsToAdd) throws IOException {
		Collection<String> productNamesInCart = loginPage
												.loginUser(user.getUsername(), user.getPassword())
												.addToCart(cartItemsToAdd.getCartItems())
												.getAllProducNamesInCart();
		
		assertEquals(productNamesInCart, cartItemsToAdd.getNamesOfCartItems());
	}
}