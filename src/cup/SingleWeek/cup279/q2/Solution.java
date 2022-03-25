package cup.SingleWeek.cup279.q2;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 1iin
 */
public class Solution {
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        boolean neg = num < 0;
        num = Math.abs(num);
        int count = 0;
        int[] map = new int[10];
        while (num > 0) {
            map[(int) (num % 10)]++;
            num /= 10;
            count++;
        }
        StringBuilder res = new StringBuilder();
        if (!neg) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (map[j] != 0) {
                        map[j] -= 1;
                        res.append(j);
                        break;
                    }
                }
            }
        } else {
            res.append("-");
            for (int i = 0; i < count; i++) {
                for (int j = 9; j >= 0; j--) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (map[j] != 0) {
                        map[j] -= 1;
                        res.append(j);
                        break;
                    }
                }
            }
        }
        return Long.parseLong(res.toString());
    }
}
