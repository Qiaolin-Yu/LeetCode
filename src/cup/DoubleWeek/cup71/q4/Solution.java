package cup.DoubleWeek.cup71.q4;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 1iin
 */
public class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        Map<Integer, Long> map1 = new HashMap<>();
        Map<Integer, Long> map2 = new HashMap<>();
        long sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            heap.add(nums[i]);
        }
        map1.put(n - 1, sum);
        for (int i = n; i < 2 * n; i++) {
            if (nums[i] < heap.peek()) {
                int po = heap.poll();
                heap.add(nums[i]);
                sum -= po;
                sum += nums[i];
            }
            map1.put(i, sum);
        }


        PriorityQueue<Integer> heap2 = new PriorityQueue<>();
        sum = 0;
        for (int i = nums.length - 1; i >= 2 * n; i--) {
            sum +=nums[i];
            heap2.add(nums[i]);
        }
        map2.put(2 * n - 1, sum);
        for (int i = 2 * n - 1; i >= n; i--) {
            if (nums[i] > heap2.peek()) {
                int po = heap2.poll();
                heap2.add(nums[i]);
                sum -= po;
                sum += nums[i];
            }
            map2.put(i - 1, sum);
        }
        long res = Long.MAX_VALUE;
        for (int i = n - 1; i <= 2 * n - 1; i++) {
            long temp = map1.get(i)-map2.get(i);
            res = Math.min(res, temp);

        }
        return res;
    }

}
