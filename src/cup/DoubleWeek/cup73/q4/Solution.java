//package cup.DoubleWeek.cup73.q4;
//
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Set;
//
///**
// * @author 1iin
// */
//public class Solution {
//    public int minMovesToMakePalindrome(String s) {
//        int count = 0;
//        boolean[] isVisited = new boolean[s.length()];
//        int[] pre = new int[s.length()];
//        char[] chars = s.toCharArray();
//        for (int left = 0; left < chars.length; left++) {
//            if (isVisited[left]) {
//                continue;
//            }
//            for (int right = chars.length - 1; right >= left; right--) {
//                if (isVisited[right]) {
//                    continue;
//                }
//                if (chars[left] == chars[right]) {
//                    isVisited[right] = true;
//                    pre[left] = right;
//                    pre[right] = left;
//                    count += Math.abs(chars.length - left - 1 - right);
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < count; i++) {
//            for (int j = 0; j < chars.length - 1; j++) {
//
//            }
//        }
//    }
//}
