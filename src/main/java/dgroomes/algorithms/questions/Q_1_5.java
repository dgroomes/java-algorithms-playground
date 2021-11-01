package dgroomes.algorithms.questions;

import dgroomes.testing.Assertions;

import java.util.ArrayList;
import java.util.List;

@QuestionAnswer(chapter = 1, question = 5)
public class Q_1_5 {

    public void v_1() {
        Assertions.assertThat(compress("aabcccc")).isEqualTo("a2b1c4");
    }

    public String compress(String string) {
        if (string.length() == 0) {
            return string;
        }
        char[] chars = string.toCharArray();
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char currentChar = chars[0];
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
        String compressedString = builder.toString();
        if (compressedString.length() < string.length()) {
            return compressedString;
        } else {
            return string;
        }
    }

    private List<CharCount> supply() {
        return new ArrayList<>();
    }

    static class CharCount {
        char charac;
        int count;

        CharCount(char charac, int count) {
            this.charac = charac;
            this.count = count;
        }
    }
}
