package cup.DoubleWeek.cup67.q1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 1iin
 */
public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            } else {
                int a = priorityQueue.poll();
                priorityQueue.offer(Math.max(a, nums[i]));
            }
        }
        while (priorityQueue.size() > 0) {
            int a = priorityQueue.poll();
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) > 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                res[index++] = nums[i];
            }
            if (index == res.length) {
                return res;
            }
        }
        return res;
    }
}
