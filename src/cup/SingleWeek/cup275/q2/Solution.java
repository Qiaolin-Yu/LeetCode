package cup.SingleWeek.cup275.q2;

/**
 * @author 1iin
 */
public class Solution {

    public int minSwaps(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res1 = 0;
        while (left < right) {
            if (nums[left] == 1 && (left == 0 || nums[left - 1] == 1)) {
                left++;
                continue;
            }
            if (nums[left] == 0 && left > 0 && nums[left - 1] == 1) {
                while (left < right && nums[right] != 1) {
                    right--;
                }
                if (left < right) {
                    nums[left] = 1;
                    nums[right] = 0;
                    left++;
                    res1++;
                } else {
                    break;
                }
            } else {
                left++;
            }

        }
        int res2 = 0;
        int total = 0;
        left = 0;
        right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                total++;
            }
        }
        while (left < right && total > 0) {
            if (nums[left] == 0) {
                res2++;
                total--;
                left++;
                continue;
            }
            if (nums[right] == 0) {
                res2++;
                total--;
                right--;
                continue;
            }
            if (nums[left] == 1) {
                left++;
                total--;
            }
            if (nums[right] == 1) {
                right--;
                total--;
            }
        }
        return Math.min(res1, res2);
    }
}
