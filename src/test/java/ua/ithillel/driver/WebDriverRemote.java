package ua.ithillel.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class WebDriverRemote {

    public static RemoteWebDriver getRemoteDriver(WebDriverType webDriverType) throws MalformedURLException {
        RemoteWebDriver driver;
        switch (webDriverType) {
            case FIREFOX -> driver = getRemoteFirefoxDriver();
            case EDGE -> driver = getRemoteEdgeDriver();
            default -> driver = getRemoteChromeDriver();
        }
        return driver;
    }

    public static RemoteWebDriver getRemoteChromeDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "114.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable vnc */
            put("enableVNC", true);
        }});
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    public static RemoteWebDriver getRemoteFirefoxDriver() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserVersion", "114.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable vnc */
            put("enableVNC", true);
        }});
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }

    public static RemoteWebDriver getRemoteEdgeDriver() throws MalformedURLException {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("browserVersion", "114.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");

            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable vnc */
            put("enableVNC", true);
        }});
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }
}
