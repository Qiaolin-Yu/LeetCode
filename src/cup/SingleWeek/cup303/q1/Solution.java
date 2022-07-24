package cup.SingleWeek.cup303.q1;

/**
 * @author 1iin
 */
public class Solution {
    public char repeatedCharacter(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
            if (count[chars[i] - 'a'] > 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}
