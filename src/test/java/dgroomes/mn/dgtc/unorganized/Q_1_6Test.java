package dgroomes.mn.dgtc.unorganized;

import org.junit.jupiter.api.Test;
import dgroomes.Coordinates;
import dgroomes.MatrixUtils;
import dgroomes.SquareMatrix;
import dgroomes.questions.Q_1_6;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Groomes on 9/18/2015.
 */
public class Q_1_6Test {

    @Test
    public void rotateNinetyDegress_DirectLowLevel_twoByTwo() throws Exception {
        // Arrange
        char[][] matrix = new char[2][2];
        matrix[0][0] = '1';
        matrix[1][0] = '2';
        matrix[0][1] = '3';
        matrix[1][1] = '4';

        // Act
        Q_1_6.rotateNinetyDegrees_directLowLevel(matrix);

        assertThat(matrix[0][0]).isEqualTo('3');
        assertThat(matrix[1][0]).isEqualTo('1');
        assertThat(matrix[0][1]).isEqualTo('4');
        assertThat(matrix[1][1]).isEqualTo('2');
    }

    @Test
    public void rotateNinetyDegress_DirectLowLevel_threeByThree() throws Exception {
        // Arrange
        char[][] matrix = new char[3][3];
        matrix[0][0] = 'a';
        matrix[1][0] = 'b';
        matrix[2][0] = 'c';
        matrix[0][1] = 'd';
        matrix[1][1] = 'e';
        matrix[2][1] = 'f';
        matrix[0][2] = 'g';
        matrix[1][2] = 'h';
        matrix[2][2] = 'i';

        // Act
        Q_1_6.rotateNinetyDegrees_directLowLevel(matrix);

        assertThat(matrix[0][0]).isEqualTo('g');
        assertThat(matrix[1][0]).isEqualTo('d');
        assertThat(matrix[2][0]).isEqualTo('a');
        assertThat(matrix[0][1]).isEqualTo('h');
        assertThat(matrix[1][1]).isEqualTo('e');
        assertThat(matrix[2][1]).isEqualTo('b');
        assertThat(matrix[0][2]).isEqualTo('i');
        assertThat(matrix[1][2]).isEqualTo('f');
        assertThat(matrix[2][2]).isEqualTo('c');
    }

    @Test
    public void rotateNinetyDegress_highLevel_twoByTwo() throws Exception {
        // Arrange
        SquareMatrix<Character> matrix = new SquareMatrix(Arrays.asList(Arrays.asList('1', '2'), Arrays.asList('3', '4')));

        // Act
        MatrixUtils.rotateMatrixNinetyDegrees(matrix);

        assertThat(matrix.get(new Coordinates(0, 0))).isEqualTo('3');
        assertThat(matrix.get(new Coordinates(1, 0))).isEqualTo('1');
        assertThat(matrix.get(new Coordinates(0, 1))).isEqualTo('4');
        assertThat(matrix.get(new Coordinates(1, 1))).isEqualTo('2');
    }

    @Test
    public void rotateNinetyDegress_highLevel_twoByTwo_varArgsFactoryMethod() throws Exception {
        // Arrange
        SquareMatrix<Character> matrix = SquareMatrix.createSquareMatrix(
                '1', '2',

                '3', '4');
        // Act
        MatrixUtils.rotateMatrixNinetyDegrees(matrix);

        assertThat(matrix).isEqualTo(SquareMatrix.createSquareMatrix(
                '3', '1',

                '4', '2'));
    }

    @Test
    public void rotateNinetyDegress_highLevel_threeByThree_varArgsFactoryMethod() throws Exception {
        // Arrange
        SquareMatrix<Character> matrix = SquareMatrix.createSquareMatrix(
                'a', 'b', 'c',

                'd', 'e', 'f',

                'g', 'h', 'i');
        // Act
        MatrixUtils.rotateMatrixNinetyDegrees(matrix);

        assertThat(matrix).isEqualTo(SquareMatrix.createSquareMatrix(
                'g', 'd', 'a',

                'h', 'e', 'b',

                'i', 'f', 'c'));
    }
}
