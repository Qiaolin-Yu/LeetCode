package cup.DoubleWeek.cup72.q2;

/**
 * @author 1iin
 */
public class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            return new long[]{};
        }
        long mid = num / 3;
        long left = mid - 1;
        long right = mid + 1;
        return new long[]{left, mid, right};
    }
}
