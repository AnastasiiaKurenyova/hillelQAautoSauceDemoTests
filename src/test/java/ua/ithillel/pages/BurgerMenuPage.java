package ua.ithillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.ithillel.waiters.WaiterHelper;

import java.net.MalformedURLException;

public class BurgerMenuPage extends BasePage {

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutButton;

    public BurgerMenuPage() throws MalformedURLException {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLogoutButton() throws MalformedURLException{
        WaiterHelper.waitForVisibilityOf(driver, logoutButton).click();
        return new LoginPage();
    }
}
