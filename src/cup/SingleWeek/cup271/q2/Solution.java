package cup.SingleWeek.cup271.q2;

/**
 * @author 1iin
 */
public class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += (long) (max) - (long) min;
            }
        }
        return res;
    }
}
