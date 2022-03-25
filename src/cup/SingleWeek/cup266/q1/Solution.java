package cup.SingleWeek.cup266.q1;

/**
 * @author 1iin
 */
public class Solution {
    public int countVowelSubstrings(String word) {
        char[] chars = word.toCharArray();
        int res = 0;
        for (int left = 0; left < chars.length; left++) {
            int[] count = new int[5];
            for (int right = left; right < chars.length; right++) {
                if (chars[right] == 'a') {
                    count[0]++;
                } else if (chars[right] == 'e') {
                    count[1]++;
                } else if (chars[right] == 'i') {
                    count[2]++;
                } else if (chars[right] == 'o') {
                    count[3]++;
                } else if (chars[right] == 'u') {
                    count[4]++;
                } else {
                    break;
                }
                if (isValid(count)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean isValid(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
