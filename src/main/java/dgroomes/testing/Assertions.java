package dgroomes.testing;

public class Assertions {
    public static <T> Assertable<T> assertThat(T actual) {
        return new Assertable<>(actual);
    }

    public static <T extends Comparable<T>> ComparableAssertable<T> assertThat(T actual) {
        return new ComparableAssertable<>(actual);
    }

    public static BooleanAssertable assertThat(Boolean actual) {
        return new BooleanAssertable(actual);
    }

    public static CharArrayAssertable assertThat(char[] actual) {
        return new CharArrayAssertable(actual);
    }
}
