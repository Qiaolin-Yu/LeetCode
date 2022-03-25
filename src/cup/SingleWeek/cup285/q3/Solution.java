package cup.SingleWeek.cup285.q3;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    int[] aliceArrows;
    int max = 0;
    int[] res;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        this.aliceArrows = aliceArrows;
        res = new int[aliceArrows.length];
        Arrays.fill(res, 0);
        int[] arr = new int[aliceArrows.length];
        Arrays.fill(arr, 0);
        process(0, numArrows, arr, 0);
        return res;
    }

    public void process(int index, int rest, int[] carry, int score) {
        if (index == aliceArrows.length || rest == 0) {
            if (score > max) {
                max = score;
                res = carry;
                res[0] += rest;
            }
            return;
        }
        int[] choose1 = new int[aliceArrows.length];
        for (int i = 0; i < choose1.length; i++) {
            choose1[i] = carry[i];
        }
        int[] choose2 = new int[aliceArrows.length];
        for (int i = 0; i < choose2.length; i++) {
            choose2[i] = carry[i];
        }
        choose2[index] = aliceArrows[index] + 1;
        if (rest >= aliceArrows[index] + 1) {
            process(index + 1, rest - aliceArrows[index] - 1, choose2, score + index);
        }
        process(index + 1, rest, choose1, score);
    }
}
