package dgroomes.algorithms.questions;

import dgroomes.testing.TestCase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dgroomes.TerminalUtil.bold;
import static dgroomes.TerminalUtil.reset;
import static java.lang.System.out;

public class Q_1_1 {

    public static void main(String[] args) {
        bold(); out.println("Question 1.1"); reset();

        test(CLEVER);
        test(SIMPLE);

        out.println("\n");
    }

    /**
     * Check if a given string contains only unique characters (i.e. no duplicates).
     */
    @FunctionalInterface
    interface CharsAreAllUnique {
        boolean charsAreAllUnique(String input);
    }

    public static void test(CharsAreAllUnique algorithm) {
        var testCases = List.of(
                TestCase.test("a", true),
                TestCase.test("ab", true),
                TestCase.test("ba", true),
                TestCase.test("aa", false),
                TestCase.test("", true));
        out.println("testing: charsAreAllUnique_v_1");
        out.println("input string|expected result|actual result");
        testCases.forEach(testCase -> {
            boolean actualResult = algorithm.charsAreAllUnique(testCase.input());
            out.println(testCase.input() + "|" + testCase.expectedResult() + "|" + actualResult);
        });
    }

    // A implementation of the "characters are all unique?" algorithm which is too clever.
    static CharsAreAllUnique CLEVER = input -> {
        var charSet = new HashSet<>();
        boolean foundARepeat = input.chars().anyMatch(i -> !charSet.add(i)); // this is ill advised
        return !foundARepeat;
    };

    /**
     * A no-frills implementation of the "characters are all unique?" algorithm. This is what a solution would like
     * before Java 8 when there was no option to use the Java Streams API. After Java 8, a software developer might be
     * tempted to use the Streams API to implement this algorithm. In my opinion, the below implementation is best.
     */
    static CharsAreAllUnique SIMPLE = string -> {
        Set<Character> seenCharacters = new HashSet<>();
        for (var aChar : string.toCharArray()) {
            if (seenCharacters.contains(aChar)) {
                return false;
            } else {
                seenCharacters.add(aChar);
            }
        }
        return true;
    };
}
