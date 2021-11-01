package dgroomes.algorithms.questions;

import dgroomes.algorithms.questions.QuestionAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionAnswerScannerTest {

    @Test
    public void testGetQuestions() throws Exception {
        Collection<Class<?>> questionAnswers = QuestionAnalyzer.getQuestionAnswers();
        assertThat(questionAnswers).isNotEmpty();
    }
}
