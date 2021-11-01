package dgroomes.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by David Groomes on 2/21/2016.
 *
 * Answer attempts to programming questions must be annotated with this, to describe which question they are answering.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface QuestionAnswer {
    int chapter();
    int question();
    int attempt() default 1;
}
