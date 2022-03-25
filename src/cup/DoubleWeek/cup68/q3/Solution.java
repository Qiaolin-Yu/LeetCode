package cup.DoubleWeek.cup68.q3;

/**
 * @author 1iin
 */
public class Solution {
    public boolean canBeValid(String s, String locked) {
        char[] chars = s.toCharArray();
        char[] lock = locked.toCharArray();
        int flow = 0;
        int canChange = 0;
        for (int i = 0; i < chars.length; i++) {
            if (lock[i] == '0') {
                canChange++;
            }
            int ca = chars[i] == '(' ? 1 : -1;
            flow += ca;
        }
        if (flow == 0) {
            return true;
        }
        if ((flow & 1) == 1 || flow > canChange * 2 || flow + canChange * 2 < 0) {
            return false;
        }
        if (flow < 0 && flow + canChange * 2 >= 0) {
            return true;
        }
        for (int i = chars.length - 1; i >= 0; i--) {
            if (flow == 0) {
                break;
            }
            if (lock[i] == '0' && chars[i] == '(') {
                chars[i] = ')';
                flow -= 2;
            }
        }
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            int ca = chars[i] == '(' ? 1 : -1;
            temp += ca;
            System.out.println(i + " " + temp);
            if (temp < 0) {
                return false;
            }
        }
        return true;
    }
}
