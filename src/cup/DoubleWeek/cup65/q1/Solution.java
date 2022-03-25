package cup.DoubleWeek.cup65.q1;

/**
 * @author 1iin
 */
public class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            map1[chars1[i] - 'a']++;
        }
        for (int i = 0; i < chars2.length; i++) {
            map2[chars2[i] - 'a']++;
        }
        for (int i = 0; i < map1.length; i++) {
            if (Math.abs(map1[i] - map2[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
