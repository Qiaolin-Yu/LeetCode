package cup.DoubleWeek.cup83.q3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author 1iin
 */
public class NumberContainers {
    Map<Integer, Integer> map;
    Map<Integer, TreeSet<Integer>> record;

    public NumberContainers() {
        map = new HashMap<>();
        record = new HashMap<>();
    }


    public void change(int index, int number) {
        if (map.containsKey(index)) {
            int temp = map.get(index);
            record.get(temp).remove(index);
        }
        map.put(index, number);
        if (!record.containsKey(number)) {
            record.put(number, new TreeSet<>());
        }
        record.get(number).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> treeSet = record.get(number);
        if (treeSet == null || treeSet.size() == 0) {
            return -1;
        }
        return treeSet.first();
    }
}
