package us.mn.dgtc;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by David Groomes on 9/18/2015.
 */
public class MatrixUtils {
    
    public static <T> void rotateMatrixNinetyDegrees(SquareMatrix<T> matrix) {
        int widthAndHeight = matrix.size();
        int baseQuadrantWidth = halfRoundUp(matrix.size());
        int baseQuadrantHeight = matrix.size() / 2;
        for (int i = 0; i < baseQuadrantWidth; i++) {
            for (int j = 0; j < baseQuadrantHeight; j++) {
                rotateAtCoordinates(matrix, widthAndHeight, new Coordinates(i, j));
            }
        }
    }

    private static <T> void rotateAtCoordinates(SquareMatrix<T> matrix, int widthAndHeight, Coordinates coordinates) {
        T toAssign = matrix.get(coordinates);
        for (int i = 0; i < 4; i++) {
            Coordinates nextCoords = rotateCoordinatesNinetyDegrees(matrix, coordinates);
            T temp = matrix.get(nextCoords);
            matrix.set(nextCoords, toAssign);
            toAssign = temp;
            coordinates = nextCoords;
        }
    }

    private static Coordinates rotateCoordinatesNinetyDegrees(SquareMatrix<?> matrix, Coordinates coordinates) {
        return new Coordinates(matrix.size() - 1 - coordinates.getY(), coordinates.getX());
    }

    private static int halfRoundUp(int i) {
        return i - Math.floorDiv(i ,2);
    }

    public static <T> void zeroColumnsAndRowsOfZeroPoints(Matrix<T> matrix, T zeroPoint) {
        Set<Integer> rowsToZero = new HashSet<>();
        Set<Integer> columnsToZero = new HashSet<>();
        matrix.forEach(backedPoint -> {
            if (backedPoint.getBackedItem().equals(zeroPoint)) {
                rowsToZero.add(backedPoint.getY());
                columnsToZero.add(backedPoint.getX());
            }
        });
        rowsToZero.forEach(row -> {
            for (int x = 0; x < matrix.width(); x++) {
                matrix.set(new Coordinates(x, row), zeroPoint);
            }
        });
        columnsToZero.forEach(column -> {
            for (int y = 0; y < matrix.width(); y++) {
                matrix.set(new Coordinates(column, y), zeroPoint);
            }
        });
    }
}
