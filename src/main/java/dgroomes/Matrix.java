package dgroomes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by David Groomes on 9/18/2015.
 */
public class Matrix<T> implements Iterable<BackedPoint<T>> {

    private List<List<T>> matrix;

    public Matrix(List<List<T>> matrix) {
        Assertions.assertThat(matrix.size() > 0);
        this.matrix = matrix;
    }

    public static <T> Matrix createOne(int x, int y, T... items) {
        if (items.length != x * y) {
            throw new IllegalArgumentException("size of argument 'items' does not match the expected size of a matrix of size " + x + " by " + y);
        } else {
            return new Matrix(ListUtil.partitionList(Arrays.asList(items), x));
        }
    }

    public int width() {
        return matrix.get(0).size();
    }

    public int height() {
        return matrix.size();
    }

    public BackedPoint<T> getBackedPoint(Coordinates coordinates) {
        return new BackedPoint<>(get(coordinates), coordinates.getX(), coordinates.getY());
    }

    public T get(Coordinates coordinates) {
        return matrix.get(coordinates.getY()).get(coordinates.getX());
    }

    public void set(Coordinates coordinates, T toAssign) {
        matrix.get(coordinates.getY()).set(coordinates.getX(), toAssign);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Matrix) {
            Matrix that = (Matrix) obj;
            return Objects.equals(matrix, that.matrix);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                builder.append(get(new Coordinates(x, y)));
                builder.append(" ");
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(matrix);
    }

    @Override
    public Iterator<BackedPoint<T>> iterator() {
        return new Iterator<BackedPoint<T>>() {

            private BackedPoint<T> currentBackedPoint;

            @Override
            public boolean hasNext() {
                return currentBackedPoint == null || !(currentBackedPoint.getX() == width() - 1 && currentBackedPoint.getY() == height() - 1);
            }

            @Override
            public BackedPoint<T> next() {
                if (currentBackedPoint == null) {
                    currentBackedPoint = getBackedPoint(new Coordinates(0, 0));
                } else if (currentBackedPoint.getX() < width() - 1){
                    currentBackedPoint = getBackedPoint(new Coordinates(currentBackedPoint.getX() + 1, currentBackedPoint.getY()));
                } else {
                    currentBackedPoint = getBackedPoint(new Coordinates(0, currentBackedPoint.getY() + 1));
                }
                return currentBackedPoint;
            }
        };
    }
}
