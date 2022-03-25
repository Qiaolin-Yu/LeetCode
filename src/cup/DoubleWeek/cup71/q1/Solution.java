package cup.DoubleWeek.cup71.q1;


import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    public int minimumSum(int num) {
        int[] map = new int[4];
        int i = 0;
        while (num > 0) {
            map[i++] = num % 10;
            num /= 10;
        }
        Arrays.sort(map);
        int num1 = map[0] * 10 + map[3];
        int num2 = map[1] * 10 + map[2];
        return num1 + num2;
    }
}