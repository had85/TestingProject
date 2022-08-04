package swag.labs.test;

import jsonFilesParser.JSONManagement;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.LoginPage;
import pageClasses.PLPPage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PLPSortingTest extends BaseTest{

    LoginPage loginPage;

    String username;

    String password;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);

        username = JSONManagement.readProperty("username");

        password = JSONManagement.readProperty("password");



    }
    @Test
    public void testPLPSorting() {

        PLPPage plpPage = loginPage.loginUser(username,password);
        List<Double> unsortedProductPrices = plpPage.getProductPrices();
        List<Double> productPricesSortedDescendingOrder = plpPage.getProductPricesDescendingOrder();
        Collections.sort(unsortedProductPrices);
        Collections.reverse(unsortedProductPrices);
        assertEquals(unsortedProductPrices, productPricesSortedDescendingOrder);
    }
}

