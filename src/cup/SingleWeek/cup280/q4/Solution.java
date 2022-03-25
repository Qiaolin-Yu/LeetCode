package cup.SingleWeek.cup280.q4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    Map<int[], Integer> memo;
    int[] nums;
    int numSlots;

    public int maximumANDSum(int[] nums, int numSlots) {
        this.numSlots = numSlots;
        this.nums = nums;
        memo = new HashMap<>();
        int[] info = new int[nums.length];
        Arrays.fill(info, -1);
        return process(info, 0);
    }

    public int process(int[] info, int index) {
        if (index == nums.length) {
            return 0;
        }
        if (memo.containsKey(info)) {
            return memo.get(info);
        }
        int[] slots = new int[numSlots + 1];
        for (int i = 0; i < info.length; i++) {
            if (info[i] == -1) {
                continue;
            }
            slots[info[i]]++;
        }
        int max = 0;
        int[] newInfo = new int[info.length];
        for (int j = 0; j < info.length; j++) {
            newInfo[j] = info[j];
        }
        for (int i = 1; i < slots.length; i++) {
            if (slots[i] == 2) {
                continue;
            }
            newInfo[index] = i;
            max = Math.max(max, (nums[index] & i) + process(newInfo, index + 1));
            newInfo[index] = -1;
        }
        System.out.println(Arrays.toString(info) + " " + max);
        for (int j = 0; j < info.length; j++) {
            newInfo[j] = info[j];
        }
        memo.put(newInfo, max);
        return max;
    }

}
