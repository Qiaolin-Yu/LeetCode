package cup.SingleWeek.cup280.q3;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    int[] beans;
    long[] preSum;
    long[] memo;

    public long minimumRemoval(int[] beans) {
        this.beans = beans;
        Arrays.sort(beans);
        preSum = new long[beans.length];
        memo = new long[beans.length];
        Arrays.fill(memo, -1);
        for (int i = 0; i < beans.length; i++) {
            if (i == 0) {
                preSum[i] = beans[i];
            } else {
                preSum[i] = beans[i] + preSum[i - 1];
            }
        }
        return process(0);
    }

    public long process(int index) {
        if (index == beans.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        long choose1 = beans[index] + process(index + 1);
        long choose2 = preSum[beans.length - 1] - preSum[index] - (long) beans[index] * (long) (beans.length - 1 - index);
        memo[index] = Math.min(choose1, choose2);
        return memo[index];
    }
}
