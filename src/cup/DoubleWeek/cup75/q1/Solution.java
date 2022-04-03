package cup.DoubleWeek.cup75.q1;

/**
 * @author 1iin
 */
public class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while (start > 0 || goal > 0) {
            int a = start % 2;
            start /= 2;
            int b = goal % 2;
            goal /= 2;
            if (a != b) {
                count++;
            }
        }
        return count;
    }
}
