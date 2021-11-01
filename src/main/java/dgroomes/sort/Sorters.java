package dgroomes.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Groomes on 9/28/2015.
 */
public class Sorters {

    static class ListPair<E extends Comparable> {
        List<E> leftList;
        List<E> rightList;

        public ListPair(List<E> leftList, List<E> rightList) {
            this.leftList = leftList;
            this.rightList = rightList;
        }
    }

    public static <E extends Comparable> List<E> mergeSort(List<E> list) {
        if (list.size() > 1) {
            ListPair<E> splitSorted = splitAndSort(list);
            return merge(splitSorted);
        } else {
            return list;
        }
    }

    private static <E extends Comparable> ListPair<E> splitAndSort(List<E> list) {
        if (list.size() <= 1) {
            throw new IllegalStateException("#splitAndSort takes lists of size 2 or greater, but was called with size 1 or 0.");
        } else {
            int middleIndex = list.size() / 2;
            List<E> leftList = list.subList(0, middleIndex);
            List<E> rightList = list.subList(middleIndex, list.size());
            return new ListPair<E>(mergeSort(leftList), mergeSort(rightList));
        }
    }

    /**
     * Takes a ListPair where its lists are ordered
     *
     * @param pair
     * @param <E>
     * @return
     */
    private static <E extends Comparable> List<E> merge(ListPair<E> pair) {
        List<E> combinedList = new ArrayList<>();
        int leftListIndex = 0;
        int rightListIndex = 0;
        int combinedSize = pair.leftList.size() + pair.rightList.size();
        while (combinedList.size() < combinedSize) {
            if (leftListIndex == pair.leftList.size()) {
                combinedList.addAll(pair.rightList.subList(rightListIndex, pair.rightList.size()));
            } else if (rightListIndex == pair.rightList.size()) {
                combinedList.addAll(pair.leftList.subList(leftListIndex, pair.leftList.size()));
            } else {
                E leftListLowestValue = pair.leftList.get(leftListIndex);
                E rightListLowestValue = pair.rightList.get(rightListIndex);
                if (leftListLowestValue.compareTo(rightListLowestValue) < 0) {
                    combinedList.add(leftListLowestValue);
                    leftListIndex++;
                } else {
                    combinedList.add(rightListLowestValue);
                    rightListIndex++;
                }
            }
        }
        return combinedList;
    }

    /**
     * Requires mutable list
     *
     * @param list
     * @param <E>
     * @return
     */
    public static <E extends Comparable> List<E> quickSort(List<E> list) {
        if (list.size() > 1) {
            quickSortInternal(list, 0, list.size() - 1);
        }
        return list;
    }

    public static <E extends Comparable> void quickSortInternal(List<E> list, int start, int end) {
        if (start < end) {
            int pivot = partition(list, start, end);
            quickSortInternal(list, start, pivot - 1);
            quickSortInternal(list, pivot + 1, end);
        }
    }

    private static <E extends Comparable> int partition(List<E> list, int start, int end) {
        int boundaryOfLessers = start;
        E pivot = list.get(end);

        // pivot from high index (meaning... push all of those lower than high to front and then put high at the end of the front....) todo read this comment it actually makes sense
        for (int i = boundaryOfLessers; i < end - 1; i++) {
            if (list.get(i).compareTo(pivot) < 0) {
                swap(list, boundaryOfLessers, i);
                boundaryOfLessers++;
            }
        }
        swap(list, boundaryOfLessers, end);
        return boundaryOfLessers;
    }

    private static <E> void swap(List<E> list, int indexA, int indexB) {
        E temp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, temp);
    }
}
