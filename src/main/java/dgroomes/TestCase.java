package dgroomes;

/**
 * A test case definition.
 *
 * This is a simple is a data holder class ( represents the data for a test
 * @param <T>
 */
public record TestCase<T>(T input, boolean expectedResult) {
}
