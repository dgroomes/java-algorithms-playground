package dgroomes.testing;

/**
 * A test case definition.
 * <p>
 * This is a simple a data holder class. It represents the data for a test case and the expected result.
 *
 * @param <I> input type
 * @param <R> expected result
 */
public record TestCase<I, R>(I input, R expectedResult) {

    public static <I, R> TestCase<I, R> test(I input, R expectedResult) {
        return new TestCase<>(input, expectedResult);
    }
}
