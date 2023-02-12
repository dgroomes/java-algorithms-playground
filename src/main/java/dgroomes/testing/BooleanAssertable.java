package dgroomes.testing;

/**
 * Just like {@link Assertable} but for booleans.
 */
public class BooleanAssertable extends Assertable<Boolean> {

    public BooleanAssertable(Boolean actual) {
        super(actual);
    }

    public void isTrue() {
        isNotNull();

        if (!actual) {
            fail("Expected the boolean to be true but it was false.");
        }
    }

    public void isFalse() {
        isNotNull();

        if (actual) {
            fail("Expected the boolean to be false but it was true.");
        }
    }
}
