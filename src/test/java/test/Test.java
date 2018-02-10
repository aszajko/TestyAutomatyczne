package test;

import base.FunTest;
import web.login.LoginPage;
import web.test.TestPage;

public class Test extends FunTest {

    private TestPage testPage;
    private LoginPage loginPage;

    @org.testng.annotations.Test
    public void loginSuccessfulTest() {
        testPage = TestPage.openByURL();
        testPage.przejdzDoStronyLogowania();
        loginPage = LoginPage.openByPage();
    }

    @org.testng.annotations.Test
    public void loginFailTestByWrongData () {
        testPage = TestPage.openByURL();
        testPage.przejdzDoStronyKontaktowej();
    }

    @org.testng.annotations.Test
    public void loginFailTestByOnlyEmail () {
        testPage = TestPage.openByURL();
        testPage.wyszukaj("Text");
    }
}
