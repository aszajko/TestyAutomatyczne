package web.page.home;

import base.page.BasePage;
import org.openqa.selenium.By;
import web.page.contact.ContactPage;
import web.page.login.LoginPage;


public class HomePage extends BasePage {

    private static final By SIGN_IN_BUTTON = By.cssSelector(".login");
    private static final By CONTACT_BUTTON  = By.cssSelector("#contact-link");
    private static final By Search = By.id("search_query_top");
    private By buttonSearch = By.name("submit_search");

    public static HomePage openByURL() {
        return loadPageByUrl(HomePage.class);
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
}
