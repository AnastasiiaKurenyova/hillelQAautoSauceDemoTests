package ua.ithillel.driver.factory;

import org.openqa.selenium.WebDriver;
import ua.ithillel.driver.WebDriverType;

public class LocalWebDriverFactory implements WebDriverFactory {
    private final WebDriverFactory firefoxDriverFactory = new FirefoxDriverFactory();
    private final WebDriverFactory chromeDriverFactory = new ChromeDriverFactory();
    private final WebDriverFactory edgeDriverFactory = new EdgeDriverFactory();

    @Override
    public WebDriver getDriver(WebDriverType webDriverType) {
        WebDriverFactory webDriverFactory;
        switch (webDriverType) {
            case FIREFOX -> webDriverFactory = firefoxDriverFactory;
            case EDGE -> webDriverFactory = edgeDriverFactory;
            default -> webDriverFactory = chromeDriverFactory;
        }
        return webDriverFactory.getDriver(webDriverType);
    }
}
