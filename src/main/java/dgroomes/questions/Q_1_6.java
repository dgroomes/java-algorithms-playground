package dgroomes.questions;

/**
 * Created by David Groomes on 9/18/2015.
 */
public class Q_1_6 {

    public static void rotateNinetyDegrees_directLowLevel(char[][] matrix) {
        int widthAndHeight = matrix.length;
        int baseQuadrantWidth = halfRoundUp(matrix.length);
        int baseQuadrantHeight = matrix.length / 2;
        for (int i = 0; i < baseQuadrantWidth; i++) {
            for (int j = 0; j < baseQuadrantHeight; j++) {
                char toAssign = matrix[i][j];
                int quadrantOneX = widthAndHeight - 1 - j;
                int quadrantOneY = i;
                char temp = matrix[quadrantOneX][quadrantOneY];
                matrix[quadrantOneX][quadrantOneY] = toAssign;
                toAssign = temp;
                int quadrantFourX = widthAndHeight - 1-  quadrantOneY;
                int quadrantFourY = quadrantOneX;
                temp = matrix[quadrantFourX][quadrantFourY];
                matrix[quadrantFourX][quadrantFourY] = toAssign;
                toAssign = temp;
                int quadrantThreeX = widthAndHeight - 1 - quadrantFourY;
                int quadrantThreeY = quadrantFourX;
                temp = matrix[quadrantThreeX][quadrantThreeY];
                matrix[quadrantThreeX][quadrantThreeY] = toAssign;
                toAssign = temp;
                matrix[i][j] = toAssign;
            }
        }
    }

    private static int halfRoundUp(int i) {
        int dividedTossedRemainder = i / 2;
        int remainder = i % 2;
        return dividedTossedRemainder + remainder;
    }

}
