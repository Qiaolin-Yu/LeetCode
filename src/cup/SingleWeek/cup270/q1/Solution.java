package cup.SingleWeek.cup270.q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 1iin
 */
public class Solution {
    Set<Integer> nums = new HashSet<>();
    int[] digits;

    public int[] findEvenNumbers(int[] digits) {
        this.digits = digits;
        dfs(0, new boolean[digits.length]);
        int[] arr = new int[nums.size()];
        int index = 0;
        for (int num : nums) {
            arr[index++] = num;
        }
        Arrays.sort(arr);
        return arr;
    }

    public void dfs(int x, boolean[] isVisited) {
        if (length(x) == 3) {
            if ((x & 1) == 0) {
                nums.add(x);
            }
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (x == 0 && digits[i] == 0 || isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            dfs(x * 10 + digits[i], isVisited);
            isVisited[i] = false;
        }
    }

    public int length(int num) {
        int len = 0;
        while (num > 0) {
            num /= 10;
            len++;
        }
        return len;
    }
}
