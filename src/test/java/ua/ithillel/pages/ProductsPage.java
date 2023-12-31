package ua.ithillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ua.ithillel.waiters.WaiterHelper;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement productsLabel;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> productsElementList;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPriceList;

    @FindBy(xpath = "//div[@class='pricebar']/button")
    private List<WebElement> productAddButtons;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement filterDropdown;

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    private WebElement cartButton;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement burgerMenuButton;

    public ProductsPage() throws MalformedURLException{
        PageFactory.initElements(driver, this);
    }

    public String getProductsLabelText() {
        WaiterHelper.waitForVisibilityOf(driver, productsLabel);
        return productsLabel.getText();
    }

    public List<ProductItem> getProductItemList() throws MalformedURLException {
        List<ProductItem> productItemList = new ArrayList<>();

        for (int i = 0; i < productsElementList.size(); i++) {
            ProductItem productItem = new ProductItem(productsElementList.get(i));
            productItemList.add(productItem);
        }
        return productItemList;
    }

    public List<Double> getProductPriceList() throws MalformedURLException{
        List<Double> productPriceListDouble = new ArrayList<>();
        List<ProductItem> productItemList = getProductItemList();

        for (int i = 0; i < productItemList.size(); i++) {
            double productPrice = productItemList.get(i).getPrice();
            productPriceListDouble.add(productPrice);
        }
        return productPriceListDouble;
    }

    public boolean isProductItemListEmpty() throws MalformedURLException{
        List<ProductItem> productItemList = getProductItemList();
        return !(productItemList.size() > 0);
    }

    public ProductsPage filterByPriceAsc() {
        WaiterHelper.waitForVisibilityOf(driver, filterDropdown);
        Select select = new Select(filterDropdown);
        select.selectByValue("lohi");
        return this;
    }

    public ProductsPage addProductToCart(int productNumber) {
        WaiterHelper.waitForVisibilityOf(driver, productAddButtons.get(productNumber)).click();
        return this;
    }

    public CartPage clickCartButton() throws MalformedURLException{
        WaiterHelper.waitForVisibilityOf(driver, cartButton).click();
        return new CartPage();
    }

    public BurgerMenuPage clickBurgerMenuButton() throws MalformedURLException{
        WaiterHelper.waitForVisibilityOf(driver, burgerMenuButton).click();
        return new BurgerMenuPage();
    }
}
