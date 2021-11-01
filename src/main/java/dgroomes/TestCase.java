package dgroomes;

/**
 * A test case definition.
 * <p>
 * This is a simple a data holder class. It represents the data for a test case and the expected result.
 */
public record TestCase<T>(T input, boolean expectedResult) {

    public static <T> TestCase<T> test(T input, boolean expectedResult) {
        return new TestCase<>(input, expectedResult);
    }
}
