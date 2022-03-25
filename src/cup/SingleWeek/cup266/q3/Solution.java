package cup.SingleWeek.cup266.q3;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for (int i = 0; i < quantities.length; i++) {
            max = Math.max(max, quantities[i]);
        }
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(mid, n, quantities)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isValid(int max, int n, int[] quantities) {
        for (int i = 0; i < quantities.length; i++) {
            n -= Math.ceil((double) quantities[i] / (double) max);
            if (n < 0) {
                return false;
            }
        }
        return true;
    }
}
