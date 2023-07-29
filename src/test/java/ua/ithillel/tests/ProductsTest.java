package ua.ithillel.tests;

import java.net.MalformedURLException;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ua.ithillel.model.User;
import ua.ithillel.model.UserCreator;
import ua.ithillel.pages.LoginPage;
import ua.ithillel.pages.ProductsPage;

import java.util.List;

public class ProductsTest extends BaseTest{

    @Test
    @DisplayName("Verify All Products Are Present Test")
    @Tag("Regression")
    public void verifyAllProductsPresentTest() throws MalformedURLException {
        User testUser = UserCreator.createStandartUser();

        ProductsPage productsPage = new LoginPage()
                .openPage()
                .setUsername(testUser.getUsername())
                .setPassword(testUser.getPassword())
                .clickLoginButton();

        Assertions.assertFalse(productsPage.isProductItemListEmpty());
    }

    @Test
    @DisplayName("Verify All Products Sorted By Price Asc Test")
    @Tag("Regression")
    public void verifyAllProductsSortedByPriceAscTest2() throws MalformedURLException{
        User testUser = UserCreator.createStandartUser();

        List<Double> actualProductPriceList = new LoginPage()
                .openPage()
                .setUsername(testUser.getUsername())
                .setPassword(testUser.getPassword())
                .clickLoginButton()
                .filterByPriceAsc()
                .getProductPriceList();

        List<Double> expectedProductPriceList = Arrays.asList(7.99, 9.99, 15.99, 15.99, 29.99, 49.99);

        Assertions.assertEquals(actualProductPriceList, expectedProductPriceList);
    }
}
