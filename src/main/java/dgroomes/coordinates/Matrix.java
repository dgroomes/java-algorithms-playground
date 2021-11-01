package dgroomes.coordinates;

import dgroomes.ListUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static dgroomes.testing.Assertions.assertThat;

public class Matrix<T> implements Iterable<BackedPoint<T>> {

    private final List<List<T>> matrix;

    public Matrix(List<List<T>> matrix) {
        assertThat(matrix.size()).isGreaterThan(0);
        this.matrix = matrix;
    }

    public static <T> Matrix<T> createOne(int x, int y, T... items) {
        if (items.length != x * y) {
            throw new IllegalArgumentException("size of argument 'items' does not match the expected size of a matrix of size " + x + " by " + y);
        } else {
            return new Matrix<>(ListUtil.partitionList(Arrays.asList(items), x));
        }
    }

    public int width() {
        return matrix.get(0).size();
    }

    public int height() {
        return matrix.size();
    }

    public BackedPoint<T> getBackedPoint(Coordinates coordinates) {
        return new BackedPoint<>(get(coordinates), coordinates.x(), coordinates.y());
    }

    public T get(Coordinates coordinates) {
        return matrix.get(coordinates.y()).get(coordinates.x());
    }

    public void set(Coordinates coordinates, T toAssign) {
        matrix.get(coordinates.y()).set(coordinates.x(), toAssign);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Matrix that) {
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
        return new Iterator<>() {

            private BackedPoint<T> currentBackedPoint;

            @Override
            public boolean hasNext() {
                return currentBackedPoint == null || !(currentBackedPoint.x() == width() - 1 && currentBackedPoint.y() == height() - 1);
            }

            @Override
            public BackedPoint<T> next() {
                if (currentBackedPoint == null) {
                    currentBackedPoint = getBackedPoint(new Coordinates(0, 0));
                } else if (currentBackedPoint.x() < width() - 1) {
                    currentBackedPoint = getBackedPoint(new Coordinates(currentBackedPoint.x() + 1, currentBackedPoint.y()));
                } else {
                    currentBackedPoint = getBackedPoint(new Coordinates(0, currentBackedPoint.y() + 1));
                }
                return currentBackedPoint;
            }
        };
    }
}
