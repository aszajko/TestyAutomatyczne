package annotation;

import enums.AppByEnum;
import org.openqa.selenium.By;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface AppFindBy {

    AppByEnum by() default AppByEnum.UNSET;
    String using() default "";


    class AppFindByBuilder {
        public AppFindByBuilder() {
        }

        public static By getBy(Object annotation) {
            AppFindBy appBy = (AppFindBy) annotation;
            return buildBy(appBy);
        }

        private static By buildBy(AppFindBy appBy) {
            AppByEnum byEnum = appBy.by();
            String use = appBy.using();
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
}
