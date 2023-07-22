package ua.ithillel.driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static DriverSingleton instance;

    private WebDriver driver;

    private DriverSingleton() {
    }

    public static DriverSingleton getInstance() {
        if (instance == null) {
            return new DriverSingleton();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        return getInstance().driver;
    }

    public static void setDriver(WebDriver driver) {
        getInstance().driver = driver;
    }

    public static void clearDriver() {
        getInstance().driver = null;
    }
}
