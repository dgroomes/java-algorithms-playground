package dgroomes.testing;

/**
 * Just like {@link Assertable} but for comparable types.
 *
 * @param <T>
 */
public class ComparableAssertable<T extends Comparable<T>> extends Assertable<T> {

    public ComparableAssertable(T actual) {
        super(actual);
    }

    public void isGreaterThan(T other) {
        if (actual.compareTo(other) <= 0) {
            fail("Expected %s (actual) to be greater than %s".formatted(actual, other));
        }
    }
}
