package cup.SingleWeek.cup265.q3;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(start);
        set.add(start);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int now = queue.poll();
                size--;
                if (now == goal) {
                    return count;
                }
                for (int i = 0; i < nums.length; i++) {
                    int[] temp = new int[]{now + nums[i], now - nums[i], now ^ nums[i]};
                    for (int opt : temp) {
                        if (opt == goal) {
                            return count + 1;
                        }
                        if (isValid(opt) && !set.contains(opt)) {
                            set.add(opt);
                            queue.offer(opt);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public boolean isValid(int num) {
        return num >= 0 && num <= 1000;
    }
}
