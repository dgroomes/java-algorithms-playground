package us.mn.dgtc.questions;

import us.mn.dgtc.TestCase;
import us.mn.dgtc.meta.QuestionAnswer;

import javax.xml.stream.events.Characters;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

@QuestionAnswer(chapter = 1, question = 1)
public class Q_1_1 {
    public void question_1_1_v_1() {
        List<TestCase<String>> testCases = new ArrayList<>();
        testCases.add(new TestCase<>("a", true));
        testCases.add(new TestCase<>("ab", true));
        testCases.add(new TestCase<>("ba", true));
        testCases.add(new TestCase<>("aa", false));
        testCases.add(new TestCase<>("", true));
        System.out.println("testing: charsAreAllUnique_v_1");
        System.out.println("input string|expected result|actual result");
        testCases.forEach(testCase -> {
            boolean actualResult = charsAreAllUnique_v_2(testCase.input());
            System.out.println(testCase.input() + "|" + testCase.expectedResult() + "|" + actualResult);
        });
    }

    public boolean charsAreAllUnique_v_1(String string) {
        final Set<Integer> charSet = new HashSet<>();
        boolean foundARepeat = string.chars().anyMatch(i -> !charSet.add(i)); // this is ill advised
        return !foundARepeat;
    }

    /**
     * pre-java 8 solution a.k.a. boring solution
     * ... this might be better
     */
    public boolean charsAreAllUnique_v_2(String string) {
        Set<Character> seenCharacters = new HashSet<>();
        for (char aChar : string.toCharArray()) {
            if (seenCharacters.contains(aChar)) {
                return false;
            } else {
                seenCharacters.add(aChar);
            }
        }
        return true;
    }
}