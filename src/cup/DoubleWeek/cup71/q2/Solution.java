package cup.DoubleWeek.cup71.q2;

import java.util.ArrayList;

/**
 * @author 1iin
 */
public class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> more = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                less.add(nums[i]);
            } else if (nums[i] == pivot) {
                equal.add(nums[i]);
            } else {
                more.add(nums[i]);
            }
        }
        for (int i = 0; i < less.size(); i++) {
            res[i] = less.get(i);
        }
        for (int i = 0; i < equal.size(); i++) {
            res[i + less.size()] = equal.get(i);
        }
        for (int i = 0; i < more.size(); i++) {
            res[i + less.size() + equal.size()] = more.get(i);
        }
        return res;
    }
}
