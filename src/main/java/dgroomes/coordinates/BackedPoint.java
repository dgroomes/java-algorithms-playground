package dgroomes.coordinates;

/**
 * A point that's backed by (or associated with) some data structure.
 */
public record BackedPoint<T>(
        Point point,
        T backedItem) {

    public BackedPoint(T backedItem, int x, int y) {
        this(new Point(x, y), backedItem);
    }

    public int x() {
        return point.x();
    }

    public int y() {
        return point.y();
    }
}
