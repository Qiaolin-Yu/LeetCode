package cup.DoubleWeek.cup67.q3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 1iin
 */
public class Solution {
    int[][] bombs;
    ArrayList<Set<Integer>> influence;

    public int maximumDetonation(int[][] bombs) {
        this.bombs = bombs;
        influence = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            influence.add(new HashSet<>());
            influence.get(i).add(i);
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (relation(i, j)) {
                    influence.get(i).add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < bombs.length; i++) {
            res = Math.max(dfs(i), res);
        }
        return res;

    }

    public boolean relation(int bomb1, int bomb2) {
        long x = Math.abs(bombs[bomb1][0] - bombs[bomb2][0]);
        long y = Math.abs(bombs[bomb1][1] - bombs[bomb2][1]);
        long r = bombs[bomb1][2];
        return x * x + y * y <= r * r;
    }

    public int dfs(int index) {
        Set<Integer> set = new HashSet<>(influence.get(index));
        Set<Integer> temp = new HashSet<>(set);
        while (true) {
            for (int val : set) {
                Set<Integer> valSet = new HashSet<>(influence.get(val));
                temp.addAll(valSet);
            }
            if (set.size() == temp.size()) {
                return set.size();
            }
            set = new HashSet<>(temp);
        }
    }
}
