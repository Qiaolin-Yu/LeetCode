package cup.SingleWeek.cup305.q3;

/**
 * @author 1iin
 */
public class Solution {
    int[] nums;
    int[] memo;

    public boolean validPartition(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        return dfs(0);
    }

    public boolean dfs(int index) {
        if (index == nums.length) {
            return true;
        }
        if (memo[index] != 0) {
            return memo[index] == 1;
        }
        boolean choose1 = index < nums.length - 1 && nums[index] == nums[index + 1];
        boolean choose2 = index < nums.length - 2 && nums[index] == nums[index + 1] && nums[index] == nums[index + 2];
        boolean choose3 = index < nums.length - 2 && nums[index] + 1 == nums[index + 1] && nums[index] + 2 == nums[index + 2];
        boolean res = false;
        if (choose1) {
            res = dfs(index + 2);
        }
        if (res) {
            memo[index] = 1;
            return true;
        }
        if (choose2) {
            res = dfs(index + 3);
        }
        if (res) {
            memo[index] = 1;
            return true;
        }
        if (choose3) {
            res = dfs(index + 3);
        }
        memo[index] = res ? 1 : 2;
        return res;
    }
}
