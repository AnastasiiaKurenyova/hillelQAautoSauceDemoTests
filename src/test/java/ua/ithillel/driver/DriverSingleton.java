package ua.ithillel.driver;

import org.openqa.selenium.WebDriver;
import ua.ithillel.driver.factory.LocalWebDriverFactory;

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

    public static WebDriver getDriver() {
        if (null == driver) {
            LocalWebDriverFactory localWebDriverFactory = new LocalWebDriverFactory();
            driver = localWebDriverFactory.getDriver(WebDriverType.CHROME);
        }
        return driver;
    }

    public static void clearDriver() {
        getInstance().driver = null;
    }
}
