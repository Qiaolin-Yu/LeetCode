package cup.SingleWeek.cup273.q4;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int k2 = 0;
        for (int i = 1; i <= nums.length / 2; i++) {
            boolean flag = true;
            k2 = nums[i] - nums[0];
            if ((k2 & 1) == 1 || k2 == 0) {
                continue;
            }
            Map<Integer, Integer> temp = new HashMap<>(map);
            temp.put(nums[i], temp.get(nums[i]) - 1);
            temp.put(nums[0], temp.get(nums[0]) - 1);
            for (int j = 1; j < nums.length; j++) {
                if (temp.get(nums[j]) == 0) {
                    continue;
                }
                temp.put(nums[j], temp.get(nums[j]) - 1);
                if (temp.getOrDefault(nums[j] + k2, 0) == 0) {
                    flag = false;
                    break;
                }
                temp.put(nums[j] + k2, temp.get(nums[j] + k2) - 1);
            }
            if (flag) {
                break;
            }
        }
        Map<Integer, Integer> temp = new HashMap<>(map);
        temp.put(nums[0] + k2, temp.get(nums[0] + k2) - 1);
        temp.put(nums[0], temp.get(nums[0]) - 1);
        int[] res = new int[nums.length / 2];
        res[0] = nums[0] + k2 / 2;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (temp.get(nums[i]) == 0) {
                continue;
            }
            temp.put(nums[i], temp.get(nums[i]) - 1);
            temp.put(nums[i] + k2, temp.get(nums[i] + k2) - 1);
            res[index++] = nums[i] + k2 / 2;
        }
        return res;
    }
}
