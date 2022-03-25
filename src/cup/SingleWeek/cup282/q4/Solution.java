package cup.SingleWeek.cup282.q4;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        long[] pre = new long[numLaps + 1];
        for (int i = 1; i <= numLaps; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < tires.length; j++) {
                min = Math.min(min, tires[j][0] * (long) (1 - Math.pow(tires[j][1], i)) / (1 - tires[j][1]));
            }
            pre[i] = min;
        }
        long[] dp = new long[numLaps + 1];
        Arrays.fill(dp, (long) 1e13);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + pre[i - j]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j] + changeTime + pre[i - j]);
                }
            }
        }
        return (int) dp[numLaps];
    }

}