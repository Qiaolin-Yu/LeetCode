package cup.DoubleWeek.cup74.q4;

/**
 * @author 1iin
 */
public class Solution {
    char[] chars;
    int carpetLen;
    int[][] memo;

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        chars = floor.toCharArray();
        memo = new int[chars.length][numCarpets + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        this.carpetLen = carpetLen;
        int max = process(0, numCarpets);
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                total++;
            }
        }
        return total - max;
    }

    public int process(int index, int numCarpets) {
        if (index >= chars.length || numCarpets == 0) {
            return 0;
        }
        if (memo[index][numCarpets] != -1) {
            return memo[index][numCarpets];
        }
        int temp = 0;
        for (int i = index; i < index + carpetLen && i < chars.length; i++) {
            if (chars[i] == '1') {
                temp++;
            }
        }
        memo[index][numCarpets] = Math.max(process(index + 1, numCarpets),
                temp + process(index + carpetLen, numCarpets - 1));
        return memo[index][numCarpets];
    }
}
