package dgroomes.algorithms.questions;

import dgroomes.coordinates.Matrix;
import dgroomes.coordinates.MatrixUtils;

import static dgroomes.TerminalUtil.bold;
import static dgroomes.TerminalUtil.reset;
import static dgroomes.testing.Assertions.assertThat;
import static java.lang.System.out;

public class Q_1_7Test {

    public static void main(String[] args) {
        bold(); out.println("Q_1_7Test"); reset();

        testZeroColumnsAndRowsOfZeroPoints();

        out.println("\n");
    }

    public static void testZeroColumnsAndRowsOfZeroPoints() {
        var matrix = Matrix.createOne(3, 3,
                'x', 'x', 'x',
                '0', 'x', 'x',
                'x', 'x', 'x'
        );
        MatrixUtils.zeroColumnsAndRowsOfZeroPoints(matrix, '0');
        assertThat(matrix).isEqualTo(Matrix.createOne(3, 3,
                '0', 'x', 'x',
                '0', '0', '0',
                '0', 'x', 'x'));
    }
}
