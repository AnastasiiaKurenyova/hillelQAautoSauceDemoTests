package ua.ithillel.driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.ithillel.driver.WebDriverType;

public class FirefoxDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver getDriver(WebDriverType webDriverType) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
