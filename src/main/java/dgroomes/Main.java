package dgroomes;

import dgroomes.algorithms.IdentifyDuplicates;
import dgroomes.algorithms.questions.*;

/**
 * Please see the README for more information.
 */
public class Main {
    public static void main(String[] args) {
        var noArgs = new String[]{};

        Q_1_1.main(noArgs);
        Q_1_3.main(noArgs);
        Q_1_4.main(noArgs);
        Q_1_5.main(noArgs);

        IdentifyDuplicates.BRUTE_FORCE.largeLists();
        IdentifyDuplicates.SORTING.largeLists();
    }
}
