package ua.ithillel.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ua.ithillel.pages.LoginPage;

public class LoginTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(resources = {"/validCreds.csv"}, delimiter = ';')
    @DisplayName("Verify Login Positive Test")
    public void verifyLoginPositiveTest(String username, String password) {
        String expectedProductsText = "Products";
        String actualProductsText = new LoginPage()
                .openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginButton()
                .getProductsText();
        Assertions.assertEquals(actualProductsText, expectedProductsText);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/lockedCreds.csv"}, delimiter = ';')
    @DisplayName("Verify Login Locked Test")
    public void verifyLoginLockedTest(String username, String password) {
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
    public void verifyLoginNegativeTest(String username, String password) {
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
