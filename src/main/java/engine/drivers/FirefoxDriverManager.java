package engine.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static engine.property.manager.PropertyManager.PropertyKeys.FIREFOX_DRIVER;
import static engine.property.manager.PropertyManager.getProperty;
import static engine.property.manager.PropertyManager.setProperty;
import static enums.BrowserName.FIREFOX;

public class FirefoxDriverManager implements WebDriverInterface {

    @Override
    public void setWebDriverPath() {
        setProperty(FIREFOX.webDriverPathProperty, getProperty(FIREFOX_DRIVER));
    }

    @Override
    public WebDriver getDriver() {
        setWebDriverPath();
        return new FirefoxDriver();
    }
}