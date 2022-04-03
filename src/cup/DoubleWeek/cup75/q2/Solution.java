package cup.DoubleWeek.cup75.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int triangularSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int length = nums.length - i;
            for (int j = 0; j < length - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }
}
