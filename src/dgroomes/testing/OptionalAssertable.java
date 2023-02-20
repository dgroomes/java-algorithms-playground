package dgroomes.testing;

import java.util.Optional;

/**
 * Just like {@link Assertable} but for {@link java.util.Optional} objects.
 */
public class OptionalAssertable<T> extends Assertable<Optional<T>> {

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public OptionalAssertable(Optional<T> actual) {
        super(actual);
    }

    public void isPresent() {
        isNotNull();

        if (actual.isEmpty()) {
            fail("Expected the Optional to have a value but it was empty.");
        }
    }

    public void isEmpty() {
        isNotNull();

        if (actual.isPresent()) {
            fail("Expected the Optional to be empty but it had a value.");
        }
    }
}
