package ua.ithillel.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ua.ithillel.driver.DriverSingleton;
import ua.ithillel.driver.WebDriverType;
import ua.ithillel.driver.factory.LocalWebDriverFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void browserSetup() {
        LocalWebDriverFactory localWebDriverFactory = new LocalWebDriverFactory();
        driver = localWebDriverFactory.getDriver(WebDriverType.CHROME);
        DriverSingleton.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void browserTearDown() {
        driver.quit();
        DriverSingleton.clearDriver();
    }
}
