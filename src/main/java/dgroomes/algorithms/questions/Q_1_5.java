package dgroomes.algorithms.questions;

import java.util.List;

import static dgroomes.testing.Assertions.assertThat;
import static dgroomes.testing.TestCase.test;

@QuestionAnswer(chapter = 1, question = 5)
public class Q_1_5 {

    public static void main(String[] args) {
        execute(COMPRESS);
    }

    /**
     * Compress adjacent repeating characters to just one character and an integer equal to the number of times the
     * character repeated. But, if the "compressed" string is in fact longer than the original string then the compression
     * was not effective, just return the original string.
     * <p>
     * For example, compress "aabcccc" to "a2b1c4"
     */
    @FunctionalInterface
    interface CompressRepeatCharacters {
        String compress(String string);
    }

    public static void execute(CompressRepeatCharacters algorithm) {
        var testCases = List.of(
                test("aaa", "a3"),
                test("aa", "aa"),
                test("a", "a"),
                test("", ""),
                test("aaaaaaaaaa", "a10"),
                test("aabcccc", "a2b1c4"));

        for (var testCase : testCases) {
            assertThat(algorithm.compress(testCase.input())).isEqualTo(testCase.expectedResult());
        }
    }

    static CompressRepeatCharacters COMPRESS = string -> {
        if (string.length() == 0) {
            return string;
        }
        var chars = string.toCharArray();
        var builder = new StringBuilder();
        int count = 1;
        var currentChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                count++;
            } else {
                builder.append(currentChar);
                builder.append(count);
                currentChar = chars[i];
                count = 1;
            }
        }
        builder.append(currentChar);
        builder.append(count);
        var compressedString = builder.toString();
        if (compressedString.length() < string.length()) {
            return compressedString;
        } else {
            return string;
        }
    };
}
