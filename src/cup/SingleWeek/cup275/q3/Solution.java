package cup.SingleWeek.cup275.q3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 1iin
 */
public class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        int[] startWordsMap = new int[startWords.length];
        ArrayList<Set<Integer>> patternsList = new ArrayList<>(27);
        for (int i = 0; i < 27; i++) {
            patternsList.add(new HashSet<>());
        }
        for (int i = 0; i < startWords.length; i++) {
            char[] chars = startWords[i].toCharArray();
            for (int index = 0; index < chars.length; index++) {
                int temp = chars[index] - 'a';
                startWordsMap[i] |= (1 << temp);
            }
            Set<Integer> patterns = patternsList.get(chars.length);
            patterns.add(startWordsMap[i]);
        }
        for (int i = 0; i < targetWords.length; i++) {
            int tar = 0;
            char[] chars = targetWords[i].toCharArray();
            for (int index = 0; index < chars.length; index++) {
                int temp = chars[index] - 'a';
                tar |= (1 << temp);
            }
            Set<Integer> patterns = patternsList.get(targetWords[i].length() - 1);
            for (int index = 25; index >= 0; index--) {
                if (((tar & (1 << index)) == (1 << index))) {
                    int temp = tar;
                    temp ^= (1 << index);
                    if (patterns.contains(temp)) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
}