package ua.ithillel.driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.ithillel.driver.WebDriverType;

public class ChromeDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver getDriver(WebDriverType webDriverType) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
