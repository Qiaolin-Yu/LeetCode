package cup.DoubleWeek.cup84.q1;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            if (map.containsKey(items2[i][0])) {
                map.put(items2[i][0], map.get(items2[i][0]) + items2[i][1]);
                continue;
            }
            map.put(items2[i][0], items2[i][1]);
        }
        for (int key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(key);
            temp.add(map.get(key));
            res.add(temp);
        }
        res.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        return res;
    }
}
