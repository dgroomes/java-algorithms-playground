package dgroomes.algorithms.questions;

import java.util.List;
import java.util.stream.Collectors;

import static dgroomes.testing.TestCase.test;

@QuestionAnswer(chapter = 1, question = 3)
public class Q_1_3 {

    public static void main(String[] args) {
        new Q_1_3().v_1();
    }

    public void v_1() {
        var testCases = List.of(
                test("baa", true),
                test("aba", true),
                test("a", false));
        System.out.println("testing: isAPermutationOfB");
        System.out.println("input string|expected result|actual result");
        testCases.forEach(testCase -> {
            boolean foundResult = isAPermutationOfB("baa", testCase.input());
            System.out.println(testCase.input() + "|" + testCase.expectedResult() + "|" + foundResult);
        });
    }

    /**
     * Permutation is a combination of some things where order matters
     */
    public boolean isAPermutationOfB(String a, String b) {
        return sortIntoCharacters(a).equals(sortIntoCharacters(b));
    }

    public boolean isAPermutationOfB2(String a, String b) {
        return sortIntoCharacters2(a).equals(sortIntoCharacters2(b));
    }

    private List<Character> sortIntoCharacters(String s) {
        return s.chars().mapToObj(i -> (char) i).sorted().collect(Collectors.toList());
    }

    private List<Integer> sortIntoCharacters2(String s) {
        return s.chars().sorted().boxed().collect(Collectors.toList());
    }
}
