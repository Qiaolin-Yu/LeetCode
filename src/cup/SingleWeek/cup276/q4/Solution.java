package cup.SingleWeek.cup276.q4;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author 1iin
 */
public class Solution {
    int[] batteries;
    int n;
    long rest;

    public long maxRunTime(int n, int[] batteries) {
        this.batteries = batteries;
        this.n = n;
        Arrays.sort(batteries);
        long sum = 0;
        for (int i = 0; i < batteries.length; i++) {
            sum += batteries[i];
        }
        rest = 0;
        for (int i = batteries.length - n - 1; i >= 0; i--) {
            rest += batteries[i];
        }
        long right = sum / n;
        long left = batteries[0];
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(long target) {
        long temp = rest;
        for (int i = batteries.length - 1; i >= batteries.length - n; i--) {
            if (batteries[i] < target) {
                temp -= target - batteries[i];
            }
            if (temp < 0) {
                return false;
            }
        }
        return true;
    }
}
