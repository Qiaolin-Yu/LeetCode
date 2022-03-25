package cup.SingleWeek.cup281.q4;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public long coutPairs(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        Map<Integer, Integer> pre = new HashMap<>();
        for (int i = 1; i <= k / i; i++) {
            if (k % i == 0) {
                pre.put(i, pre.getOrDefault(i, 0) + 1);
                if (i != k / i) {
                    pre.put(k / i, pre.getOrDefault(k / i, 0) + 1);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int x = nums[j];
            if (x % k == 0) {
                res += j;
            } else {
                for (int key : pre.keySet()) {
                    long tmp = (long) x * key;
                    if (tmp % k == 0 &&  map.getOrDefault((int) tmp / k, 0) != 0) {
                        res += map.get((int) tmp / k);
                    }
                }
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
            System.out.println(res);
        }
        return res;
    }
}
