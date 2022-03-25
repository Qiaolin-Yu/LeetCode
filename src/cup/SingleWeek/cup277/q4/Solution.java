package cup.SingleWeek.cup277.q4;

import java.util.ArrayList;

/**
 * @author 1iin
 */
public class Solution {
    int[][] statements;
    int res = 0;

    public int maximumGood(int[][] statements) {
        this.statements = statements;
        ArrayList<Integer> isGood = new ArrayList<>();
        for (int i = 0; i < statements.length; i++) {
            isGood.add(0);
        }
        process(0, 0, isGood);
        return res;
    }

    public void process(int index1, int index2, ArrayList<Integer> isGood) {
        if (index1 == statements.length) {
            int temp = 0;
            for (int i = 0; i < isGood.size(); i++) {
                if (isGood.get(i) == 1 || isGood.get(i) == 0) {
                    temp++;
                }
            }
            res = Math.max(res, temp);
            return;
        }
        if (index2 == statements[0].length) {
            process(index1 + 1, 0, new ArrayList<>(isGood));
            return;
        }
        if (statements[index1][index2] == 2) {
            process(index1, index2 + 1, new ArrayList<>(isGood));
            return;
        }
        if (isGood.get(index1) == 0) {
            isGood.set(index1, 1);
            process(index1, index2, new ArrayList<>(isGood));
            isGood.set(index1, 2);
            process(index1, index2, new ArrayList<>(isGood));
            return;
        }
        if (isGood.get(index1) == 1) {
            int should = statements[index1][index2] == 1 ? 1 : 2;
            if (isGood.get(index2) == 0) {
                isGood.set(index2, should);
            }
            if (should != isGood.get(index2)) {
                return;
            }
            process(index1, index2 + 1, new ArrayList<>(isGood));
            return;
        }
        process(index1, index2 + 1, new ArrayList<>(isGood));
    }
}
