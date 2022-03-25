package cup.SingleWeek.cup285.q4;

import java.util.PriorityQueue;

/**
 * @author 1iin
 */
public class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] chars = s.toCharArray();
        char[] queryChars = queryCharacters.toCharArray();
        int max = 1;
        int maxCount = 1;
        for (int left = 0; left < chars.length; ) {
            int right = left;
            while (right + 1 < chars.length && chars[right + 1] == chars[right]) {
                right++;
            }
            if (right - left + 1 == max) {
                maxCount++;
            }
            if (right - left + 1 > max) {
                max = right - left + 1;
                maxCount = 1;
            }
            left = right + 1;
        }
        int[] res = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            int left = index;
            int right = index;
            while (left > 0 && chars[left] == chars[left - 1]) {
                left--;
            }
            while (right + 1 < chars.length && chars[right + 1] == chars[right]) {
                right++;
            }
            if (max == right - left + 1) {
                maxCount--;
                if (maxCount == 0) {
                    max = 1;
                }
            }
            char c = queryChars[i];
            chars[index] = c;
            left = index;
            right = index;
            if (max != 1) {
                while (left > 0 && chars[left] == chars[left - 1]) {
                    left--;
                }
                while (right + 1 < chars.length && chars[right + 1] == chars[right]) {
                    right++;
                }
                if (right - left + 1 == max) {
                    maxCount++;
                }
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    maxCount = 1;
                }
                res[i] = max;
            } else {
                for (left = 0; left < chars.length; ) {
                    right = left;
                    while (right + 1 < chars.length && chars[right + 1] == chars[right]) {
                        right++;
                    }
                    if (right - left + 1 == max) {
                        maxCount++;
                    }
                    if (right - left + 1 > max) {
                        max = right - left + 1;
                        maxCount = 1;
                    }
                    left = right + 1;
                }
                res[i] = max;
            }
        }
        return res;
    }
}
