package web.home;

import base.BasePage;
import org.openqa.selenium.By;


public class HomePage extends BasePage {
    private static final String URL_PAGE  = "http://automationpractice.com";

    private static final By SIGN_IN_BUTTON = By.cssSelector(".login");
    private static final By CONTACT_BUTTON  = By.cssSelector("#contact-link");
    private static final By Search = By.id("search_query_top");
    private By buttonSearch = By.name("submit_search");

    public static HomePage openByURL() {
        openByUrl(URL_PAGE);
        return new HomePage();
    }

    public void przejdzDoStronyLogowania(){
        click(SIGN_IN_BUTTON);
    }

    public void przejdzDoStronyKontaktowej() {
        click(CONTACT_BUTTON);
    }

    public void wyszukaj(String text) {
        input(Search, text);
        click(buttonSearch);
    }
}
