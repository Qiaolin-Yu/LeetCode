package cup.DoubleWeek.cup84.q2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    public long countBadPairs(int[] nums) {
        Map<Long, Integer> counter = new HashMap<>();
        long total = (long) nums.length * (long) (nums.length - 1) / 2;
        long temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += counter.getOrDefault((long) i - (long) nums[i], 0);
            counter.put((long) i - (long) nums[i], counter.getOrDefault((long) i - (long) nums[i], 0) + 1);
        }
        return total - temp;
    }
}
