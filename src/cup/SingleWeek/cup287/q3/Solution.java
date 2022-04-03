package cup.SingleWeek.cup287.q3;

/**
 * @author 1iin
 */
public class Solution {
    int[] candies;
    long k;

    public int maximumCandies(int[] candies, long k) {
        this.candies = candies;
        this.k = k;
        int left = 0;
        int right = (int) (1e7 + 10);
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(mid)) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int num) {
        if (num == 0) {
            return true;
        }
        long count = 0;
        for (int i = 0; i < candies.length; i++) {
            count += candies[i] / num;
        }
        return count >= k;
    }
}
