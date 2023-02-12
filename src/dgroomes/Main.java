package dgroomes;

import dgroomes.algorithms.IdentifyDuplicates;
import dgroomes.algorithms.SortersTest;
import dgroomes.algorithms.questions.*;
import dgroomes.boggle.test.BoggleBoardTest;
import dgroomes.boggle.test.WordFinderTest;

/**
 * Please see the README for more information.
 */
public class Main {
    public static void main(String[] args) {
        var noArgs = new String[]{};

        // Run the test cases for algorithm questions from the book "Cracking the Coding Interview"
        Q_1_1.main(noArgs);
        Q_1_3.main(noArgs);
        Q_1_4.main(noArgs);
        Q_1_5.main(noArgs);
        Q_1_6Test.main(noArgs);
        Q_1_7Test.main(noArgs);

        // Run the test cases of my own creation.
        IdentifyDuplicates.main(noArgs);
        SortersTest.main(noArgs);
        BoggleBoardTest.main(noArgs);
        WordFinderTest.main(noArgs);
    }
}
