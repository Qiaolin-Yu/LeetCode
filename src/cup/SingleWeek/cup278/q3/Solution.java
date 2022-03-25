package cup.SingleWeek.cup278.q3;

/**
 * @author 1iin
 */
public class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        char[] chars = s.toCharArray();
        for (int left = 0; left + k - 1 <= chars.length; left++) {
            int right = left + k - 1;
            long h = 0;
            long p = 1;
            for (int i = left; i <= right; i++) {
                h = (h + p * getVal(chars[i]) % modulo) % modulo;
                p = p * power % modulo;
                continue;
            }
            if (h == hashValue) {
                return s.substring(left, right + 1);
            }
        }
        return "";
    }

    public int getVal(char c) {
        return c - 'a' + 1;
    }

}
