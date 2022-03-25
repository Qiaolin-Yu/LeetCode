package cup.SingleWeek.cup284.q1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 1iin
 */
public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - k, 0); j <= i + k && j < nums.length; j++) {
                if (nums[j] == key) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
