package base;

import driverManager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 *  Rodzic wszystkich klas page
 */
public abstract class BasePage {

    /**
     * Zmienna przechowująca obiekt driwera
     */
    private static WebDriver driver = DriverManager.getDriver();
    private static WebDriverWait wait;


    protected static void openByUrl(String url) {
         driver.get(url);
    }

    protected static WebDriverWait getWait() {
        return wait;
    }

    protected static void checkCurrentPageBy(By... bys){
        for (By by: bys) {
            wait.until(ExpectedConditions.visibilityOf(findElement(by)));
        }

    }

    protected static WebElement findElement(By by) {
        return driver.findElement(by);
    }

    /**
     * Konsntruktor Twojej klasy 'BasePage'
     */
    public BasePage(){
        wait = new WebDriverWait(driver, 10 );
    }
    /**
     * Metoda hermetyzująca mechanizm znajdowania elementu na stronie
     * @param by Parametr na podstawie którego znajduje szukany element na stronie
     * @return WebElement - typ zwracany przez tą metodę.
     */


    protected List<WebElement> findElemnets(By by) {
        return driver.findElements(by);
    }

    protected void click(By by) {
        findElement(by).click();
    }

    protected void input(By by, String text) {
        findElement(by).sendKeys(text);
    }



}
