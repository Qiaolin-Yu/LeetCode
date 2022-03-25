package cup.DoubleWeek.cup70.q1;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        int count = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (count == 2) {
                count = 0;
                continue;
            }
            res += cost[i];
            count++;
        }
        return res;
    }
}
