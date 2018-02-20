package web.page.test;

import app.annotation.AppBy;
import app.annotation.UrlMapping;
import base.page.BasePage;
import app.enums.AppByEnum;
import app.enums.AppUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.page.contact.ContactPage;
import web.page.login.LoginPage;

@UrlMapping(url = AppUrl.FRONT)
public class TestHomePage extends BasePage {

    By SIGN_IN_BUTTON = By.className("login");

    @AppBy(by = AppByEnum.CSS, using = "#contact-link")
    private By CONTACT_BUTTON;

    @AppBy(by = AppByEnum.ID, using = "search_query_top")
    private By Search;

    @AppBy(by = AppByEnum.NAME, using = "submit_search" )
    private By buttonSearch;

    public static void waitForPage(WebDriverWait wait) {

    }

    public static TestHomePage openByURL() {
        return loadPageByUrl(TestHomePage.class);
    }

    public LoginPage przejdzDoStronyLogowania(){
        findElement(SIGN_IN_BUTTON).click();
        return loadPage(LoginPage.class);
    }

    public ContactPage przejdzDoStronyKontaktowej() {
        findElement(CONTACT_BUTTON).click();
        return loadPage(ContactPage.class);
    }

    public void wyszukaj(String text) {
        input(Search, text);
        findElement(buttonSearch).click();
    }

    public boolean isTrue() {
        return true;
    }

}
