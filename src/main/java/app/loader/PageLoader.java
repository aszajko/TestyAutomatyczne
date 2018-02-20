package app.loader;

import app.annotation.UrlMapping;
import app.exception.AppException;
import base.page.BasePage;
import app.driverManager.DriverManager;
import app.enums.AppUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import app.utlis.WaitUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class PageLoader {

    private static WebDriver driver = DriverManager.getDriver();
    private static WebDriverWait wait = WaitUtils.getWait();

    public static <T extends BasePage> T loadPageByUrl(Class<T> tClass) {
        UrlMapping urlMapping = tClass.getAnnotation(UrlMapping.class);
        AppUrl url = urlMapping.url();
        String param = urlMapping.p();
        openByUrl(url.buildUrl(param));
        return loadPage(tClass);
    }

    public static <T extends BasePage> T loadPage(Class<T> tClass) {
        T page;
        try {
            page = tClass.newInstance();

        } catch (InstantiationException | IllegalAccessException e) {
            throw new AppException("Brak możliwości stworzenia obkietu " + tClass ,e);
        }
        waitForPageLoaded(page);
        return page;
    }

    private static void openByUrl(String url) {
        driver.get(url);
    }

    private static <T extends BasePage> void waitForPageLoaded(T page) {
        String currentPage = "waitForPage";
        try {
            Method method = page.getClass().getMethod(currentPage, WebDriverWait.class);
            checkIsStatic(method);
            method.invoke(page,wait);
        } catch (NoSuchMethodException e) {
            throw new AppException("Brak metody "
                    + currentPage +
                    " w w klasie "
                    + page.getClass().getName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AppException(
                    " Metoda " +
                    currentPage
                    + "jest niepoprawnie zaimplementowana w klasie"
                    + page.getClass().getName());
        }
    }

    private static void checkIsStatic(Method method) {
      if(! Modifier.isStatic(method.getModifiers()) ){
          throw new AppException(method.getName() + "nie jest metodą statyczną");
      }
    }
}
