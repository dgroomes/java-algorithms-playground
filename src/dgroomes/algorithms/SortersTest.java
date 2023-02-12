package dgroomes.algorithms;

import dgroomes.testing.TestCase;

import java.util.List;

import static dgroomes.TerminalUtil.bold;
import static dgroomes.TerminalUtil.reset;
import static dgroomes.testing.Assertions.assertThat;
import static dgroomes.testing.TestCase.test;
import static java.lang.System.out;

/**
 * Testing the sort algorithms defined in the {@link Sorters} class.
 */
public class SortersTest {

  private static final List<TestCase<List<Integer>, List<Integer>>> TEST_CASES = List.of(
          test(List.of(1, 3, 2, 4, 6, 1), List.of(1, 1, 2, 3, 4, 6)),
          test(List.of(1), List.of(1)),
          test(List.of(2, 1), List.of(1, 2))
  );

  public static void main(String[] args) {
    bold(); out.println("SortersTest"); reset();

    out.println("Testing merge sort...");
    for (var testCase : TEST_CASES) {
      out.println(testCase);
      var input = testCase.input();
      var expected = testCase.expectedResult();

      List<Integer> result = Sorters.mergeSort(input);

      assertThat(result).isEqualTo(expected);
    }

    out.println("Testing quick sort...");
    for (var testCase : TEST_CASES) {
      out.println(testCase);
      var input = testCase.input();
      var expected = testCase.expectedResult();

      List<Integer> result = Sorters.quickSort(input);

      assertThat(result).isEqualTo(expected);
    }

    out.println("\n");
  }
}
