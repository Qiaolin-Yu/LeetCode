package cup.SingleWeek.cup273.q3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer, int[]> map = new HashMap<>();
        long[] left = new long[arr.length];
        long[] right = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {
                int last = map.get(arr[i])[0];
                left[i] = left[last] + (long) map.get(arr[i])[1] * (long) (i - last);
            }
            map.put(arr[i], new int[]{i, map.getOrDefault(arr[i], new int[]{0, 0})[1] + 1});
        }
        map = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (map.get(arr[i]) != null) {
                int last = map.get(arr[i])[0];
                right[i] = right[last] + (long) map.get(arr[i])[1] * (long) (last - i);
            }
            map.put(arr[i], new int[]{i, map.getOrDefault(arr[i], new int[]{0, 0})[1] + 1});
        }
        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = left[i] + right[i];
        }
        return res;
    }
}
