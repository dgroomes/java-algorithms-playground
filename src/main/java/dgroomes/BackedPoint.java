package dgroomes;

/**
 * Created by David Groomes on 9/19/2015.
 */
public class BackedPoint<T> extends Point {

    private T backedItem;

    public BackedPoint(T backedItem, int x, int y) {
        super(x, y);
        this.backedItem = backedItem;
    }

    public T getBackedItem() {
        return backedItem;
    }
}
