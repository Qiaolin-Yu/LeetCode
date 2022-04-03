package cup.SingleWeek.cup287.q2;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            map.put(winner, map.getOrDefault(winner, 0));
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int key : map.keySet()) {
            if (map.get(key) == 0) {
                res.get(0).add(key);
            } else if (map.get(key) == 1) {
                res.get(1).add(key);
            }
        }
        Collections.sort(res.get(0));
        Collections.sort(res.get(1));
        return res;
    }
}
