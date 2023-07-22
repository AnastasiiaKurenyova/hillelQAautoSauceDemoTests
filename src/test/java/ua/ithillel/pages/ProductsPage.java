package ua.ithillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.ithillel.waiters.WaiterHelper;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement productsLabel;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getProductsText() {
        WaiterHelper.waitForVisibilityOf(driver, productsLabel);
        return productsLabel.getText();
    }
}
