package cup.SingleWeek.cup286.q4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 1iin
 */
public class Solution {
    List<List<Integer>> piles;
    List<List<Integer>> pre;
    int[][] memo;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.piles = piles;
        memo = new int[k + 1][piles.size()];
        pre = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            pre.add(new ArrayList<>());
            for (int j = 0; j < piles.get(i).size(); j++) {
                if (j == 0) {
                    pre.get(i).add(piles.get(i).get(j));
                } else {
                    int temp = pre.get(i).get(j - 1) + piles.get(i).get(j);
                    pre.get(i).add(temp);
                }
            }
        }
        return process(k, 0);
    }

    public int process(int k, int index) {
        if (k == 0 || index == piles.size()) {
            return 0;
        }
        if (memo[k][index] != 0) {
            return memo[k][index];
        }
        int res = Integer.MIN_VALUE;
        for (int j = 0; j <= Math.min(k, piles.get(index).size()); j++) {
            if (j == 0) {
                res = Math.max(res, process(k, index + 1));
                continue;
            }
            res = Math.max(res, pre.get(index).get(j - 1) + process(k - j, index + 1));
        }

        memo[k][index] = res;
        return res;
    }
}
