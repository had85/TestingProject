package swag.labs.test.utils.dataproviders;

import static swag.labs.test.fileparsers.JsonFileParser.readFromJsonFileAsCollection;
import static swag.labs.test.fileparsers.JsonFileParser.readFromJsonFileAsSingleObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import swag.labs.test.domain.CustomerInformation;

public class CustomerDataProvider {
	
	@DataProvider (name = "load-test-customers")
	public static Iterator<Object> loadTestCustomers (){
		 Collection<Object> customers = readFromJsonFileAsCollection("/customer-test-data/multiple-customers.json", CustomerInformation.class);
		 return customers.iterator();
	}
	
	@DataProvider (name = "load-test-customer")
	public static Iterator<Object> loadTestCustomer (){
		 Object customerObj = readFromJsonFileAsSingleObject("/customer-test-data/single-customer.json", CustomerInformation.class);
		 return Arrays.asList(customerObj)
				 .stream()
				 .iterator();
	}
}