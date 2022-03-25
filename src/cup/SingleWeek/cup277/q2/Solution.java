package cup.SingleWeek.cup277.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr1 = new int[nums.length / 2];
        int[] arr2 = new int[nums.length / 2];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                arr1[index1++] = nums[i];
            } else {
                arr2[index2++] = nums[i];
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if ((i & 1) == 0) {
                res[i] = arr1[i / 2];
            } else {
                res[i] = arr2[i / 2];
            }
        }
        return res;
    }
}
