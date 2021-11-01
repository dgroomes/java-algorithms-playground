package dgroomes.algorithms.questions;

import dgroomes.testing.Assertions;

@QuestionAnswer(chapter = 1, question = 4)
public class Q_1_4 {

    public void v_1() {
        Assertions.assertThat(new String(replaceSpacesWithPercent20("Mr John Smith    ".toCharArray()))).isEqualTo(new String("Mr%20John%20Smith".toCharArray()));
    }

    /**
     * Operation occurs in place on the char array
     */
    public char[] replaceSpacesWithPercent20(char[] string) {
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
    }
}
