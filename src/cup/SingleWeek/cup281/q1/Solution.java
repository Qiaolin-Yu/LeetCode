package cup.SingleWeek.cup281.q1;

/**
 * @author 1iin
 */
public class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if ((getSum(i) & 1) == 0) {
                count++;
            }
        }
        return count;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
