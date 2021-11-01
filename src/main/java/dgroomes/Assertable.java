package dgroomes;

/**
 * Created by David Groomes on 9/18/2015.
 */
public class Assertable<T> {

	protected T actual;

	public Assertable(T actual) {
		this.actual = actual;
	}

	public void isEqualTo(Object expected) {
		boolean result = actual.equals(expected);
		if (result) {
//			System.out.println("assertion succeeded. actualValue=" + actual + " is equal to expectedValue=" + expected);
		} else {
			fail("actualValue=" + actual + " is not equal to expectedValue=" + expected);
		}
	}

	public void isNotNull() {
		if (actual == null) {
			fail("is null");
		}
	}

	protected void fail(String message) {
		throw new RuntimeException("assertion failed. " + message);
	}
}
