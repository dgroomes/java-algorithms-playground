package dgroomes.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dgroomes.algorithms.Sorters.mergeSort;
import static org.assertj.core.api.Assertions.assertThat;

public class SortersTest {

    @Test
    public void testMergeSort() throws Exception {
        assertThat(mergeSort(List.of(1, 3, 2, 4, 6, 1))).isEqualTo(List.of(1, 1, 2, 3, 4, 6));
    }

    @Test
    public void testMergeSort_oneEntry() throws Exception {
        assertThat(mergeSort(List.of(1))).isEqualTo(List.of(1));
    }

    @Test
    public void testMergeSort_twoEntries() throws Exception {
        assertThat(mergeSort(List.of(2, 1))).isEqualTo(List.of(1, 2));
    }

    @Test
    public void testQuickSort() throws Exception {
        assertThat(Sorters.quickSort(List.of(1, 3, 2, 4, 6, 1))).isEqualTo(List.of(1, 1, 2, 3, 4, 6));
    }

    @Test
    public void testQuickSort_oneEntry() throws Exception {
        assertThat(Sorters.quickSort(List.of(1))).isEqualTo(List.of(1));
    }

    @Test
    public void testQuickSort_twoEntries() throws Exception {
        assertThat(Sorters.quickSort(List.of(2, 1))).isEqualTo(List.of(1, 2));
    }
}
