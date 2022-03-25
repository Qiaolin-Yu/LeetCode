package cup.SingleWeek.cup269.q3;

/**
 * @author 1iin
 */
public class Solution {
    public int minimumDeletions(int[] nums) {
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        int res = Math.min(nums.length - Math.min(maxIndex, minIndex),
                Math.max(maxIndex, minIndex) + 1
        );
        int res2 = Math.min(nums.length - maxIndex + minIndex + 1,
                nums.length - minIndex + maxIndex + 1
        );
        return Math.min(res, res2);

    }
}
