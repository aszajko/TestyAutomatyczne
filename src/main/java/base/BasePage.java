package base;

import annotation.AppFindBy;
import driverManager.DriverManager;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.test.TestPage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 *  Rodzic wszystkich klas page
 */
public abstract class BasePage {
    /**
     * Zmienna przechowująca obiekt driwera
     */
    @Getter
    private static WebDriver driver = DriverManager.getDriver();
    @Getter
    private static WebDriverWait wait;

    protected static void openByUrl(String url) {
         driver.get(url);
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
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    protected void input(By by, String text) {
        findElement(by).sendKeys(text);
    }


    protected static <T extends BasePage> T loadPage(Class<T> tClass) {
        T page;
        try {
            page = tClass.newInstance();

        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        invokeBy(page);
        return page;
    }

    private static <T extends BasePage> void invokeBy(T page) {

        for (Field field : page.getClass().getDeclaredFields()) {

            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {

                if (annotation instanceof AppFindBy) {
                    AppFindBy appFindBy = field.getAnnotation(AppFindBy.class);
                    boolean accessible = field.isAccessible();
                    try {
                        field.setAccessible(true);
                        field.set(page, AppFindBy.AppFindByBuilder.getBy(appFindBy));
                        field.setAccessible(accessible);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
