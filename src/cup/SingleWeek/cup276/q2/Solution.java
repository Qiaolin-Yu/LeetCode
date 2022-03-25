package cup.SingleWeek.cup276.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target > 1) {
            if (maxDoubles > 0 && (target & 1) == 0) {
                target /= 2;
                res++;
                maxDoubles--;
            } else {
                if (maxDoubles > 0) {
                    res++;
                    target -= 1;
                } else {
                    return res + target - 1;
                }

            }
        }
        return res;
    }
}
