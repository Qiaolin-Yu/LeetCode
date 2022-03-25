package cup.DoubleWeek.cup70.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long[] pre = new long[differences.length];
        long min = 0;
        long max = 0;
        for (int i = 0; i < differences.length; i++) {
            if (i == 0) {
                pre[i] = differences[i];
            } else {
                pre[i] = pre[i - 1] + differences[i];
            }
            min = Math.min(min, pre[i]);
            max = Math.max(max, pre[i]);
        }
        long interval = max - min;
        long outer = upper - lower;
        if (outer - interval + 1 > 0) {
            return (int) (outer - interval + 1);
        }
        return 0;
    }
}
