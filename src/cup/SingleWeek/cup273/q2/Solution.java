package cup.SingleWeek.cup273.q2;

/**
 * @author 1iin
 */
public class Solution {
    int n;

    public int[] executeInstructions(int n, int[] startPos, String s) {
        this.n = n;
        char[] op = s.toCharArray();
        int[] res = new int[op.length];
        for (int start = 0; start < op.length; start++) {
            int row = startPos[0];
            int col = startPos[1];
            for (int i = start; i < op.length; i++) {
                int[] newP = change(row, col, op[i]);
                row = newP[0];
                col = newP[1];
                if (isValid(row, col)) {
                    res[start]++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public int[] change(int row, int col, char c) {
        if (c == 'L') {
            return new int[]{row, col - 1};
        }
        if (c == 'R') {
            return new int[]{row, col + 1};
        }
        if (c == 'U') {
            return new int[]{row - 1, col};
        }
        return new int[]{row + 1, col};
    }

    public boolean isValid(int row, int col) {
        if (row < 0 || row >= n) {
            return false;
        }
        if (col < 0 || col >= n) {
            return false;
        }
        return true;
    }
}
