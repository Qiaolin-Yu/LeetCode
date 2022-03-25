package cup.SingleWeek.cup275.q1;

/**
 * @author 1iin
 */
public class Solution {
    int[][] matrix;

    public boolean checkValid(int[][] matrix) {
        this.matrix = matrix;
        for (int row = 0; row < matrix.length; row++) {
            if (!checkRow(row)) {
                return false;
            }
        }
        for (int col = 0; col < matrix[0].length; col++) {
            if (!checkCol(col)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRow(int row) {
        int[] map = new int[matrix[row].length + 1];
        for (int col = 0; col < matrix[row].length; col++) {
            map[matrix[row][col]]++;
        }
        for (int i = 1; i <= matrix[row].length; i++) {
            if (map[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(int col) {
        int[] map = new int[matrix.length + 1];
        for (int row = 0; row < matrix.length; row++) {
            map[matrix[row][col]]++;
        }
        for (int i = 1; i <= matrix.length; i++) {
            if (map[i] == 0) {
                return false;
            }
        }
        return true;
    }

}
