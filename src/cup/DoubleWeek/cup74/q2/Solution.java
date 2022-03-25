package cup.DoubleWeek.cup74.q2;

/**
 * @author 1iin
 */
public class Solution {
    String pattern;

    public long maximumSubsequenceCount(String text, String pattern) {
        this.pattern = pattern;
        String choose1 = pattern.charAt(0) + text;
        String choose2 = text + pattern.charAt(1);
        return Math.max(helper(choose1.toCharArray()), helper(choose2.toCharArray()));
    }

    public long helper(char[] chars) {
        long res = 0;
        int[] pre = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i < chars.length - 1) {
                pre[i] = pre[i + 1];
            }
            if (chars[i] == pattern.charAt(1)) {
                pre[i]++;
            }
        }
        for (int i = 0; i < pre.length - 1; i++) {
            if (chars[i] == pattern.charAt(0)) {
                res += pre[i + 1];
            }
        }
        return res;
    }
}
