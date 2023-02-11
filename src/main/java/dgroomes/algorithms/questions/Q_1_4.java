package dgroomes.algorithms.questions;

import dgroomes.TerminalUtil;

import java.util.List;

import static dgroomes.testing.Assertions.assertThat;
import static dgroomes.testing.TestCase.test;

public class Q_1_4 {

    public static void main(String[] args) {
        TerminalUtil.reset(); TerminalUtil.bold();
        System.out.println("Question 1.4");
        TerminalUtil.reset();

        execute(TWO_PASS_INSERTION);

        System.out.println("\n");
    }

    /**
     * A simple encoding function that replaces space characters with '%20'.
     */
    @FunctionalInterface
    interface EncodeSpaceCharacter {
        char[] encode(char[] string);
    }

    // WARNING: These test cases fail! The algorithm is implemented incorrectly.
    public static void execute(EncodeSpaceCharacter algorithm) {
        var testCases = List.of(
                test("Single space".toCharArray(), "Single%20space".toCharArray()),
                test("Trailing-space ".toCharArray(), "Trailing-space%20".toCharArray()),
                test("  Leading-spaces".toCharArray(), "%20%20Leading-spaces".toCharArray()),
                test("No-space".toCharArray(), "No-space".toCharArray()),
                test(new char[]{}, new char[]{}));

        for (var testCase : testCases) {
            System.out.println(testCase);
            assertThat(algorithm.encode(testCase.input())).isEqualTo(testCase.expectedResult());
        }
    }

    static EncodeSpaceCharacter TWO_PASS_INSERTION = string -> {
        // Make a pass over the array to find the number of space characters. This let's us know what size to allocate
        // for the new array.
        int size = string.length;
        for (var c : string) {
            if (c == ' ') size += 2;
        }

        // Make a second pass over the array and simply insert every character from the original array into the new
        // array except for space characters, which get replaced with '%', '2', '0'.
        var r = new char[size];
        var idx = 0;
        for (var c : string) {
            if (c == ' ') {
                r[idx++] = '%';
                r[idx++] = '2';
                r[idx++] = '0';
            } else {
                r[idx++] = c;
            }
        }
        return r;
    };
}
