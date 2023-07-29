package ua.ithillel.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ua.ithillel.driver.DriverSingleton;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void browserSetup() throws MalformedURLException {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    public void browserTearDown() {
        driver.quit();
        DriverSingleton.clearDriver();
    }
}
