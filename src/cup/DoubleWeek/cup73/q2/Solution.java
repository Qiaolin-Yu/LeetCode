package cup.DoubleWeek.cup73.q2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 1iin
 */
public class Solution {
    int[] mapping;

    public int[] sortJumbled(int[] mapping, int[] nums) {
        this.mapping = mapping;
        Integer[] num = new Integer[nums.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = nums[i];
        }
        Arrays.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return parse(o1) - parse(o2);
            }
        });
        for (int i = 0; i < num.length; i++) {
            nums[i] = num[i];
        }
        return nums;
    }

    public int parse(int a) {
        if (a == 0) {
            return mapping[a];
        }
        int res = 0;
        int count = 1;
        while (a > 0) {
            int temp = mapping[a % 10];
            res += count * temp;
            a /= 10;
            count *= 10;
        }
        return res;
    }
}
