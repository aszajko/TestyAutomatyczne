package app.annotation;

import app.enums.AppByEnum;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface AppBy {
    AppByEnum by() default AppByEnum.UNSET;
    String using() default "";
}
