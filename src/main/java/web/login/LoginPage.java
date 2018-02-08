package web.login;

import base.BasePage;
import org.openqa.selenium.By;
import web.test.TestPage;

public class LoginPage extends BasePage {

    private static final By LOGIN__FROM  = By.id("login_form");

    public static LoginPage openByPage() {
        checkCurrentPageBy(LOGIN__FROM);
        return new LoginPage();
    }
}
