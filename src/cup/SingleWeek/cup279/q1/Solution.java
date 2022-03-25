package cup.SingleWeek.cup279.q1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * @author 1iin
 */
public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        odd.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        even.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = even.get(index2++);
            } else {
                nums[i] = odd.get(index1++);
            }
        }
        return nums;
    }
}
