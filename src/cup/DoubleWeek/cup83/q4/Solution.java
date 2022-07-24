package cup.DoubleWeek.cup83.q4;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Map<Integer, Integer> position = new HashMap<>();
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < rolls.length; i++) {
            temp.add(rolls[i]);
        }
        for (int i = 1; i <= k; i++) {
            if (!temp.contains(i)) {
                return 1;
            }
        }
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return position.get(o2) - position.get(o1) == 0 ? o1 - o2 : position.get(o2) - position.get(o1);
            }
        });
        for (int i = 1; i <= k; i++) {
            position.put(i, rolls.length);
            treeSet.add(i);
        }

        int[] pre = new int[rolls.length];
        for (int i = rolls.length - 1; i >= 0; i--) {
            pre[i] = position.get(treeSet.first());
            treeSet.remove(rolls[i]);
            position.put(rolls[i], i);
            treeSet.add(rolls[i]);
        }
        Set<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < rolls.length; i++) {
            if (set.contains(rolls[i])) {
                continue;
            }
            set.add(rolls[i]);
            int pos = i;
            int count = 1;
            while (pos <= rolls.length - 1) {
                pos = pre[pos];
                count++;
            }
            res = Math.min(res, count);
        }
        return res;
    }
}
