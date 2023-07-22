package ua.ithillel.pages;

import org.openqa.selenium.WebDriver;
import ua.ithillel.driver.DriverSingleton;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverSingleton.getDriver();
    }
}
