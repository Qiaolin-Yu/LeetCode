package cup.SingleWeek.cup272.q3;

/**
 * @author 1iin
 */
public class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        int left = 0;
        int right = 0;
        while (left < prices.length) {
            while (right + 1 < prices.length && prices[right + 1] == prices[right] - 1) {
                right++;
            }
            res += help(right - left + 1);
            left = right + 1;
            right = left;
        }
        return res;
    }

    public long help(int length) {
        return (long) length * (long) (length + 1) / 2;
    }
}
