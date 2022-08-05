package swag.labs.test.products;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.labs.test.BaseTest;
import swag.labs.test.domain.User;
import swag.labs.test.pageobjects.LoginPage;
import swag.labs.test.pageobjects.PLPPage;
import swag.labs.test.utils.dataproviders.UserDataProvider;

public class PLPSortingTest extends BaseTest {

	LoginPage loginPage;

	@BeforeMethod
	public void setUp() throws IOException {
		loginPage = new LoginPage(driver, wait);

	}

	@Test(dataProvider = "load-valid-users-for-plp", dataProviderClass = UserDataProvider.class)
	public void testPLPSorting(User validUser) {

		PLPPage plpPage = loginPage.loginUser(validUser.getUsername(), validUser.getPassword());
		List<Double> unsortedProductPrices = plpPage.getProductPrices();
		List<Double> productPricesSortedDescendingOrder = plpPage.getProductPricesDescendingOrder();
		Collections.sort(unsortedProductPrices);
		Collections.reverse(unsortedProductPrices);
		assertEquals(unsortedProductPrices, productPricesSortedDescendingOrder);
	}
}
