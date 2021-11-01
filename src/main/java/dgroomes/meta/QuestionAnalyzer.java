package dgroomes.meta;

import io.github.classgraph.ClassGraph;

import java.util.Collection;

/**
 * Analyze the range of algorithm questions that have been answered in this codebase.
 * <p>
 * The analysis process uses classpath scanning to find classes with a special annotation.
 */
public class QuestionAnalyzer {

    public static void main(String[] args) throws Exception {
        printQuestionAnswers();
    }

    /**
     * Scan for all classes annotated with {@link QuestionAnswer}
     */
    public static Collection<Class<?>> getQuestionAnswers() {
        return new ClassGraph()
                .acceptPackages("dgroomes")
                .enableAnnotationInfo()
                .scan()
                .getClassesWithAnnotation(QuestionAnswer.class)
                .loadClasses();
    }

    public static void printQuestionAnswers() throws Exception {
        getQuestionAnswers().stream().forEach(clazz -> {
            QuestionAnswer questionAnswer = clazz.getAnnotation(QuestionAnswer.class);
            System.out.println("Class: " + clazz.getSimpleName() + ". Chapter: " + questionAnswer.chapter() + ". Question: " + questionAnswer.question() + ". Attempt: " + questionAnswer.attempt());
        });
    }
}
