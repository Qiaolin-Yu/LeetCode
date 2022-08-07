package cup.SingleWeek.cup305.q4;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    char[] chars;
    int k;
    int[][] memo;

    public int longestIdealString(String s, int k) {
        chars = s.toCharArray();
        this.k = k;
        memo = new int[chars.length][27];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 26);
    }

    public int dfs(int index, int fin) {
        if (index == chars.length) {
            return 0;
        }
        int temp = chars[index] - 'a';
        if (memo[index][fin] != -1) {
            return memo[index][fin];
        }
        if (Math.abs(temp - fin) <= k || fin == 26) {
            memo[index][fin] = Math.max(1 + dfs(index + 1, temp), dfs(index + 1, fin));
            return memo[index][fin];
        }
        memo[index][fin] = dfs(index + 1, fin);
        return memo[index][fin];
    }
}
