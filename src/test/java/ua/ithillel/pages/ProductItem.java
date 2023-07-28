package ua.ithillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.ithillel.model.Product;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductItem extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_item_img']")
    private WebElement productPicture;

    @FindBy(xpath = "//div[@class='inventory_item_label']")
    private WebElement productLabel;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    private WebElement productDescription;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='pricebar']/button")
    private WebElement productAddButton;

    public ProductItem(WebElement productElement) {
        PageFactory.initElements(productElement, this);
    }

    public Product getProduct() {
        return new Product(
                productPicture.getText(),
                productLabel.getText(),
                productDescription.getText(),
                getPriceFromElement(productPrice)
        );
    }

    public double getPrice() {
        return getPriceFromElement(productPrice);
    }

    public ProductItem clickAddButton() {
        productAddButton.click();
        return this;
    }

    public static double getPriceFromElement(WebElement element) {
        double result = -1;
        Pattern pattern = Pattern.compile("[\\d]+.[\\d]+");
        Matcher matcher = pattern.matcher(element.getText());

        if (matcher.find()) {
            result = Double.parseDouble(matcher.group());
        }
        return result;
    }

}
