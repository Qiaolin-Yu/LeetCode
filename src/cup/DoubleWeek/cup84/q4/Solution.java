package cup.DoubleWeek.cup84.q4;

/**
 * @author 1iin
 */
public class Solution {
    public long minimumReplacement(int[] nums) {
        int min = Integer.MAX_VALUE;
        long res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = Math.min(min, nums[i]);
                continue;
            }
            long count = nums[i] / min;
            if (nums[i] % min != 0) {
                count++;
            }
            res += count - 1;
            int temp = (int) (nums[i] / count);
            min = Math.min(min, temp);
        }
        return res;
    }
}
