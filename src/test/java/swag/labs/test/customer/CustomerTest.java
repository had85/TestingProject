package swag.labs.test.customer;

import org.testng.annotations.Test;

import swag.labs.test.domain.CustomerInformation;
import swag.labs.test.fileparsers.PropertyFileParser;
import swag.labs.test.utils.dataproviders.CustomerDataProvider;

public class CustomerTest {

	@Test(dataProvider = "load-test-customers", dataProviderClass = CustomerDataProvider.class)
	public void testMultipleCustomersLoading(CustomerInformation customerInfo) {

		System.out.println(customerInfo);
	}
	
	@Test(dataProvider = "load-test-customer", dataProviderClass = CustomerDataProvider.class)
	public void testSingleCustomerLoading(CustomerInformation customerInfo) {


		System.out.println(customerInfo);
	}
	
	@Test
	public void testSingleCustomerLoading() {

		System.out.println(PropertyFileParser.readPropety("/url-test-data/url.properties", "baseURL"));
	}
}