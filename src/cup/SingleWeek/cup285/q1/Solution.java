package cup.SingleWeek.cup285.q1;

/**
 * @author 1iin
 */
public class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for (int left = 0; left < nums.length; ) {
            int right = left;
            while (right + 1 < nums.length && nums[right + 1] == nums[right]) {
                right++;
            }
            if (left == 0 || right == nums.length - 1) {
                left = right + 1;
                continue;
            }
            if (nums[left] > nums[left - 1] && nums[left] > nums[right + 1]) {
                count++;
            } else if (nums[left] < nums[left - 1] && nums[left] < nums[right + 1]) {
                count++;
            }
            left = right + 1;
        }
        return count;
    }
}
