package cup.SingleWeek.cup279.q4;

/**
 * @author 1iin
 */
//public class Solution {
//    char[] chars;
//
//    public int minimumTime(String s) {
//        chars = s.toCharArray();
//
//
//    }
//
//    public int process(int left, int right) {
//        if (left > right) {
//            return 0;
//        }
//        int i = left;
//        for (; i <= right; i++) {
//            if (chars[i] == '1') {
//                break;
//            }
//        }
//        if (i == right + 1) {
//            return 0;
//        }
//        return Math.min(process(i + 1, right))
//    }
//}
