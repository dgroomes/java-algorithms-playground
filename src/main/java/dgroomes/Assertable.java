package dgroomes;

/**
 * An object that will be asserted against.
 * <p>
 * This is a component in a general-purpose testing assertions module. It's modeled after the excellent AssertJ library.
 *
 * @param <T>
 */
public class Assertable<T> {

    protected T actual;

    public Assertable(T actual) {
        this.actual = actual;
    }

    public void isEqualTo(Object expected) {
        boolean result = actual.equals(expected);
        if (!result) {
            fail("actualValue=" + actual + " is not equal to expectedValue=" + expected);
        }
    }

    public void isNotNull() {
        if (actual == null) {
            fail("is null");
        }
    }

    protected void fail(String message) {
        throw new RuntimeException("assertion failed. " + message);
    }
}
