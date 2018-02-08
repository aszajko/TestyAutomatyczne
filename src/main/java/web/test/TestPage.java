package web.test;

import annotation.AppFindBy;
import base.BasePage;
import enums.AppByEnum;
import org.openqa.selenium.By;

public class TestPage extends BasePage {

    @AppFindBy(by = AppByEnum.ID, using = "name")
    public By button1;

    @AppFindBy(by = AppByEnum.NAME, using = "name")
    public By button2;

    public TestPage loadPage() {
    return  loadPage(TestPage.class);
    }



}
