package dgroomes;

import dgroomes.algorithms.BinarySearch;
import dgroomes.algorithms.Range;

import java.util.List;
import java.util.Optional;

import static dgroomes.TerminalUtil.bold;
import static dgroomes.TerminalUtil.reset;
import static dgroomes.testing.Assertions.assertThat;
import static java.lang.System.out;

/**
 * This tests the binary search methods in {@link BinarySearch}.
 * <p>
 * Note: while the test cases themselves were intentionally designed, I didn't put much thought into the test class
 * itself. What should it be named? What is its scope of "code-under-test"? Consider improving.
 */
@SuppressWarnings({"OptionalGetWithoutIsPresent", "unused"})
class BinarySearchTest {

  /**
   * This method executes all of the "test methods" in this class using reflection.
   * <p>
   * By convention, we can identify test methods as those that are non-static, void, and have no arguments.
   */
  public static void main(String[] args) {
    bold();
    out.println("BinarySearchTest");
    reset();

    var instance = new BinarySearchTest();

    var methods = instance.getClass().getDeclaredMethods();
    for (var method : methods) {
      if (method.getReturnType() == void.class && method.getParameterCount() == 0) {
        try {
          out.printf("Test case: %s%n", method.getName());

          method.invoke(instance);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }

    out.println("\n");
  }

  void binarySearch_first() {
    List<Integer> input = List.of(1, 2, 3);

    Optional<Integer> found = BinarySearch.binarySearch(input, 1);

    assertThat(found).isPresent();
    var foundIndex = found.get();
    assertThat(foundIndex).isEqualTo(0);
  }

  void binarySearch_middle() {
    List<Integer> list = List.of(1, 2, 3);

    Optional<Integer> found = BinarySearch.binarySearch(list, 2);

    assertThat(found).isPresent();
    var foundIndex = found.get();
    assertThat(foundIndex).isEqualTo(1);
  }

  void binarySearch_last() {
    List<Integer> input = List.of(1, 2, 3);

    Optional<Integer> found = BinarySearch.binarySearch(input, 3);

    assertThat(found).isPresent();
    var foundIndex = found.get();
    assertThat(foundIndex).isEqualTo(2);
  }


  void binarySearch_noMatch() {
    List<Integer> input = List.of(1, 2, 3);

    Optional<Integer> found = BinarySearch.binarySearch(input, 0);

    assertThat(found).isEmpty();
  }

  void binarySearch_emptyList() {
    List<Integer> input = List.of();

    Optional<Integer> found = BinarySearch.binarySearch(input, 0);

    assertThat(found).isEmpty();
  }

  void binarySearch_oneElementList() {
    List<Integer> input = List.of(1);

    Optional<Integer> found = BinarySearch.binarySearch(input, 1);

    assertThat(found).isPresent();
    Integer foundIndex = found.get();
    assertThat(foundIndex).isEqualTo(0);
  }


  void binarySearch_twoElementList() {
    List<Integer> input = List.of(1, 2);

    Optional<Integer> found = BinarySearch.binarySearch(input, 2);

    assertThat(found).isPresent();
    Integer foundIndex = found.get();
    assertThat(foundIndex).isEqualTo(1);
  }


  void binarySearch_variegated() {
    List<Integer> input = List.of(2, 2, 3, 3, 3, 5, 5, 5, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7);

    Optional<Integer> found = BinarySearch.binarySearch(input, 3);

    assertThat(found).isPresent();
    Integer foundIndex = found.get();
    assertThat(foundIndex).isGreaterThan(2);
    assertThat(foundIndex).isLessThan(4);
  }

  void binaryRangeSearch_runOfSize1_inTheMiddle() {
    List<Integer> input = List.of(1, 2, 3);

    Optional<Range> found = BinarySearch.binaryRangeSearch(input, 2);

    assertThat(found).isPresent();
    Range range = found.get();
    assertThat(range.low()).isEqualTo(1);
    assertThat(range.high()).isEqualTo(1);
  }

  void binaryRangeSearch_runOfSize2_inTheMiddle() {
    List<Integer> input = List.of(1, 2, 2, 3);

    Optional<Range> found = BinarySearch.binaryRangeSearch(input, 2);

    assertThat(found).isPresent();
    Range range = found.get();
    assertThat(range.low()).isEqualTo(1);
    assertThat(range.high()).isEqualTo(2);
  }

  void binaryRangeSearch_runOfSize2_atTheStart() {
    List<Integer> input = List.of(1, 1, 2);

    Optional<Range> found = BinarySearch.binaryRangeSearch(input, 1);

    assertThat(found).isPresent();
    Range range = found.get();
    assertThat(range.low()).isEqualTo(0);
    assertThat(range.high()).isEqualTo(1);
  }


  void binaryRangeSearch_runOfSize2_atTheEnd() {
    List<Integer> input = List.of(1, 2, 2);

    Optional<Range> found = BinarySearch.binaryRangeSearch(input, 2);

    assertThat(found).isPresent();
    Range range = found.get();
    assertThat(range.low()).isEqualTo(1);
    assertThat(range.high()).isEqualTo(2);
  }


  void binaryRangeSearch_emptyList() {
    List<Integer> input = List.of();

    Optional<Range> found = BinarySearch.binaryRangeSearch(input, 1);

    assertThat(found).isEmpty();
  }


  void binaryRangeSearch_oneElementList() {
    List<Integer> input = List.of(1);

    Optional<Range> found = BinarySearch.binaryRangeSearch(input, 1);

    assertThat(found).isPresent();
    Range range = found.get();
    assertThat(range.low()).isEqualTo(0);
    assertThat(range.high()).isEqualTo(0);
  }


  void binaryRangeSearch_large_range() {
    List<Integer> input = List.of(1, 1, 1, 1, 1);

    Optional<Range> found = BinarySearch.binaryRangeSearch(input, 1);
    assertThat(found).isPresent();
    Range range = found.get();
    assertThat(range.low()).isEqualTo(0);
    assertThat(range.high()).isEqualTo(4);
  }


  void binaryRangeSearch_variegated() {
    List<Integer> input = List.of(2, 2, 3, 3, 3, 5, 5, 5, 5, 5, 7, 7, 7, 7, 7, 7, 7);

    {
      Optional<Range> found = BinarySearch.binaryRangeSearch(input, 2);
      assertThat(found).isPresent();
      Range range = found.get();
      assertThat(range.low()).isEqualTo(0);
      assertThat(range.high()).isEqualTo(1);
    }

    {
      Optional<Range> found = BinarySearch.binaryRangeSearch(input, 3);
      assertThat(found).isPresent();
      Range range = found.get();
      assertThat(range.low()).isEqualTo(2);
      assertThat(range.high()).isEqualTo(4);
    }

    {
      Optional<Range> found = BinarySearch.binaryRangeSearch(input, 5);
      assertThat(found).isPresent();
      Range range = found.get();
      assertThat(range.low()).isEqualTo(5);
      assertThat(range.high()).isEqualTo(9);
    }

    {
      Optional<Range> found = BinarySearch.binaryRangeSearch(input, 7);
      assertThat(found).isPresent();
      Range range = found.get();
      assertThat(range.low()).isEqualTo(10);
      assertThat(range.high()).isEqualTo(16);
    }
  }
}
