package cup.DoubleWeek.cup69.q4;

/**
 * @author 1iin
 */
public class Solution {
    int stampHeight;
    int stampWidth;
    int[][] sumByRow;
    int[][] sum;
    int[][] sub;
    int[][] grid;

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        this.stampHeight = stampHeight;
        this.stampWidth = stampWidth;
        this.grid = grid;
        this.sumByRow = new int[grid.length][grid[0].length];
        this.sub = new int[grid.length + 1][grid[0].length + 1];
        this.sum = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (col == 0) {
                    sumByRow[row][col] = grid[row][col];
                } else {
                    sumByRow[row][col] = sumByRow[row][col - 1] + grid[row][col];
                }
                if (row == 0) {
                    sum[row][col] = sumByRow[row][col];
                } else {
                    sum[row][col] = sumByRow[row][col] + sum[row - 1][col];
                }
            }
        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                for (int i = 0; i < 4; i++) {
                    if (isValid(row, col, i)) {
                        int[] temp = getNext(row, col, i);
                        int x1 = temp[0];
                        int y1 = temp[1];
                        int x2 = temp[2];
                        int y2 = temp[3];
                        sub[x1][y1] += 1;
                        sub[x2][y1] -= 1;
                        sub[x1][y2 + 1] -= 1;
                        sub[x2 + 1][y2 + 1] += 1;
                    }
                }
            }
        }
        this.sumByRow = new int[grid.length][grid[0].length];
        this.sum = new int[grid.length][grid[0].length];
        int[][] check = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                int temp = 0;
                if (col == 0) {
                    sumByRow[row][col] = sub[row][col];
                } else {
                    temp = sumByRow[row][col - 1];
                    sumByRow[row][col] = sumByRow[row][col - 1] + sub[row][col];
                }
                if (row == 0) {
                    sum[row][col] = sumByRow[row][col];
                } else {
                    temp = sumByRow[row][col];
                    sum[row][col] = sumByRow[row][col] + sub[row - 1][col];
                }
                if (sum[row][col] == temp && grid[row][col] != -1) {
                    return false;
                }


            }
        }
        return true;
    }

    public int getSum(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - (x1 - 1 < 0 ? 0 : sum[x1 - 1][y2]) -
                (y1 - 1 < 0 ? 0 : sum[x2][y1 - 1]) + (x1 - 1 < 0 || y1 - 1 < 0 ? 0 : sum[x1 - 1][y1 - 1]);
    }

    public int[] getNext(int row, int col, int dir) {
        int[] res = new int[4];
        int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
        if (dir == 0) {
            row1 = row - (stampHeight - 1);
            col1 = col - (stampWidth - 1);
            row2 = row;
            col2 = col;
        } else if (dir == 1) {
            row1 = row;
            row2 = row + (stampHeight - 1);
            col1 = col - (stampWidth - 1);
            col2 = col;
        } else if (dir == 2) {
            row1 = row - (stampHeight - 1);
            col1 = col;
            row2 = row;
            col2 = col + (stampWidth - 1);
        } else if (dir == 3) {
            row1 = row;
            row2 = row + (stampHeight - 1);
            col1 = col;
            col2 = col + (stampWidth - 1);
        }
        return new int[]{row1, col1, row2, col2};
    }

    public boolean isValid(int row, int col, int dir) {
        int[] temp = getNext(row, col, dir);
        int row1 = temp[0];
        int col1 = temp[1];
        int row2 = temp[2];
        int col2 = temp[3];
        if (row1 < 0 || row1 >= grid.length || row2 < 0 || row2 >= grid.length
                || col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return false;
        }
        if (getSum(row1, col1, row2, col2) != 0) {
            return false;
        }
        return true;
    }
}