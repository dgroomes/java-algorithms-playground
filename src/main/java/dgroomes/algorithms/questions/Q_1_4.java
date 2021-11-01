package dgroomes.algorithms.questions;

import java.util.List;

import static dgroomes.testing.Assertions.assertThat;
import static dgroomes.testing.TestCase.test;

@QuestionAnswer(chapter = 1, question = 4)
public class Q_1_4 {

    public static void main(String[] args) {
        execute(IN_PLACE);
    }

    /**
     * A simple encoding function that replaces significant space characters with '%20'. Trailing spaces are considered
     * insignificant and are omitted in the final result.
     */
    @FunctionalInterface
    interface EncodeSpaceCharacter {
        char[] encode(char[] string);
    }

    // WARNING: These test cases fail! The algorithm is implemented incorrectly.
    public static void execute(EncodeSpaceCharacter algorithm) {
        var testCases = List.of(
                test("Single space".toCharArray(), "Single%20Space".toCharArray()),
                test("Trailing-spaces ".toCharArray(), "Trailing-spaces".toCharArray()),
                test("  Leading-spaces".toCharArray(), "Leading-spaces".toCharArray()),
                test("No-space".toCharArray(), "No-space".toCharArray()),
                test(new char[]{}, new char[]{}));

        for (var testCase : testCases) {
            assertThat(algorithm.encode(testCase.input())).isEqualTo(testCase.expectedResult());
        }
    }

    /**
     * An implementation of the encode interface that operates on the input array in place. In other words, this has a
     * side-effect! It would be worthwhile to implement an alternative implementation that does not side-effect.
     */
    static EncodeSpaceCharacter IN_PLACE = string -> {
        int finderOfIndexOfFarthestNonSpace = string.length - 1;
        int finderOfIndexOfFarthestOpen = string.length - 1;
        while (string[finderOfIndexOfFarthestNonSpace] == ' ') {
            finderOfIndexOfFarthestNonSpace--;
        }
        while (finderOfIndexOfFarthestNonSpace >= 0) {
            if (string[finderOfIndexOfFarthestNonSpace] == ' ') {
                string[finderOfIndexOfFarthestOpen] = '0';
                finderOfIndexOfFarthestOpen--;
                string[finderOfIndexOfFarthestOpen] = '2';
                finderOfIndexOfFarthestOpen--;
                string[finderOfIndexOfFarthestOpen] = '%';
                finderOfIndexOfFarthestOpen--;
            } else {
                string[finderOfIndexOfFarthestOpen] = string[finderOfIndexOfFarthestNonSpace];
                finderOfIndexOfFarthestOpen--;
            }
            finderOfIndexOfFarthestNonSpace--;
        }
        return string;
    };
}
