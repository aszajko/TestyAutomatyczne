package base;

import driverManager.DriverManager;
import org.testng.annotations.AfterClass;
import org.junit.BeforeClass;

public class FunTest {

    @BeforeClass
    public void setUp(){
    }

    @AfterClass
    public void closeDown() {
        DriverManager.getDriver().close();
    }


}
