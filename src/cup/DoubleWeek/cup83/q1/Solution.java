package cup.DoubleWeek.cup83.q1;

/**
 * @author 1iin
 */
public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        boolean a = true;
        for (int i = 0; i < ranks.length - 1; i++) {
            if (suits[i] != suits[i + 1]) {
                a = false;
                break;
            }
        }
        if (a) {
            return "Flush";
        }
        int[] count = new int[14];
        for (int i = 0; i < ranks.length; i++) {
            count[ranks[i]]++;
            if (count[ranks[i]] == 3) {
                return "Three of a Kind";
            }
        }
        count = new int[14];
        for (int i = 0; i < ranks.length; i++) {
            if (count[ranks[i]] == 2) {
                return "Pair";
            }
        }
        return "High Card";
    }
}
