package cup.SingleWeek.cup286.q3;

/**
 * @author 1iin
 */
public class Solution {
    int intLength;

    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] res = new long[queries.length];
        this.intLength = intLength;
        if (intLength == 1) {
            for (int i = 0; i < queries.length; i++) {
                if (queries[i] >= 10) {
                    res[i] = -1;
                    continue;
                }
                res[i] = queries[i];
            }
            return res;
        }
        if (intLength % 2 == 1) {
            for (int i = 0; i < queries.length; i++) {
                res[i] = oddHelper(queries[i]);
            }
            return res;
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = evenHelper(queries[i]);
        }
        return res;
    }

    public long oddHelper(int query) {
        int mod = (query % 10 + 9) % 10;
        query -= mod + 1;
        int temp = query / 10;
        long prefix = (long) Math.pow(10, intLength / 2 - 1);
        prefix += temp;
        if (prefix >= (long) Math.pow(10, intLength / 2)) {
            return -1;
        }
        String res = String.valueOf(prefix);
        res += mod;
        res += reverse(String.valueOf(prefix));
        return Long.parseLong(res);
    }

    public long evenHelper(int query) {
        long prefix = (long) Math.pow(10, intLength / 2 - 1);
        prefix += query - 1;
        if (prefix >= (long) Math.pow(10, intLength / 2)) {
            return -1;
        }
        String res = String.valueOf(prefix);
        res += reverse(String.valueOf(prefix));
        return Long.parseLong(res);
    }

    public String reverse(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return String.valueOf(res);
    }
}
