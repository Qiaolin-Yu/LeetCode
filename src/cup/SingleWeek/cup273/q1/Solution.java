package cup.SingleWeek.cup273.q1;

/**
 * @author 1iin
 */
public class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }
        return num % 10 != 0;
    }
}
