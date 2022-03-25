package cup.DoubleWeek.cup66.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int minimumBuckets(String street) {
        int res = 0;
        char[] chars = street.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'H') {
                if (i == 0) {
                    if (i == chars.length - 1 || chars[i + 1] == 'H') {
                        return -1;
                    }
                    chars[i + 1] = 'W';
                    res++;
                    continue;
                }
                if (i == chars.length - 1) {
                    if (chars[i - 1] == 'W') {
                        continue;
                    }
                    if (chars[i - 1] == 'H') {
                        return -1;
                    }
                    chars[i - 1] = 'W';
                    res++;
                    continue;
                }
                if (chars[i - 1] == 'W') {
                    continue;
                }
                if (chars[i - 1] == 'H' && chars[i + 1] == 'H') {
                    return -1;
                }
                if (chars[i + 1] == 'H') {
                    chars[i - 1] = 'W';
                } else {
                    chars[i + 1] = 'W';
                }
                res++;
            }
        }
        return res;
    }
}
