package app.utlis;

import app.AppInitializer;
import app.driverManager.DriverManager;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class WaitUtils {

    private static WebDriver driver = DriverManager.getDriver();

    @Getter
    private static WebDriverWait wait = create();

    public static void waitUntil(ExpectedCondition expectedCondition) {
        wait.until(expectedCondition);
    }

    public static void sleep(int second) {
        wait.withTimeout(second, TimeUnit.SECONDS);
    }

   @NotNull private static WebDriverWait create() {
        AppInitializer appInit = new AppInitializer();
        return new WebDriverWait(driver, appInit.getTimeOutWait());
    }

}
