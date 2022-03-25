package cup.SingleWeek.cup277.q3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) != 1) {
                continue;
            }
            if (map.getOrDefault(key - 1, 0) == 0 && map.getOrDefault(key + 1, 0) == 0) {
                list.add(key);
            }
        }
        return list;
    }
}
