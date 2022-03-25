package cup.SingleWeek.cup285.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int countCollisions(String directions) {
        char[] chars = directions.toCharArray();
        int rightBound = chars.length - 1;
        for (; rightBound >= 0; rightBound--) {
            if (chars[rightBound] == 'L' || chars[rightBound] == 'S') {
                break;
            }
        }
        int leftBound = 0;
        for (; leftBound < chars.length; leftBound++) {
            if (chars[leftBound] == 'R' || chars[leftBound] == 'S') {
                break;
            }
        }
        int s = 0;
        for (int i = leftBound; i <= rightBound; i++) {
            if (chars[i] == 'S'){
                s++;
            }
        }
        return Math.max(rightBound - leftBound + 1 - s, 0);
    }
}
