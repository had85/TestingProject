package swag.labs.test.utils.dataproviders;

import static swag.labs.test.fileparsers.JsonFileParser.readFromJsonFileAsCollection;

import java.util.Collection;

import org.testng.annotations.DataProvider;

import swag.labs.test.domain.Checkout;
import swag.labs.test.fileparsers.PropertyFileParser;

public class CheckoutDataProvider {
	
	@DataProvider (name = "checkout-test-data")
	public static Object[][] loadCheckoutTestData (){
		
		 Object successCheckoutURL = PropertyFileParser.readPropety("/url-test-data/url.properties", "successCheckoutURL");
		
		 Collection<Object> checkouts = readFromJsonFileAsCollection("/checkout-test-data/checkouts.json", Checkout.class);
		 		 
		 return checkouts
				 .stream()
				 .map(checkout -> new Object[] {successCheckoutURL, checkout})
				 .toArray(Object[][]::new);
	}
}