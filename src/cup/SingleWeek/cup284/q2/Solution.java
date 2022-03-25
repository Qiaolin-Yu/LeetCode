package cup.SingleWeek.cup284.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int count = 0;
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < dig.length; i++) {
            isVisited[dig[i][0]][dig[i][1]] = true;
        }
        for (int i = 0; i < artifacts.length; i++) {
            boolean flag = true;
            for (int j = artifacts[i][0]; j <= artifacts[i][2]; j++) {
                for (int k = artifacts[i][1]; k <= artifacts[i][3]; k++) {
                    if (!isVisited[j][k]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
