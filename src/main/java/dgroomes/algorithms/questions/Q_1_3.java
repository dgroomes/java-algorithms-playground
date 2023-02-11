package dgroomes.algorithms.questions;

import java.util.List;
import java.util.stream.Collectors;

import static dgroomes.TerminalUtil.bold;
import static dgroomes.TerminalUtil.reset;
import static dgroomes.testing.TestCase.test;
import static java.lang.System.out;

public class Q_1_3 {

    public static void main(String[] args) {
        bold(); out.println("Question 1.3"); reset();

        execute(V1);
        execute(V2);

        out.println("\n");
    }

    /**
     * Are two strings permutations of each other? For example, "acb" is a permutation of "cab".
     */
    @FunctionalInterface
    interface IsPermutation {
        boolean isPermutation(String a, String b);
    }

    public static void execute(IsPermutation algorithm) {
        var testCases = List.of(
                test("baa", true),
                test("aba", true),
                test("a", false));
        out.println("testing: isAPermutationOfB");
        out.println("input string|expected result|actual result");
        testCases.forEach(testCase -> {
            boolean foundResult = algorithm.isPermutation("baa", testCase.input());
            out.println(testCase.input() + "|" + testCase.expectedResult() + "|" + foundResult);
        });
    }

    static IsPermutation V1 = new IsPermutation() {
        @Override
        public boolean isPermutation(String a, String b) {
            return sortIntoCharacters(a).equals(sortIntoCharacters(b));
        }

        private List<Character> sortIntoCharacters(String s) {
            return s.chars().mapToObj(i -> (char) i).sorted().collect(Collectors.toList());
        }
    };

    // An alternative implementation
    static IsPermutation V2 = new IsPermutation() {

        @Override
        public boolean isPermutation(String a, String b) {
            return sortIntoCharacters2(a).equals(sortIntoCharacters2(b));
        }

        private List<Integer> sortIntoCharacters2(String s) {
            return s.chars().sorted().boxed().collect(Collectors.toList());
        }
    };
}
