package base;

import app.driverManager.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FunTest {

    @BeforeTest
    public void setUp() {
        DriverManager.initDriver();
    }

    @AfterMethod
    public void clear() {
        DriverManager.getDriver().manage().deleteAllCookies();
    }

    @AfterTest
    public void closeDown() {
        DriverManager.getDriver().close();
    }


}
