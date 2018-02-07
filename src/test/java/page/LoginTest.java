package page;

import base.FunTest;
import org.testng.annotations.Test;
import web.home.HomePage;
import web.login.LoginPage;

public class LoginTest extends FunTest {

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void loginSuccessfulTest() {
        homePage = HomePage.openByURL();
        homePage.przejdzDoStronyLogowania();
        loginPage = LoginPage.openByPage();

    }

    @Test
    public void loginFailTestByWrongData () {
        homePage = HomePage.openByURL();
        homePage.przejdzDoStronyKontaktowej();
    }
    @Test
    public void loginFailTestByOnlyEmail () {
        homePage = HomePage.openByURL();
        homePage.wyszukaj("Text");
    }
}
