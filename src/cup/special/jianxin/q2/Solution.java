package cup.special.jianxin.q2;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    public int[] analysisHistogram(int[] heights, int cnt) {
        Arrays.sort(heights);
        int min = Integer.MAX_VALUE;
        int minLeft = 0;
        for (int left = 0; left + cnt - 1 < heights.length; left++) {
            int right = left + cnt - 1;
            int sub = heights[right] - heights[left];
            if (sub < min) {
                min = sub;
                minLeft = left;
            }
        }
        int[] res = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            res[i] = heights[minLeft++];
        }
        return res;
    }
}
