package app.enums;

import app.AppProperties;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;


public enum AppBrowser  {

    FIREFOX() {
        @Override
        public WebDriver getInstanceDriver() {
            Properties properties = getProperties().getFireFoxProperties();
            String key =  properties.getProperty("driver.firefox");
            String location = properties.getProperty("driver.firefox.location");
            System.setProperty(key,location);

           return new FirefoxDriver();
        }
    },
    CHROME() {
        @Override
        public WebDriver getInstanceDriver() {
            Properties properties = getProperties().getChromeProperties();
            String key =  properties.getProperty("driver.chrome");
            String location = properties.getProperty("driver.chrome.location");
            System.setProperty(key,location);

            return new ChromeDriver(getProperties().getChromeOptionFromProperties());
        }
    };

    @Getter
    private AppProperties properties = new AppProperties();

    public abstract WebDriver getInstanceDriver();

}
