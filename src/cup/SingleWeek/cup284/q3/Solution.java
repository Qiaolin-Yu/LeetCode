package cup.SingleWeek.cup284.q3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < Math.min(k + 1, nums.length); i++) {
            if (i == k - 1) {
                continue;
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
