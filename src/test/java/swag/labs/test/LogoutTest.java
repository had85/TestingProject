package swag.labs.test;

import jsonFilesParser.JSONManagement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.LoginPage;
import pageClasses.PLPPage;

import java.io.IOException;

import static org.testng.Assert.*;

public class LogoutTest extends BaseTest{
    LoginPage loginPage;

    String username;

    String password;

    String baseURL;


    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);

        username = JSONManagement.readProperty("username");

        password = JSONManagement.readProperty("password");

        baseURL = JSONManagement.readProperty("baseURL");

    }

    @Test
    public void testLogoutUser() throws IOException {

        PLPPage plpPage = loginPage.loginUser(username,password);

        plpPage.logoutUser();

        assertEquals(baseURL, plpPage.getCurrentUrl());

    }
}
