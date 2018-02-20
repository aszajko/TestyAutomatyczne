package app.content;

import app.driverManager.DriverManager;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

abstract public class AppContent {

    @Getter
    private WebDriver driver = DriverManager.getDriver();

    private By by;
    private WebElement element;
    private AppContent content;

    protected AppContent() {
    }

    protected AppContent(AppContent content,By by) {
        this.content = content;
        this.by = by;
    }

    protected AppContent(AppContent content, WebElement element) {
        this.content = content;
        this.element = element;
    }

    protected WebElement findElement(By by) {
       if(content == null) {
          return driver.findElement(by);
       }
       return  element != null ? element.findElement(by) : getByElement().findElement(by);
    }

    protected List<WebElement> findElements(By by) {
        if(content == null) {
            return driver.findElements(by);
        }
        return  element != null ? element.findElements(by) : getByElement().findElements(by);
    }

    private WebElement getByElement() {
        return content.findElement(by);
    }
}
