package cup.SingleWeek.cup272.q4;

import java.util.ArrayList;

/**
 * @author 1iin
 */
public class Solution {
    public int kIncreasing(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arrayList.add(new ArrayList<>());
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            arrayList.get(i % k).add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            res += help(arrayList.get(i));
        }
        return res;
    }

    public int help(ArrayList<Integer> list) {
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int end = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= dp[end]) {
                dp[++end] = nums[i];
                continue;
            }
            if (nums[i] < dp[end]) {
                int left = 1;
                int right = end;
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (nums[i] >= dp[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = nums[i];
            }
        }
        return nums.length - end;
    }

}

