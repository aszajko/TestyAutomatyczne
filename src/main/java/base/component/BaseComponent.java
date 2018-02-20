package base.component;

import app.content.AppContent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseComponent<T extends AppContent> extends AppContent {

    private T content;

    protected BaseComponent(AppContent content, By by) {
        super(content, by);
        this.content = (T) content;
    }

    protected BaseComponent(AppContent content, WebElement element) {
        super(content, element);
    }

    protected T getContent() {
        return  content;
    }
}
