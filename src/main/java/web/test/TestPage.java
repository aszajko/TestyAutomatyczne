package web.test;

import annotation.AppBy;
import annotation.PageFinder;
import base.BasePage;
import enums.AppByEnum;
import org.openqa.selenium.By;
import web.contact.ContactPage;
import web.login.LoginPage;

@PageFinder(by = AppByEnum.CSS, using = ".login")
public class TestPage extends BasePage {

    private static final String URL_PAGE  = "http://automationpractice.com";

    @AppBy(by = AppByEnum.CSS, using = ".login")
    private By SIGN_IN_BUTTON;

    @AppBy(by = AppByEnum.CSS, using = "#contact-link")
    private By CONTACT_BUTTON;

    @AppBy(by = AppByEnum.ID, using = "search_query_top")
    private By Search;

    @AppBy(by = AppByEnum.NAME, using = "submit_search" )
    private By buttonSearch;

//    @UrlMaping("/")
    public static TestPage openByURL() {
        openByUrl(URL_PAGE);
        return loadPage(TestPage.class);
    }

    public LoginPage przejdzDoStronyLogowania(){
        click(SIGN_IN_BUTTON);
        return loadPage(LoginPage.class);
    }

    public ContactPage przejdzDoStronyKontaktowej() {
        click(CONTACT_BUTTON);
        return loadPage(ContactPage.class);
    }

    public void wyszukaj(String text) {
        input(Search, text);
        click(buttonSearch);
    }



}
