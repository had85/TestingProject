package swag.labs.test.utils.dataproviders;

import static swag.labs.test.fileparsers.JsonFileParser.readFromJsonFileAsCollection;

import java.util.Collection;

import org.testng.annotations.DataProvider;

import swag.labs.test.domain.Checkout;
import swag.labs.test.fileparsers.PropertyFileParser;

public class CartDataProvider {
	
	@DataProvider (name = "cart-test-data")
	public static Object[][] loadCartTestData (){
		
		 Object successCheckoutURL = PropertyFileParser.readPropety("/url-test-data/url.properties", "successCheckoutURL");
		
		 Collection<Object> checkouts = readFromJsonFileAsCollection("/cart-test-data/cart-items.json", Checkout.class);
		 		 
		 return checkouts
				 .stream()
				 .map(checkout -> new Object[] {successCheckoutURL, checkout})
				 .toArray(Object[][]::new);
	}
}