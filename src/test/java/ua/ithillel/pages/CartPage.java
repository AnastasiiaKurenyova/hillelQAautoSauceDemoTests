package ua.ithillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPriceList;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public List<Double> getProductPriceList() {
        List<Double> productPriceDoubleList = new ArrayList<>();
        for (int i = 0; i < productPriceList.size(); i++) {
            double productPrice = ProductItem.getPriceFromElementText(productPriceList.get(i).getText());
            productPriceDoubleList.add(productPrice);
        }
        return productPriceDoubleList;
    }
}
