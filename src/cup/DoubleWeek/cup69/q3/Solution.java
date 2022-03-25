package cup.DoubleWeek.cup69.q3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int pair = 0;
        for (int i = 0; i < words.length; i++) {
            if (map.getOrDefault(reverse(words[i]), 0) != 0) {
                map.put(reverse(words[i]), map.get(reverse(words[i])) - 1);
                pair++;
                continue;
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int res = pair * 4;
        for (String key : map.keySet()) {
            if (key.equals(reverse(key)) && map.get(key) != 0) {
                res += 2;
                return res;
            }
        }
        return res;
    }

    public String reverse(String input) {
        return input.charAt(1) + String.valueOf(input.charAt(0));
    }
}
