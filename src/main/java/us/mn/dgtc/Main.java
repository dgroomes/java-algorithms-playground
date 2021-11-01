package us.mn.dgtc;

import us.mn.dgtc.questions.IdentifyDuplicates;

import java.util.Stack;

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
