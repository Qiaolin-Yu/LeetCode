package cup.DoubleWeek.cup72.q3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 1iin
 */
public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1) {
            return new ArrayList<>();
        }
        List<Long> res = new ArrayList<>();
        long a = 0;
        long sum = a;
        while (sum <= finalSum) {
            a += 2;
            if (a + 2 > finalSum - sum - a) {
                res.add(finalSum - sum);
                break;
            }
            sum += a;
            res.add(a);

        }
        return res;
    }
}
