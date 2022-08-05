package swag.labs.test.login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.labs.test.BaseTest;
import swag.labs.test.domain.User;
import swag.labs.test.pageobjects.LoginPage;
import swag.labs.test.utils.dataproviders.UserDataProvider;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);
    }

    @Test(dataProvider = "load-valid-users", dataProviderClass = UserDataProvider.class)
    public void testValidLogin(String successLoginURL, User user) throws IOException {

        loginPage.loginUser(user.getUsername(), user.getPassword());

        assertEquals(loginPage.getCurrentUrl(), successLoginURL);
    }

    @Test(dataProvider = "load-invalid-users", dataProviderClass = UserDataProvider.class)
    public void testInvalidLogin(User invalidUser) throws IOException {

        loginPage.loginUser(invalidUser.getUsername(), invalidUser.getPassword());

        assertTrue(loginPage.isInvalidLoginErrorMessageDisplayed());
    }
}