package dgroomes.testing;

import java.util.Optional;

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

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static <T> OptionalAssertable<T> assertThat(Optional<T> actual) {
        return new OptionalAssertable<>(actual);
    }
}
