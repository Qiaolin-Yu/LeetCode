package cup.SingleWeek.cup282.q3;

/**
 * @author 1iin
 */
public class Solution {
    int[] time;

    public long minimumTime(int[] time, int totalTrips) {
        this.time = time;
        long left = 0;
        long right = (long) totalTrips * time[0];
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (helper(mid) < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public long helper(long a) {
        long res = 0;
        for (int i = 0; i < time.length; i++) {
            long temp = a / time[i];
            res += temp;
        }
        return res;
    }
}
