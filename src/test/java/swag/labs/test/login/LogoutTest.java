package swag.labs.test.login;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.labs.test.BaseTest;
import swag.labs.test.domain.User;
import swag.labs.test.pageobjects.LoginPage;
import swag.labs.test.utils.dataproviders.UserDataProvider;

public class LogoutTest extends BaseTest{
    LoginPage loginPage;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);
//
    }

    @Test(dataProvider = "load-valid-users-for-logout", dataProviderClass = UserDataProvider.class)
    public void testLogoutUser(String baseURL, User validUser) throws IOException {

        String currentUrl = loginPage.loginUser(validUser.getUsername(), validUser.getPassword())
        					.logoutUser()
        					.getCurrentUrl();
        assertEquals(currentUrl, baseURL);
    }
}