package dgroomes.testing;

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

    public void isEqualTo(T expected) {
        boolean result = actual.equals(expected);
        if (!result) {
            String msg = "actualValue=%s is not equal to expectedValue=%s.".formatted(actual, expected);
            fail(msg);
        }
    }

    public void isNotNull() {
        if (actual == null) {
            fail("Value is null but expected it to be non-null.");
        }
    }

    protected void fail(String message) {
        throw new RuntimeException("Assertion failed. " + message);
    }
}
