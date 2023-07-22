package ua.ithillel.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest() {
        driver.get("https://www.saucedemo.com/");
        Assertions.assertTrue(true);
    }
}
