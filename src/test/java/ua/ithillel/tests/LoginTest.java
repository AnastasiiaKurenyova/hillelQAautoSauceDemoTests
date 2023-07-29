package ua.ithillel.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ua.ithillel.pages.LoginPage;

import java.net.MalformedURLException;

public class LoginTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = {"/validCreds.csv"}, delimiter = ';')
    @DisplayName("Verify Login Positive Test")
    @Tag("Regression")
    public void verifyLoginPositiveTest(String username, String password) throws MalformedURLException{
        String expectedProductsText = "Products";

        String actualProductsText = new LoginPage()
                .openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginButton()
                .getProductsLabelText();

        Assertions.assertEquals(actualProductsText, expectedProductsText);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/lockedCreds.csv"}, delimiter = ';')
    @DisplayName("Verify Login Locked Test")
    @Tag("Regression")
    public void verifyLoginLockedTest(String username, String password) throws MalformedURLException {
        String expectedErrorText = "Epic sadface: Sorry, this user has been locked out.";

        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginButton();

        String actualErrorText = loginPage.getErrorPopupText();

        Assertions.assertEquals(actualErrorText, expectedErrorText);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/invalidCreds.csv"}, delimiter = ';')
    @DisplayName("Verify Login Negative Test")
    @Tag("Regression")
    public void verifyLoginNegativeTest(String username, String password) throws MalformedURLException{
        String expectedErrorText = "Epic sadface: Username and password do not match any user in this service";

        LoginPage loginPage = new LoginPage();
        loginPage.openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginButton();

        String actualErrorText = loginPage.getErrorPopupText();

        Assertions.assertEquals(actualErrorText, expectedErrorText);
    }
}
