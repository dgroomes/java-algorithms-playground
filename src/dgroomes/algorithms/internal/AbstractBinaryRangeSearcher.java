package dgroomes.algorithms.internal;

import dgroomes.algorithms.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import static dgroomes.algorithms.BinarySearchStepResult.*;
import static dgroomes.algorithms.BinarySearchStepResult.Unsearched.OneSide;
import static dgroomes.algorithms.BinarySearchStepResult.Unsearched.TwoSided;

/**
 * A generic binary search implementation to find all matches (a range) of a target value in a list.
 * <p>
 * Note: I tried pulling this out into a "functional" method, like {@link BinarySearch#binarySearch} but it was more
 * verbose than this class. I think because this algorithm keeps track of a decent amount of state, like the "match range"
 * and the "unsearched ranges" queue that it works well as a class. I think this is a good compromise because we're
 * still getting lots of leverage out of the {@link BinarySearch#binarySearchStep} functional building block.
 *
 * @param <T>
 */
public abstract class AbstractBinaryRangeSearcher<T> {

  private final List<T> list;
  private final T target;
  private final Queue<Range> unsearchedRanges = new LinkedList<>();
  private Range matchRange;

  public AbstractBinaryRangeSearcher(List<T> list, T target) {
    this.list = list;
    this.target = target;
  }

  public Optional<Range> search() {
    int size = list.size();
    if (size == 0) {
      return Optional.empty();
    }

    {
      Range initialRange = Range.of(0, size - 1);
      unsearchedRanges.add(initialRange);
    }

    while (!unsearchedRanges.isEmpty()) {
      Range toSearch = unsearchedRanges.remove();
      BinarySearchStepResult stepResult = BinarySearch.binarySearchStep(toSearch, list::get, this::compare, target);

      switch (stepResult) {
        case Found(int index, Unsearched unsearched) -> {
          matchRange = Range.extend(matchRange, index);
          switch (unsearched) {
            case TwoSided(var left, var right) -> {
              addUnsearchedRange(left);
              addUnsearchedRange(right);
            }
            case OneSide(var range) -> addUnsearchedRange(range);
          }
        }
        case FoundExhausted(int index) -> matchRange = Range.extend(matchRange, index);
        case NotFoundExhausted() -> {
        }
        case TooHigh(var range) -> addUnsearchedRange(range);
        case TooLow(var range) -> addUnsearchedRange(range);
      }
    }

    return Optional.ofNullable(matchRange);
  }

  /**
   * In the style of {@link TypedComparator}, return a {@link java.util.Comparator} that represents the comparison
   * result when comparing "target" to the "value-under-test".
   * <p>
   * For example, for a "target" of 3 and "value-under-test" of 5, the comparison yields {@link Comparison#LESS_THAN}.
   */
  protected abstract Comparison compare(T target, T valueUnderTest);

  private void addUnsearchedRange(Range range) {
    if (matchRange != null && matchRange.contains(range)) {
      return;
    }
    unsearchedRanges.add(range);
  }
}
