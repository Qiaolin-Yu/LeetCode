package cup.SingleWeek.cup303.q4;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> bitMap = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Integer.bitCount(nums[i]);
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            bitMap.put(nums[i], temp);
        }
        int[] arr = new int[set.size()];
        int index = 0;
        for (int a : set) {
            arr[index++] = bitMap.get(a);
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] * 2 < k) {
                break;
            } else {
                res++;
            }
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] + arr[i] < k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (arr[left] + arr[i] < k) {
                break;
            }
            res += (i - left) * 2L;
        }
        return res;
    }


}
