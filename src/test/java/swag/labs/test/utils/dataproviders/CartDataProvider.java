package swag.labs.test.utils.dataproviders;

import static swag.labs.test.fileparsers.JsonFileParser.readFromJsonFileAsCollection;

import java.util.Arrays;
import java.util.Collection;

import org.testng.annotations.DataProvider;

import swag.labs.test.domain.CartItems;
import swag.labs.test.domain.User;
import swag.labs.test.fileparsers.JsonFileParser;
import swag.labs.test.fileparsers.PropertyFileParser;

public class CartDataProvider {
		
	@DataProvider (name = "init-cart-test-data")
	public Object[][] initCartTestData() {
		 String successCheckoutURL = PropertyFileParser.readPropety("/url-test-data/url.properties", "successCheckoutURL");
		 
		 User validUser = JsonFileParser.readFromJsonFileAsSingleObject("/user-test-data/valid-user.json", User.class);
		 
		 return Arrays.asList(successCheckoutURL)
				 .stream()
				 .map(successCheckoutURLObj -> new Object[] {successCheckoutURLObj, validUser})
				 .toArray(Object[][]::new);
	}
	
	@DataProvider (name = "cart-test-params")
	public static Object[][] cartTestParams (){
				
		 Collection<Object> cartItemsList= readFromJsonFileAsCollection("/cart-test-data/cart-items.json", CartItems.class);
		 		 
		 return cartItemsList
				 .stream()
				 .map(cartItems -> new Object[] {cartItems})
				 .toArray(Object[][]::new);
	}
}