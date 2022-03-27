package cup.SingleWeek.cup286.q1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 1iin
 */
public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int key : set1) {
            if (!set2.contains(key)) {
                res.get(0).add(key);
            }
        }
        for (int key : set2) {
            if (!set1.contains(key)) {
                res.get(1).add(key);
            }
        }
        return res;
    }
}
