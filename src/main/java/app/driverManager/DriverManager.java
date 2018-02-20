package app.driverManager;

import app.AppInitializer;
import lombok.Getter;
import org.openqa.selenium.WebDriver;


public class DriverManager {

    @Getter
    private static WebDriver driver;

    public static WebDriver initDriver() {
        AppInitializer appInit = new AppInitializer();
        driver = appInit.getBrowser().getInstanceDriver();
        return driver;
    }
}
