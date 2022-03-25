package cup.DoubleWeek.cup64.q3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 1iin
 */
public class Solution {
    List<int[]> list = new ArrayList<>();
    int[] pre;

    public int[] platesBetweenCandles(String s, int[][] queries) {
        list.add(new int[]{1, 2});
        char[] chars = s.toCharArray();
        int left = 0;
        while (left < chars.length) {
            int count = 0;
            if (chars[left] == '|') {
                int right = left + 1;
                while (right < chars.length && chars[right] != '|') {
                    count++;
                    right++;
                }
                if (right == chars.length) {
                    break;
                }
                int[] arr = new int[]{left, right, count};
                list.add(arr);
                left = right;
                continue;
            }
            left++;
        }
        pre = new int[list.size()];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + list.get(i)[2];
        }
        int[] res = new int[queries.length];
        list.get(0)[1] = list.size() > 1 ? list.get(1)[0] : 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = helper(queries[i]);
        }
        return res;
    }

    public int helper(int[] query) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (query[1] < list.get(mid)[1]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int left2 = 0;
        int right2 = list.size() - 1;
        while (left2 < right2) {
            int mid = left2 + (right2 - left2) / 2;
            if (query[0] > list.get(mid)[1]) {
                left2 = mid + 1;
            } else {
                right2 = mid;
            }
        }
        return Math.max(pre[left] - pre[left2], 0);
    }
}
