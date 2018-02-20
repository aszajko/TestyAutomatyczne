package test;

import base.FunTest;
import org.testng.annotations.Test;
import web.page.login.LoginPage;
import web.page.test.TestHomePage;

import static org.assertj.core.api.Assertions.*;

@Test
public class Test1 extends FunTest {

    private TestHomePage testHomePage;
    private LoginPage loginPage;

    public void loginSuccessfulTest() {
        testHomePage = TestHomePage.openByURL();
        loginPage = testHomePage.przejdzDoStronyLogowania();

        assertThat(testHomePage.isTrue())
                .isTrue()
                .as("Poprawnie działająca assercja");
    }

    public void loginFailTestByWrongData () {
        testHomePage = TestHomePage.openByURL();
        testHomePage.przejdzDoStronyKontaktowej();
    }

    public void loginFailTestByOnlyEmail () {
        testHomePage = TestHomePage.openByURL();
        testHomePage.wyszukaj("Text");
    }
}
