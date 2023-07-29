package ua.ithillel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.ithillel.waiters.WaiterHelper;

import java.net.MalformedURLException;

public class LoginPage extends BasePage{

    public final String HOMEPAGE = "https://www.saucedemo.com";

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement errorPopup;

    public LoginPage() throws MalformedURLException {
        PageFactory.initElements(driver, this);
    }

    public LoginPage openPage() {
        driver.get(HOMEPAGE);
        return this;
    }

    public LoginPage setUsername(String username) {
        WaiterHelper.waitForVisibilityOf(driver, usernameInput).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        WaiterHelper.waitForVisibilityOf(driver, passwordInput).sendKeys(password);
        return this;
    }

    public boolean isLoginPageVisible() {
        return WaiterHelper.waitForVisibilityOf(driver, loginButton).isDisplayed();
    }

    public String getErrorPopupText() {
        WaiterHelper.waitForVisibilityOf(driver, errorPopup);
        return errorPopup.getText();
    }

    public ProductsPage clickLoginButton() throws MalformedURLException{
        WaiterHelper.waitForVisibilityOf(driver, loginButton).click();
        return new ProductsPage();
    }
}
