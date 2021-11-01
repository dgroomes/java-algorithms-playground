package dgroomes.questions;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Identify duplicate values in a list.
 * <p>
 * E.g. for the list [1, 3, 2, 1, 3, 3] identify the values 1 and 3 as having duplicate entries.
 */
@FunctionalInterface
public interface IdentifyDuplicates {

    /**
     * Identify values with duplicate entries in a list.
     *
     * @param list the list of integers values from which to identify duplicate entries
     * @return the duplicate values
     */
    Stack<Integer> identifyDuplicates(List<Integer> list);

    static List<Integer> fixedList() {
        return List.of(1, 3, 2, 1, 3, 3);
    }

    /**
     * Generate the list-under-test using a fixed seed and the Random class. Why fixed seed? For reproducible performance
     * test results.
     *
     * @param listSize        the size of the list
     * @param valueUpperBound the upper bound (exclusive) of the integer values in the list. Use a lower value for more value collisions (i.e. duplicates)
     * @return the generated list of integers
     */
    static List<Integer> generateList(int listSize, int valueUpperBound) {
        var random = new Random(1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(valueUpperBound));
        }
        return list;
    }

    /**
     * Identify duplicates using a brute force algorithm. It applies no sorting and does not use an optimal data structure.
     */
    IdentifyDuplicates BRUTE_FORCE = list -> {
        var duplicates = new Stack<Integer>();

        List<Integer> continuallyReducedList;

        while (!list.isEmpty()) {
            var foundDuplicate = false;
            int underInvestigation = list.get(0);
            continuallyReducedList = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                int other = list.get(i);
                if (underInvestigation == other) {
                    if (foundDuplicate) { // We earlier identified this value as a duplicate. Continue.
                        continue;
                    } // Found a duplicate!
                    foundDuplicate = true;
                    duplicates.push(underInvestigation);
                } else {
                    continuallyReducedList.add(other);
                }
            }
            list = continuallyReducedList;
        }
        return duplicates;
    };

    /**
     * Identify duplicates using an algorithm that first sorts the list.
     */
    IdentifyDuplicates SORTING = list -> {
        var sorted = list.stream().sorted().collect(Collectors.toList());

        var duplicates = new Stack<Integer>();

        var underInvestigation = -1; // The original list contains only positive integers so we are safe to use -1 as a dummy. No risk of accidentally identifying -1 as a duplicated value.
        var recentDuplicate = -1;

        // Find duplicates by iterating over the sorted list.
        //
        // Note: it's probably better to use a while loop here because we want more control than is offered by the enhanced
        // for loop. The enhanced for loop only gives us one list item at a time and no index. By definition though, we need
        // the context of the current and previous element to execute the algorithm. Consider a while loop or a functional
        // alternative with 'reduce'.
        for (int i : sorted) {
            if (i == recentDuplicate) continue;
            if (i != underInvestigation) {
                underInvestigation = i;
                continue;
            }

            // Found a duplicate entry for this value!
            duplicates.push(i);
            recentDuplicate = i;
        }

        return duplicates;
    };

    /**
     * Execute the duplicate-finding algorithm for the given list
     *
     * @param list the list for which to execute the
     */
    default void execute(List<Integer> list) {
        var duplicates = identifyDuplicates(list);
        System.out.printf("Found %d duplicates%n", duplicates.size());
        System.out.printf("Duplicates: %s", duplicates);
    }

    /**
     * Metadata about an execution of the algorithm
     */
    record ExecutionResult(int listSize, int duplicates, Duration duration) {

        public Duration durationPerEntry() {
            return duration.dividedBy(listSize);
        }
    }

    /**
     * Exec the algorithm over a series of increasingly large lists. How slow does the algorithm get as the list size
     * grows?
     */
    default void largeLists() {

        var listSizes = List.of(
                100,
                1_000,
                10_000,
                100_000);

        listSizes.stream()
                .map(listSize -> {
                    var list = generateList(listSize, listSize);
                    var start = Instant.now();
                    var duplicates = identifyDuplicates(list);
                    var end = Instant.now();
                    var duration = Duration.between(start, end);
                    return new ExecutionResult(list.size(), duplicates.size(), duration);
                })
                .forEach(r -> {
                    System.out.printf("List size: %7d\tduplicates: %4d\t\tduration: %14s\t\tdurationPerEntry: %s%n",
                            r.listSize, r.duplicates, r.duration, r.durationPerEntry());
                });
    }

    /**
     * Exec the algorithm over a short list.
     */
    default void shortList() {
        var dupes = identifyDuplicates(IdentifyDuplicates.generateList(40, 40));
        var sortedDupes = dupes.stream().sorted().collect(Collectors.toList());
        System.out.printf("Duplicates: %s%n", sortedDupes);
    }
}
