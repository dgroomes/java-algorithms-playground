package dgroomes.meta;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by David Groomes on 2/21/2016.
 *
 * Scans for all programming questions annotated with @?
 */
public class QuestionAnalyzer {

    public static Collection<Class<?>> getQuestionAnswers() throws IOException {
        ImmutableSet<ClassPath.ClassInfo> applicationClasses = ClassPath.from(QuestionAnalyzer.class.getClassLoader()).getTopLevelClassesRecursive("us.mn.dgtc");
        return applicationClasses.stream()
                .map(ClassPath.ClassInfo::load)
                .filter(clazz -> clazz.isAnnotationPresent(QuestionAnswer.class))
                .collect(Collectors.toSet());
    }

    public static void printQuestionAnswers() throws Exception {
        getQuestionAnswers().stream().forEach(clazz -> {
            QuestionAnswer questionAnswer = clazz.getAnnotation(QuestionAnswer.class);
            System.out.println("Class: " + clazz.getSimpleName() + ". Chapter: " + questionAnswer.chapter() + ". Question: " + questionAnswer.question() + ". Attempt: " + questionAnswer.attempt());
        });
    }
}
