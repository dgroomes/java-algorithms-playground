package us.mn.dgtc;

public class TestCase<T> {
	
	private final T input;
	private final boolean expectedResult;
	
	public TestCase(T input, boolean expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}
	
	public T input() {
		return input;
	}; 	
	
	public boolean expectedResult() {
		return expectedResult;
	};
}