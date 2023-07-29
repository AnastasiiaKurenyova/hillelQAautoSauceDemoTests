package ua.ithillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
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

    private WebElement parentElement;

    private double price;

    public ProductItem(WebElement parentElement)throws MalformedURLException {
        PageFactory.initElements(parentElement, this);
        this.parentElement = parentElement;
        this.price = getPriceFromElementText(parentElement.getText());
    }

    public double getPrice() {
        return price;
    }

    public static double getPriceFromElementText(String text) {
        double result = -1;
        Pattern pattern = Pattern.compile("[$]{1}[\\d]+.[\\d]+");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            result = Double.parseDouble(matcher.group().substring(1));
        }
        return result;
    }
}
