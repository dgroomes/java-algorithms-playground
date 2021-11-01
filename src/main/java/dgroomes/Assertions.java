package dgroomes;

public class Assertions {
    public static <T> Assertable<T> assertThat(T actual) {
        return new Assertable<>(actual);
    }

    public static <T extends Comparable<T>> ComparableAssertable<T> assertThat(T actual) {
        return new ComparableAssertable<>(actual);
    }
}
