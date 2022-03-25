package cup.SingleWeek.cup272.q1;

/**
 * @author 1iin
 */
public class Solution {
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (isValid(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    public boolean isValid(String a) {
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
