package dgroomes.questions;

import org.junit.Test;
import dgroomes.Matrix;
import dgroomes.MatrixUtils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Groomes on 9/19/2015.
 */
public class Q_1_7Test {

    @Test
    public void testZeroColumnsAndRowsOfZeroPoints() throws Exception {
        Matrix matrix = Matrix.createOne(3, 3,
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
