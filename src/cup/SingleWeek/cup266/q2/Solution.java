package cup.SingleWeek.cup266.q2;

/**
 * @author 1iin
 */
public class Solution {
    public long countVowels(String word) {
        long res = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                res += (long) (1 + i) * (long) (chars.length - i);
            }
        }
        return res;
    }
}
