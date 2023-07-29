package ua.ithillel.pages;

import org.openqa.selenium.WebDriver;
import ua.ithillel.driver.DriverSingleton;

import java.net.MalformedURLException;

public class BasePage {

    protected WebDriver driver;

    public BasePage() throws MalformedURLException {
        this.driver = DriverSingleton.getDriver();
    }
}
