package dgroomes;

import dgroomes.testing.Assertions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by David Groomes on 9/18/2015.
 */
public class SquareMatrix<T> extends Matrix<T> {

    public SquareMatrix(List<List<T>> matrix) {
        super(matrix);
        Assertions.assertThat(matrix.size() > 0);
        Assertions.assertThat(matrix.size()).isEqualTo(matrix.get(0).size());
    }

    public int size() {
        return width();
    }

    public static <T> SquareMatrix createSquareMatrix(T... items) {
        if (!isPerfectSquare(items.length)) {
            throw new IllegalArgumentException("The length of the items array passed to SquareMatrix(T ... items) must be a perfect square, since it represent the items in a square matrix");
        } else {
            int size = (int) (Math.sqrt(items.length) + 0.5);
            return new SquareMatrix(ListUtil.partitionList(Arrays.asList(items), size));
        }
    }

    private static boolean isPerfectSquare(int i) {
        if (i < 0) {
            return false;
        } else {
            int sqrt = (int) (Math.sqrt(i) + 0.5);
            return sqrt * sqrt == i;
        }
    }
}
