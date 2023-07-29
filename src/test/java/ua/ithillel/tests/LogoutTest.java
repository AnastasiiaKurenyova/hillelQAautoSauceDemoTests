package ua.ithillel.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ua.ithillel.pages.LoginPage;

import java.net.MalformedURLException;

public class LogoutTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = {"/validCreds.csv"}, delimiter = ';')
    @DisplayName("Verify Logout Positive Test")
    @Tag("Regression")
    public void verifyLogoutPositiveTest(String username, String password) throws MalformedURLException {

        boolean isLoginPageVisible = new LoginPage()
                .openPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginButton()
                .clickBurgerMenuButton()
                .clickLogoutButton()
                .isLoginPageVisible();

        Assertions.assertTrue(isLoginPageVisible);
    }
}
