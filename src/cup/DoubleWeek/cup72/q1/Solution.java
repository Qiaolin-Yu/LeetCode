package cup.DoubleWeek.cup72.q1;

/**
 * @author 1iin
 */
public class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i == j || i * j % k != 0 || nums[i] != nums[j]) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}
