package cup.DoubleWeek.cup70.q4;

/**
 * @author 1iin
 */
public class Solution {
    public int numberOfWays(String corridor) {
        char[] chars = corridor.toCharArray();
        long res = 1;
        int left = 0;
        long mod = (long) (1e9 + 7);

        int count = 0;
        while (left < chars.length) {
            if (chars[left] == 'S') {
                count++;
            }
            if (count == 2) {
                int right = left;
                while (right + 1 < chars.length && chars[right + 1] == 'P') {
                    right++;
                }
                if (right == chars.length - 1) {
                    return (int) res;
                }
                int length = right - left + 1;
                res = (res * length) % mod;
                count = 0;
                left = right + 1;
                continue;
            }
            left++;
        }
        return 0;
    }
}
