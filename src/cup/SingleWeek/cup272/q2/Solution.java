package cup.SingleWeek.cup272.q2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 1iin
 */
public class Solution {
    public String addSpaces(String s, int[] spaces) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < spaces.length; i++) {
            set.add(spaces[i]);
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        while (index < chars.length) {
            if (set.contains(index)) {
                sb.append(" ");
            }
            sb.append(chars[index]);
            index++;
        }
        return sb.toString();
    }
}
