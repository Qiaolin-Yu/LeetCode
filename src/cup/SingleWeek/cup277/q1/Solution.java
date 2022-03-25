package cup.SingleWeek.cup277.q1;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
            left++;
        }
        left++;
        while (right - 1 >= 0 && nums[right - 1] == nums[right]) {
            right--;
        }
        right--;
        return Math.max(right - left + 1, 0);
    }
}