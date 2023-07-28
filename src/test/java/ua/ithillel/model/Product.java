package ua.ithillel.model;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String productPicture;
    private String productLabel;
    private String productDescription;
    private double productPrice;

    public Product(String productPicture, String productLabel, String productDescription, double productPrice) {
        this.productPicture = productPicture;
        this.productLabel = productLabel;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public static List<Double> getPriceList(List<Product> productList) {
        List<Double> priceList = new ArrayList<>();
        for (Product product: productList) {
            priceList.add(product.getProductPrice());
        }
        return priceList;
    }
}
