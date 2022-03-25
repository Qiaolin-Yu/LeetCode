package cup.SingleWeek.cup276.q1;

/**
 * @author 1iin
 */
public class Solution {
    public String[] divideString(String s, int k, char fill) {
        char[][] res = new char[(int) Math.ceil((double) s.length() / k)][k];
        int index = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < k; j++) {
                res[i][index % k] = index < chars.length ? chars[index] : fill;
                index++;
            }
        }
        String[] strings = new String[res.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(res[i]);
        }
        return strings;
    }
}