package cup.DoubleWeek.cup75.q3;

/**
 * @author 1iin
 */
public class Solution {
    char[] chars;
    long[][][] memo;

    public long numberOfWays(String s) {
        chars = s.toCharArray();
        memo = new long[chars.length][3][4];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                for (int k = 0; k < memo[0][0].length; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return process(0, '2', 0);
    }

    public long process(int index, char carry, int total) {
        if (total == 3) {
            return 1;
        }
        if (index == chars.length) {
            return 0;
        }
        if (memo[index][carry - '0'][total] != -1) {
            return memo[index][carry - '0'][total];
        }
        if (chars[index] != carry) {
            memo[index][carry - '0'][total] = process(index + 1, chars[index], total + 1) +
                    process(index + 1, carry, total);
            return memo[index][carry - '0'][total];
        }
        memo[index][carry - '0'][total] = process(index + 1, carry, total);
        return memo[index][carry - '0'][total];
    }
}
