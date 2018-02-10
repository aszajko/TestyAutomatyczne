package annotation;

import enums.AppByEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PageFinder {
    AppByEnum by() default AppByEnum.UNSET;
    String using() default "";
}
