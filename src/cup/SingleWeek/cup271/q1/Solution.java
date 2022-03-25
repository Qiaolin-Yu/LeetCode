package cup.SingleWeek.cup271.q1;

/**
 * @author 1iin
 */
public class Solution {
    public int countPoints(String rings) {
        boolean[][] bucks = new boolean[10][3];
        char[] chars = rings.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
            int color;
            if (chars[i] == 'R') {
                color = 0;
            } else if (chars[i] == 'G') {
                color = 1;
            } else {
                color = 2;
            }
            bucks[chars[i + 1] - '0'][color] = true;
        }
        int res = 0;
        for (int i = 0; i < bucks.length; i++) {
            if (bucks[i][0] && bucks[i][1] && bucks[i][2]) {
                res++;
            }
        }
        return res;
    }
}
