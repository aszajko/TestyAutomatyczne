package web.home;

import base.BasePage;
import org.openqa.selenium.By;
import web.contact.ContactPage;
import web.login.LoginPage;


public class HomePage extends BasePage {

    private static final String URL_PAGE  = "http://automationpractice.com";

    private static final By SIGN_IN_BUTTON = By.cssSelector(".login");
    private static final By CONTACT_BUTTON  = By.cssSelector("#contact-link");
    private static final By Search = By.id("search_query_top");
    private By buttonSearch = By.name("submit_search");

    public static HomePage openByURL() {
        openByUrl(URL_PAGE);
        return loadPage(HomePage.class);
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
