package utlis;

import annotation.AppBy;
import annotation.PageFinder;
import enums.AppByEnum;
import org.openqa.selenium.By;

import java.lang.annotation.Annotation;

public class FindByUtils {

    public static By buildBy(Annotation appBy) {
        if(appBy instanceof AppBy) {
          AppBy  by = (AppBy) appBy;
          return createByAppBy(by);
        }
        if(appBy instanceof PageFinder) {
            PageFinder by = (PageFinder) appBy;
            return createByPageFinder(by);
        }
        else {
            throw new RuntimeException("This annatotion : " + appBy + "not creating By");
        }
    }

    private static By createByPageFinder(PageFinder appBy) {
        AppByEnum byEnum = appBy.by();
        String use = appBy.using();
        return getBy(byEnum,use);
    }

    private static By createByAppBy(AppBy appBy) {
        AppByEnum byEnum = appBy.by();
        String use = appBy.using();
        return getBy(byEnum,use);
    }

    private static By getBy(AppByEnum byEnum, String use) {
        switch (byEnum) {
            case ID:
            case UNSET:
                return By.id(use);
            case CSS:
                return By.cssSelector(use);
            case NAME:
                return By.name(use);
            case XPATH:
                return By.xpath(use);
            default:
                throw new RuntimeException("Cannot determine how to find By");
        }
    }
}
