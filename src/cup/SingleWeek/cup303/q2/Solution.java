package cup.SingleWeek.cup303.q2;

/**
 * @author 1iin
 */
public class Solution {
    int[][] grid;

    public int equalPairs(int[][] grid) {
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (isEqual(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isEqual(int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }
}
