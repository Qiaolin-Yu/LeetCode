package cup.SingleWeek.cup269.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] pre = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                pre[i] = nums[i];
            } else {
                pre[i] = nums[i] + pre[i - 1];
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - k < 0 || i + k >= nums.length) {
                res[i] = -1;
                continue;
            }
            res[i] = (int) (i - k == 0 ? pre[i + k] / (2 * k + 1) : (pre[i + k] - pre[i - k - 1]) / (2 * k + 1));
        }
        return res;
    }
}
