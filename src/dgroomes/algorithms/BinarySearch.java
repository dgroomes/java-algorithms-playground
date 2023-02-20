package dgroomes.algorithms;

import dgroomes.algorithms.BinarySearchStepResult.*;
import dgroomes.algorithms.BinarySearchStepResult.Unsearched.OneSide;
import dgroomes.algorithms.internal.AbstractBinaryRangeSearcher;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static dgroomes.algorithms.BinarySearchStepResult.Unsearched.TwoSided;
import static dgroomes.algorithms.Range.*;

/**
 * A toy implementation of binary search for my own learning.
 */
public class BinarySearch {

  /**
   * Perform a binary search for a target value in a {@link java.util.List}.
   *
   * @param list            the list to search.
   * @param typedComparator a comparator that compares the target value to a value in the list.
   * @param target          the target value to search for.
   * @param <T>             the type of the values in the list.
   * @return the index of the target value if it is found, otherwise an empty {@link Optional}.
   */
  public static <T> Optional<Integer> binarySearch(List<T> list, TypedComparator<T> typedComparator, T target) {
    int size = list.size();
    if (size == 0) return Optional.empty();

    Range range = of(0, size - 1);

    while (true) {
      BinarySearchStepResult stepResult = BinarySearch.binarySearchStep(range, list::get, typedComparator, target);

      switch (stepResult) {
        case Found(int index, Unsearched ignored) -> {
          return Optional.of(index);
        }
        case FoundExhausted(int index) -> {
          return Optional.of(index);
        }
        case NotFoundExhausted() -> {
          return Optional.empty();
        }
        case TooHigh(var unsearched) -> range = unsearched;
        case TooLow(var unsearched) -> range = unsearched;
      }
    }
  }

  /**
   * Perform a single step of the binary search algorithm.
   * <p>
   * Note: This method in combination with the related types ({@link Range}, {@link Comparison} and {@link BinarySearchStepResult})
   * and "exhaustive checking" for switch expressions/statements has proven to be a good fundamental building block to
   * build other binary search methods on top of. This method doesn't code directly to a {@link List} and instead codes
   * to a "lookup" function because this allows this method to be used with other data structures like a collection
   * backed by a secondary list of indexes that represent a sorted view of the collection.
   * <p>
   * This implementation is somewhat silly, but it's great for learning. My goal was to learn more Java features, brush
   * up on my algorithm skills, and also to reduce the pain of off-by-one errors.
   */
  public static <T> BinarySearchStepResult binarySearchStep(Range range, Function<Integer, T> lookup, TypedComparator<T> typedComparator, T target) {
    Split split = split(range);

    return switch (split) {
      case Split.Point(int index) -> {
        T valueUnderTest = lookup.apply(index);
        var comparison = typedComparator.compare(target, valueUnderTest);
        yield switch (comparison) {
          case EQUAL_TO -> new FoundExhausted(index);
          case LESS_THAN, GREATER_THAN -> new NotFoundExhausted();
        };
      }
      case Split.PointPair(int left, int right) -> {
        // Note to self: while Lisp-like languages are fun, and writing wide code instead of tall code is fun, I am continually
        // reminded that having local variables is a big enabler for understanding the code while in the debugger.
        // In this particular case, I like to see "leftValueUnderTest" and "leftComparison even though it means that I
        // have to name the later local variables "rightValueUnderTest" and "rightComparison", which is quite verbose.
        T leftValueUnderTest = lookup.apply(left);
        var leftComparison = typedComparator.compare(target, leftValueUnderTest);
        yield switch (leftComparison) {
          case EQUAL_TO -> new Found(left, new OneSide(new Point(right)));
          case LESS_THAN, GREATER_THAN -> {
            T rightValueUnderTest = lookup.apply(right);
            var rightComparison = typedComparator.compare(target, rightValueUnderTest);
            yield switch (rightComparison) {
              case EQUAL_TO -> new FoundExhausted(right);
              case LESS_THAN, GREATER_THAN -> new NotFoundExhausted();
            };
          }
        };
      }
      case Split.TrueSplit(var left, int middle, var right) -> {
        T valueUnderTest = lookup.apply(middle);
        var comparison = typedComparator.compare(target, valueUnderTest);
        yield switch (comparison) {
          case EQUAL_TO -> new Found(middle, new TwoSided(left, right));
          case LESS_THAN -> new TooHigh(left);
          case GREATER_THAN -> new TooLow(right);
        };
      }
    };
  }

  /**
   * Binary search over a sorted list of integers.
   *
   * @param list   a sorted list of integers
   * @param target the target value to search for
   * @return an {@link Optional} containing the index of an occurrence of the target value in the list. Or, an empty
   * {@link Optional} if no occurrences could be found.
   */
  public static Optional<Integer> binarySearch(List<Integer> list, int target) {
      return binarySearch(list, TypedComparator.INT_COMPARATOR, target);
  }

  /**
   * Binary search over a sorted list of integers to produce a range of indices that all match the given "target"
   * integer.
   * <p>
   * In other words, the sorted list is expected to allow duplicates and you want to find the target value and all its
   * duplicate neighbors (if they exist). This forms a range. For example, given the list [1, 2, 2, 3], a search for
   * 2 would return the range of indices [1, 2].
   * <p>
   * The range is inclusive and zero-indexed.
   *
   * @param list a sorted list of integers
   * @param target the target value to search for
   * @return an {@link Optional} containing the index of an occurrence of the target value in the list. Or, an empty
   * {@link Optional} if no occurrences could be found.
   */
  public static Optional<dgroomes.algorithms.Range> binaryRangeSearch(List<Integer> list, int target) {
    var searcher = new AbstractBinaryRangeSearcher<>(list, target) {

      @Override
      protected Comparison compare(Integer target, Integer valueUnderTest) {
        return TypedComparator.INT_COMPARATOR.compare(target, valueUnderTest);
      }
    };

    var result = searcher.search();

    return result.map(internalRange -> Range.of(internalRange.low(), internalRange.high()));
  }

  /**
   * I'm struggling between calling this a "partition" or a "split" because partition is a strong, well-understood term
   * but I really want to model the "middle point" and its two neighbors (left and right). And that's not really a partition
   * right?
   */
  private sealed interface Split {

    record Point(int index) implements Split {}

    record PointPair(int left, int right) implements Split {}

    record TrueSplit(Range left, int middle, Range right) implements Split {}
  }

  /**
   * Split a range on a "middle" point. The result is three parts: a left side, a middle, and a right side.
   * <p>
   * Usefully, this method accommodates ranges without a middle (i.e. a point or a point pair).
   */
  private static Split split(Range range) {
    return switch (range) {
      // A point is not splittable.
      case Point(int index) -> new Split.Point(index);
      // A pair of points are not splittable.
      case PointPair(int left, int right) -> new Split.PointPair(left, right);

      case StretchRange(int low, int high) -> {
        int middle = low + (high - low) / 2;
        Range left = of(low, middle - 1);
        Range right = of(middle + 1, high);
        yield new Split.TrueSplit(left, middle, right);
      }
    };
  }
}
