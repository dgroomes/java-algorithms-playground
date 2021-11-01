package dgroomes;

public class Assertions {
	public static <T> Assertable<T> assertThat(T actual) {
		return new Assertable(actual);
	};
}

