package dgroomes;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    public static <T> List<List<T>> partitionList(List<T> list, int sizeOfFullSizedSubLists) {
        List<List<T>> partitionedLists = new ArrayList<>();
        int numberOfFullSizedSubLists = list.size() / sizeOfFullSizedSubLists;
        for (int i = 0; i < numberOfFullSizedSubLists; i++) {
            partitionedLists.add(list.subList(i * sizeOfFullSizedSubLists, (i + 1) * sizeOfFullSizedSubLists));
        }
        int remainder = list.size() % sizeOfFullSizedSubLists;
        if (remainder > 0) {
            partitionedLists.add(list.subList(numberOfFullSizedSubLists * sizeOfFullSizedSubLists, remainder));
        }
        return partitionedLists;
    }

}
