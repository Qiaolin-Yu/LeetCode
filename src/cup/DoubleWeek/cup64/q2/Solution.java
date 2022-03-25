package cup.DoubleWeek.cup64.q2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 1iin
 */
public class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        int[][] max = new int[events.length][2];
        for (int i = events.length - 1; i >= 0; i--) {
            if (i == events.length - 1) {
                max[i][0] = events[i][0];
                max[i][1] = events[i][2];
                continue;
            }
            max[i][0] = events[i][0];
            max[i][1] = Math.max(max[i + 1][1], events[i][2]);
        }
        int res = 0;
        for (int i = 0; i < events.length; i++) {
            int left = i + 1;
            int right = events.length - 1;
            if (events[i][1] >= events[right][0]) {
                res = Math.max(res, events[i][2]);
                continue;
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (max[mid][0] <= events[i][1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            res = Math.max(res, events[i][2] + max[left][1]);
        }
        return res;
    }
}
