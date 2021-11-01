package dgroomes.meta;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Groomes on 2/21/2016.
 */
public class QuestionAnswerScannerTest {

    @Ignore
    @Test
    public void testGetQuestions() throws Exception {
        Collection<Class<?>> questionAnswers = QuestionAnalyzer.getQuestionAnswers();
        assertThat(questionAnswers).isNotEmpty();
    }
}
