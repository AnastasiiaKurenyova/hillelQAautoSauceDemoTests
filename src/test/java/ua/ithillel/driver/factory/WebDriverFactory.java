package ua.ithillel.driver.factory;

import org.openqa.selenium.WebDriver;
import ua.ithillel.driver.WebDriverType;

public interface WebDriverFactory {

    WebDriver getDriver(WebDriverType webDriverType);
}
