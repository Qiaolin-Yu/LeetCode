package cup.SingleWeek.cup286.q2;

import java.util.ArrayList;

/**
 * @author 1iin
 */
public class Solution {
    public int minDeletion(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        int index = 0;
        int res = 0;
        while (true) {
            if (index >= temp.size()) {
                break;
            }
            if (index % 2 == 0 && index + 1 < temp.size() && temp.get(index).equals(temp.get(index + 1))) {
                temp.remove(index + 1);
                res++;
                continue;
            }
            index++;
        }
        return temp.size() % 2 == 0 ? res : res + 1;
    }
}
