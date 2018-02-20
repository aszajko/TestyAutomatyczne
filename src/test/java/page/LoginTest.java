package page;

import base.FunTest;
import org.testng.annotations.Test;
import web.page.home.HomePage;
import web.page.login.LoginPage;

public class LoginTest extends FunTest {

    @Test
    public void loginSuccessfulTest(String name, String pass) {

       HomePage homePage = HomePage.openByURL();
       LoginPage loginPage = homePage.przejdzDoStronyLogowania();
//        loginPage.logIn(name, pass);

//        Assert.assertNull(loginPage.getErrorMassage());
    }

    @Test
    public void loginFailTestByWrongData (String name, String pass) {
       HomePage homePage = HomePage.openByURL();
       LoginPage loginPage = homePage.przejdzDoStronyLogowania();
//        loginPage.logIn(name,pass);

//        org.testng.Assert.assertEquals(loginPage.getErrorMassage() ,
//                ErrorPageMassage.key("wrong login data"));
    }

    @Test
    public void loginFailTestByOnlyEmail (String name, String pass) {
      HomePage  homePage = HomePage.openByURL();
      homePage.wyszukaj("Text");
//        loginPage.logIn(name,pass);
//
//        org.testng.Assert.assertEquals(loginPage.getErrorMassage(),
//                ErrorPageMassage.key("empty login"));
    }
}
