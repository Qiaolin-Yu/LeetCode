package cup.DoubleWeek.cup83.q2;

/**
 * @author 1iin
 */
public class Solution {

    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        //f[n+1] =f[n]+n+1
        long[] map = new long[(int) (1e5 + 10)];
        for (int i = 1; i < map.length; i++) {
            if (i == 1) {
                map[1] = 1;
                continue;
            }
            map[i] = map[i - 1] + i;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                res += map[count];
                count = 0;
            }
        }
        if (count != 0) {
            res += map[count];
        }
        return res;
    }
}