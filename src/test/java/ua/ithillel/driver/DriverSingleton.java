package ua.ithillel.driver;

import org.openqa.selenium.WebDriver;
import ua.ithillel.driver.factory.LocalWebDriverFactory;

import java.net.MalformedURLException;

public class DriverSingleton {

    private static DriverSingleton instance;

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static DriverSingleton getInstance() {
        if (instance == null) {
            return new DriverSingleton();
        }
        return instance;
    }

    public static WebDriver getDriver() throws MalformedURLException {
        if (null == driver) {
            driver = WebDriverRemote.getRemoteDriver(WebDriverType.CHROME);
        }
        return driver;
    }

    public static void clearDriver() {
        getInstance().driver = null;
    }
}
