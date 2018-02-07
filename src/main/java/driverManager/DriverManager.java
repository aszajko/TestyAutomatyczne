package driverManager;

import config.PropertiesDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            return driver = initFireFoxDriver();
        }

        return driver;
    }

    private static WebDriver initDriver() {
        System.setProperty(PropertiesDriver.CHROME_DRIVER_PROPERTY,
                           PropertiesDriver.CHROME_DRIVER_LOCATION);

        ChromeOptions options = new ChromeOptions();
        options.addArguments(PropertiesDriver.CHROME_DRIVER_DISABLE_INFOBARS,
                             PropertiesDriver.CHROME_OPTIONS_ENABLE_AUTOMATION);

        return driver = new ChromeDriver(options);
    }

    private static WebDriver initFireFoxDriver() {
        System.setProperty(PropertiesDriver.FIREFOX_DRIVER_PROPERTY,
                            PropertiesDriver.FIREFOX_DRIVER_LOCATION);

        return driver = new FirefoxDriver();
        }
}
