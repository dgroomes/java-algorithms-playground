package dgroomes.testing;

import java.util.Arrays;

public class CharArrayAssertable extends Assertable<char[]> {

    public CharArrayAssertable(char[] actual) {
        super(actual);
    }

    public void isEqualTo(char[] expected) {
        var equals = Arrays.equals(actual, expected);
        if (!equals) {
            var actualStr = Arrays.toString(actual);
            var expectedStr = Arrays.toString(expected);
            var msg = "actualValue=%s is not equal to expectedValue=%s".formatted(actualStr, expectedStr);
            fail(msg);
        }
    }
}
