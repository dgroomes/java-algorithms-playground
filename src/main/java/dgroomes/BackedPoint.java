package dgroomes;

public class BackedPoint<T> extends Point {

    private final T backedItem;

    public BackedPoint(T backedItem, int x, int y) {
        super(x, y);
        this.backedItem = backedItem;
    }

    public T getBackedItem() {
        return backedItem;
    }
}
