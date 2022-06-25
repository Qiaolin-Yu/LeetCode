package cup.DoubleWeek.cup77.q2;

/**
 * @author 1iin
 */
public class Solution {
    long[] pre;

    public int minimumAverageDifference(int[] nums) {
        pre = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                pre[i] = nums[i];
                continue;
            }
            pre[i] = pre[i - 1] + nums[i];
        }
        long min = Long.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long temp;
            if (i == nums.length - 1) {
                temp = Math.abs(sum(0, i) / (i + 1));
            } else {
                temp = Math.abs(sum(0, i) / (i + 1) - sum(i + 1, nums.length - 1) / (nums.length - i - 1));
            }
            if (temp < min) {
                res = i;
                min = temp;
            }
        }
        return res;
    }

    public long sum(int left, int right) {
        if (left == 0) {
            return pre[right];
        }
        return pre[right] - pre[left - 1];
    }
}
