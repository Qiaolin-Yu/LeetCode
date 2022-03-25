package cup.DoubleWeek.cup68.q1;

/**
 * @author 1iin
 */
public class Solution {
    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (int i = 0; i < sentences.length; i++) {
            String[] a = sentences[i].split(" ");
            res = Math.max(res, a.length);
        }
        return res;
    }
}
