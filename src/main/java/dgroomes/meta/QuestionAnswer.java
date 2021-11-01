package dgroomes.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is a class-level annotation that should be added to answer attempts to algorithm programming questions.
 * As the codebase grows, its useful to be able to programmatically describe the full range of questions and answers.
 * Plus, it's just fun to play with annotations.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface QuestionAnswer {
    int chapter();

    int question();

    int attempt() default 1;
}
