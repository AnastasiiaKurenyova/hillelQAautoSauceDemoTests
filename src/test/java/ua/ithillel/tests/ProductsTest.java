package ua.ithillel.tests;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ua.ithillel.model.Product;
import ua.ithillel.model.User;
import ua.ithillel.model.UserCreator;
import ua.ithillel.pages.LoginPage;
import ua.ithillel.pages.ProductsPage;

import java.util.List;

public class ProductsTest extends BaseTest{

    @Test
    @DisplayName("Verify All Products Are Present Test")
    @Tag("Regression")
    public void verifyAllProductsPresentTest() {
        User testUser = UserCreator.createStandartUser();

        ProductsPage productsPage = new LoginPage()
                .openPage()
                .setUsername(testUser.getUsername())
                .setPassword(testUser.getPassword())
                .clickLoginButton();

        Assertions.assertFalse(productsPage.isProductItemListEmpty());
    }

    @Test
    @DisplayName("Verify All Products Sorted By Price Test - using Product Page Elem")
    @Tag("Regression")
    public void verifyAllProductsSortedByPriceAscTest1() {
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

    @Test
    @DisplayName("Verify All Products Sorted By Price Test - using Product Item Elem")
    @Tag("Regression")
    public void verifyAllProductsSortedByPriceAscTest2() {
        User testUser = UserCreator.createStandartUser();

        List<Product> actualProductList = new LoginPage()
                .openPage()
                .setUsername(testUser.getUsername())
                .setPassword(testUser.getPassword())
                .clickLoginButton()
                .filterByPriceAsc()
                .getProductList();

        List<Double> actualProductPriceList = Product.getPriceList(actualProductList);

        List<Double> expectedProductPriceList = Arrays.asList(7.99, 9.99, 15.99, 15.99, 29.99, 49.99);

        Assertions.assertEquals(actualProductPriceList, expectedProductPriceList);
    }
}