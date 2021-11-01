package dgroomes.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by David Groomes on 9/28/2015.
 */
public class SortersTest {

    @Test
    public void testMergeSort() throws Exception {
        assertThat(Sorters.mergeSort(Arrays.<Integer>asList(1, 3, 2, 4, 6, 1))).isEqualTo(Arrays.<Integer>asList(1, 1, 2, 3, 4, 6));
    }

    @Test
    public void testMergeSort_oneEntry() throws Exception {
        assertThat(Sorters.mergeSort(Arrays.<Integer>asList(1))).isEqualTo(Arrays.<Integer>asList(1));
    }

    @Test
    public void testMergeSort_twoEntries() throws Exception {
        assertThat(Sorters.mergeSort(Arrays.<Integer>asList(2, 1))).isEqualTo(Arrays.<Integer>asList(1, 2));
    }

    @Test
    public void testQuickSort() throws Exception {
        assertThat(Sorters.quickSort(Arrays.<Integer>asList(1, 3, 2, 4, 6, 1))).isEqualTo(Arrays.<Integer>asList(1, 1, 2, 3, 4, 6));
    }

    @Test
    public void testQuickSort_oneEntry() throws Exception {
        assertThat(Sorters.quickSort(Arrays.<Integer>asList(1))).isEqualTo(Arrays.<Integer>asList(1));
    }

    @Test
    public void testQuickSort_twoEntries() throws Exception {
        assertThat(Sorters.quickSort(Arrays.<Integer>asList(2, 1))).isEqualTo(Arrays.<Integer>asList(1, 2));
    }
}
