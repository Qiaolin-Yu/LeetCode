package cup.SingleWeek.cup281.q3;

/**
 * @author 1iin
 */
public class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int pre = -1;
        while (sb.length() < chars.length) {
            boolean isChange = false;
            for (int i = map.length - 1; i >= 0; i--) {
                if (i == pre || map[i] == 0) {
                    continue;
                }
                int temp = map[i];
                if (i < pre && map[pre] != 0) {
                    sb.append((char) (i + 'a'));
                    map[i]--;
                    isChange = true;
                    pre = i;
                } else {
                    for (int j = 1; j <= repeatLimit && j <= temp; j++) {
                        sb.append((char) (i + 'a'));
                        map[i]--;
                        isChange = true;
                        pre = i;
                    }
                }
                if (isChange) {
                    break;
                }
            }
            if (isChange) {
                continue;
            }
            return String.valueOf(sb);
        }
        return String.valueOf(sb);
    }
}
