package cup.SingleWeek.cup276.q3;

/**
 * @author 1iin
 */
public class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        for (int i = dp.length - 1; i >= 0; i--) {
            long point = questions[i][0];
            long next = i + questions[i][1] + 1;
            dp[i] = next >= questions.length ? point : point + dp[(int) next];
            if (i + 1 < questions.length) {
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }
}
