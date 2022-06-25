package cup.special.cmbchina.q2;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    public int numFlowers(int[][] roads) {
        int[] degree = new int[roads.length + 1];
        for (int i = 0; i < roads.length; i++) {
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }
        Arrays.sort(degree);
        return degree[degree.length - 1] + 1;
    }
}
