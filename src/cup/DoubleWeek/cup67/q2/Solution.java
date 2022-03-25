package cup.DoubleWeek.cup67.q2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 1iin
 */
public class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] pre = new int[security.length];
        int[] post = new int[security.length];
        int temp = 0;
        for (int i = 0; i < security.length; i++) {
            if (i > 0 && security[i] <= security[i - 1]) {
                temp++;
            } else {
                temp = 1;
            }
            pre[i] = temp;
        }
        temp = 0;
        for (int i = security.length - 1; i >= 0; i--) {
            if (i < security.length - 1 && security[i] <= security[i + 1]) {
                temp++;
            } else {
                temp = 1;
            }
            post[i] = temp;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < security.length; i++) {
            if (pre[i] > time && post[i] > time) {
                res.add(i);
            }
        }
        return res;
    }
}
