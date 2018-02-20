package base.page;

import app.content.AppContent;
import app.loader.PageLoader;
import org.openqa.selenium.By;



public abstract class BasePage extends AppContent {

    public BasePage(){
    }

    protected static  <T extends BasePage> T loadPageByUrl(Class<T> tClass) {
       return PageLoader.loadPageByUrl(tClass);
    }

    protected  <T extends BasePage> T loadPage(Class<T> tClass) {
        return PageLoader.loadPage(tClass);
    }

    protected void input(By by, String text) {
        findElement(by).sendKeys(text);
    }

}
