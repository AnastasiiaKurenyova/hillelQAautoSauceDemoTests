package ua.ithillel.driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ua.ithillel.driver.WebDriverType;

public class EdgeDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver getDriver(WebDriverType webDriverType) {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
