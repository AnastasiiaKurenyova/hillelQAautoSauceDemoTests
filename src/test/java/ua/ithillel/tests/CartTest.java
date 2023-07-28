package ua.ithillel.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ua.ithillel.model.User;
import ua.ithillel.model.UserCreator;
import ua.ithillel.pages.LoginPage;

import java.util.Arrays;
import java.util.List;

public class CartTest extends BaseTest {

    @Test
    @Tag("Regression")
    @DisplayName("Verify Products In Cart Test")
    public void verifyProductsInCartTest() {
        User testUser = UserCreator.createStandartUser();

        List<Double> actualProductPriceList = new LoginPage()
                .openPage()
                .setUsername(testUser.getUsername())
                .setPassword(testUser.getPassword())
                .clickLoginButton()
                .filterByPriceAsc()
                .addProductToCart(0)
                .addProductToCart(1)
                .clickCartButton()
                .getProductPriceList();

        List<Double> expectedProductPriceList = Arrays.asList(7.99, 9.99);

        Assertions.assertEquals(actualProductPriceList, expectedProductPriceList);
    }
}
