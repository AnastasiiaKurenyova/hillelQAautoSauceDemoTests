package ua.ithillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.ithillel.waiters.WaiterHelper;

public class BurgerMenuPage extends BasePage {

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutButton;

    public BurgerMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLogoutButton() {
        WaiterHelper.waitForVisibilityOf(driver, logoutButton).click();
        return new LoginPage();
    }
}
