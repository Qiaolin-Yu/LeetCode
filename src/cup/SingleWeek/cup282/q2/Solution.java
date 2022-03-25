package cup.SingleWeek.cup282.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int minSteps(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            map1[chars1[i] - 'a']++;
        }
        for (int i = 0; i < chars2.length; i++) {
            map2[chars2[i] - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < map1.length; i++) {
            res += Math.abs(map1[i] - map2[i]);
        }
        return res;
    }
}
