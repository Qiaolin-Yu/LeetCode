package cup.DoubleWeek.cup73.q1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }
        int max = 0;
        int maxTime = 0;
        for (int te : map.keySet()) {
            if (map.get(te) > maxTime) {
                max = te;
                maxTime = map.get(te);
            }
        }
        return max;
    }
}
