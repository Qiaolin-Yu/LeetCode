package cup.DoubleWeek.cup66.q4;

/**
 * @author 1iin
 */
public class Solution {
    public int countPyramids(int[][] grid) {
        boolean[][][] isValid = new boolean[grid.length][grid[0].length][grid[0].length];
        for (int row = 0; row < isValid.length; row++) {
            for (int length = 1; length <= isValid[row].length; length++) {
                for (int a = 0; a < isValid[row].length; a++) {
                    if (a + length - 1 >= isValid[row].length) {
                        break;
                    }
                    int b = a + length - 1;
                    if (length == 1) {
                        if (grid[row][a] == 1) {
                            isValid[row][a][b] = true;
                        }
                    } else if (length == 2) {
                        isValid[row][a][b] = isValid[row][a][a] && isValid[row][b][b];
                    } else {
                        isValid[row][a][b] = isValid[row][a][a] && isValid[row][b][b] && isValid[row][a + 1][b - 1];
                    }
                }
            }
        }
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] != 1) {
                    continue;
                }
                for (int h = 2; ; h++) {
                    if (r + h - 1 < grid.length &&
                            c - h + 1 >= 0 && c + h - 1 < grid[0].length &&
                            isValid[r + h - 1][c - h + 1][c + h - 1]) {
                        res++;
                    } else {
                        break;
                    }
                }
                for (int h = 2; ; h++) {
                    if (r - h + 1 >= 0 &&
                            c - h + 1 >= 0 && c + h - 1 < grid[0].length &&
                            isValid[r - h + 1][c - h + 1][c + h - 1]) {
                        res++;
                    } else {
                        break;
                    }

                }
            }
        }
        return res;
    }
}
