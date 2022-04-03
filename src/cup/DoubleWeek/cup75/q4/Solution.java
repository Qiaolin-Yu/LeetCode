package cup.DoubleWeek.cup75.q4;

/**
 * @author 1iin
 */
public class Solution {
    public long sumScores(String s) {
        char[] chars = s.toCharArray();
        char[] temp = new char[chars.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = chars[temp.length - i - 1];
        }
        String t = String.valueOf(temp);
        int[] next = kmpNext(t);
        int[] data = new int[chars.length + 1];
        long res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int j = data[s.length() - next[s.length() - 1 - i]];
            for (; j < s.length(); j++) {
                if (i + j >= chars.length) {
                    break;
                }
                if (chars[j] != chars[i + j]) {
                    break;
                }
            }

            data[i] = j;
            res += j;
        }
        return res;
    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
