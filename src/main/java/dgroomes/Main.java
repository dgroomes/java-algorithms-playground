package dgroomes;

import dgroomes.questions.IdentifyDuplicates;

/**
 * Answering questions in "Cracking The Coding Interview"
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        new Q_1_1().question_1_1_v_1();

        IdentifyDuplicates.BRUTE_FORCE.largeLists();
        IdentifyDuplicates.SORTING.largeLists();
    }
}
