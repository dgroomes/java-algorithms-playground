package dgroomes.questions;

import dgroomes.meta.QuestionAnswer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dgroomes.TestCase.test;

@QuestionAnswer(chapter = 1, question = 1)
public class Q_1_1 {

    public static void main(String[] args) {
        new Q_1_1().question_1_1_v_1();
    }

    public void question_1_1_v_1() {
        var testCases = List.of(
                test("a", true),
                test("ab", true),
                test("ba", true),
                test("aa", false),
                test("", true));
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
