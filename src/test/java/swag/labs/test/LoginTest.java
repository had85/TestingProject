package swag.labs.test;

import jsonFilesParser.JSONManagement;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pageClasses.LoginPage;

import java.io.IOException;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    String username;

    String password;

    String successLoginURL;

    String emptyUsername;

    @BeforeMethod
    public void setUp() throws IOException {
        loginPage = new LoginPage(driver, wait);

        username = JSONManagement.readProperty("username");

        password = JSONManagement.readProperty("password");

        successLoginURL = JSONManagement.readProperty("successLoginURL");

        emptyUsername = "";
    }

    @Test
    public void testValidLogin() throws IOException {

        loginPage.loginUser(username, password);

        assertEquals(successLoginURL, loginPage.getCurrentUrl());
    }

    @Test
    public void testInvalidLogin() throws IOException {

        loginPage.loginUser(emptyUsername, password);

        assertTrue(loginPage.isInvalidLoginErrorMessageDisplayed());
    }
}
