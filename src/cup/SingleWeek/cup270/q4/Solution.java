package cup.SingleWeek.cup270.q4;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            if (map.get(pairs[i][0]) == null) {
                map.put(pairs[i][0], new ArrayList<>());
            }
            map.get(pairs[i][0]).add(i);
        }
        Set<Integer> set = new HashSet<>();
        int[][] res = new int[pairs.length][pairs[0].length];
        int start = 0;
        for (int i = 0; i < res.length; i++) {
            set.add(pairs[i][1]);
        }
        for (int i = 0; i < res.length; i++) {
            if (!set.contains(pairs[i][0])) {
                start = i;
            }
        }
        res[0] = pairs[start];
        System.out.println(start);
        for (int i = 1; i < res.length; i++) {
            ArrayList<Integer> list = map.get(res[i - 1][1]);
            if (list.get(0) == start) {
                list.remove(0);
            }
            res[i] = pairs[list.get(0)];
            list.remove(0);
        }
        return res;
    }
}