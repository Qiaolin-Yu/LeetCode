package cup.SingleWeek.cup265.q4;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    String s1;
    String s2;
    char[] c1;
    char[] c2;
    int[][][][] memo;

    public boolean possiblyEquals(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        memo = new int[s1.length()][s2.length()][s2.length() + 1][s1.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                for (int k = 0; k < memo[j].length; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        return dfs(0, 0, 0, 0);
    }

    public boolean dfs(int index1, int index2, int carry1, int carry2) {
        System.out.println("dfs " + index1 + " " + index2 + " " + carry1 + " " + carry2);
        if (carry1 >= carry2) {
            carry1 -= carry2;
            carry2 = 0;
        } else {
            carry2 -= carry1;
            carry1 = 0;
        }
        if (index1 == c1.length && index2 == c2.length && carry1 == carry2) {
            return true;
        }
        if (index1 >= c1.length || index2 >= c2.length || index1 + carry2 > c1.length || index2 + carry1 > c2.length) {
            return false;
        }
        if (memo[index1][index2][carry1][carry2] != -1) {
            return memo[index1][index2][carry1][carry2] == 1;
        }
        if (!Character.isDigit(c1[index1]) && !Character.isDigit(c2[index2])) {
            if (carry1 == carry2) {
                memo[index1][index2][carry1][carry2] = (c1[index1] == c2[index2] && dfs(index1 + 1, index2 + 1, carry1, carry2)) ? 1 : 0;
            } else if (carry1 < carry2) {
                memo[index1][index2][carry1][carry2] = dfs(index1 + 1, index2, carry1, carry2 - 1) ? 1 : 0;
            } else {
                memo[index1][index2][carry1][carry2] = dfs(index1, index2 + 1, carry1 - 1, carry2) ? 1 : 0;
            }
            return memo[index1][index2][carry1][carry2] == 1;
        }
        int right1 = index1 - 1;
        while (right1 + 1 < c1.length && Character.isDigit(c1[right1 + 1])) {
            right1++;
        }
        int right2 = index2 - 1;
        while (right2 + 1 < c2.length && Character.isDigit(c2[right2 + 1])) {
            right2++;
        }
        boolean flag;
        if (!Character.isDigit(c1[index1])) {
            for (int i = index2; i <= right2; i++) {
                int length = Integer.parseInt(s2.substring(index2, i + 1));
                flag = dfs(index1 + 1, i + 1, carry1, carry2 + length - (right2 - index2 ));
                if (flag) {
                    memo[index1][index2][carry1][carry2] = 1;
                    return true;
                }
            }
        }
        if (!Character.isDigit(c2[index2])) {
            for (int i = index1; i <= right1; i++) {
                int length = Integer.parseInt(s1.substring(index1, i + 1));
                flag = dfs(i + 1, index2 + 1, carry1 + length - (right1 - index1 ), carry2);
                if (flag) {
                    memo[index1][index2][carry1][carry2] = 1;
                    return true;
                }
            }
        }
        for (int i = index1; i <= right1; i++) {
            int length1 = Integer.parseInt(s1.substring(index1, i + 1));
            for (int j = index2; j <= right2; j++) {
                int length2 = Integer.parseInt(s2.substring(index2, j + 1));
                if (dfs(i + 1, j + 1, carry1 + length1 - (right1 - index1 ), carry2 + length2 - (right2 - index2 ))) {
                    memo[index1][index2][carry1][carry2] = 1;
                    return true;
                }
            }
        }
        memo[index1][index2][carry1][carry2] = 0;
        return false;
    }
}