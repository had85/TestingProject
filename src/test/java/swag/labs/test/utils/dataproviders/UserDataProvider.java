package swag.labs.test.utils.dataproviders;

import static swag.labs.test.fileparsers.JsonFileParser.readFromJsonFileAsCollection;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import swag.labs.test.domain.User;
import swag.labs.test.fileparsers.PropertyFileParser;

public class UserDataProvider {
	
	@DataProvider (name = "load-valid-users")
	public static Object[][] loadValidUsers (){
		
		 Object successLoginURL = PropertyFileParser.readPropety("/url-test-data/url.properties", "successLoginURL");

		 List<Object> validUsers = readFromJsonFileAsCollection("/user-test-data/valid-users.json", User.class);
		 
		 return validUsers
				 .stream()
				 .map(checkout -> new Object[] {successLoginURL, checkout})
				 .toArray(Object[][]::new);
	}
	
	@DataProvider (name = "load-invalid-users")
	public static Iterator<Object> loadInvalidUsers() {
		
		 List<Object> invalidUsers = readFromJsonFileAsCollection("/user-test-data/invalid-users.json", User.class);
		 
		 return invalidUsers.iterator();
	}
	
	@DataProvider (name = "load-valid-users-for-plp")
	public static Iterator<Object> loadValidUsersForPlp() {
		
		 List<Object> validUsers = readFromJsonFileAsCollection("/user-test-data/valid-users.json", User.class);
		 
		 return validUsers.iterator();
	}
	
	@DataProvider (name = "load-valid-users-for-logout")
	public static Object[][] loadValidUsersForLogout (){
		
		 Object baseUrl = PropertyFileParser.readPropety("/url-test-data/url.properties", "baseURL");

		 List<Object> validUsers = readFromJsonFileAsCollection("/user-test-data/valid-users.json", User.class);
		 
		 return validUsers
				 .stream()
				 .map(checkout -> new Object[] {baseUrl, checkout})
				 .toArray(Object[][]::new);
	}
}