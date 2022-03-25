package cup.DoubleWeek.cup72.q4;

/**
 * @author 1iin
 */
public class Solution {
    int n = (int) (1e5 + 10);
    int[] tr;

    public long goodTriplets(int[] nums1, int[] nums2) {
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]++;
        }
        int[] nums1New = new int[nums1.length + 1];
        int[] nums2New = new int[nums2.length + 1];
        for (int i = 1; i < nums1New.length; i++) {
            nums1New[i] = nums1[i - 1];
        }
        for (int i = 1; i < nums2New.length; i++) {
            nums2New[i] = nums2[i - 1];
        }
        nums1 = nums1New;
        nums2 = nums2New;
        int[] left = new int[nums1.length];
        int[] right = new int[nums2.length];
        int[] pos2 = new int[nums2.length];
        for (int i = 1; i < pos2.length; i++) {
            pos2[nums2[i]] = i;
        }
        tr = new int[n + 1];
        for (int i = 1; i < left.length; i++) {
            // System.out.println(sum(i - 1));
            // System.out.println("add "+pos2[nums1[i]]);
            left[i] = sum(pos2[nums1[i]] - 1);
            add(pos2[nums1[i]], 1);
        }
        tr = new int[n + 1];
        for (int i = right.length - 1; i >= 1; i--) {
            right[i] = sum(n - 1) - sum(pos2[nums1[i]]);
            add(pos2[nums1[i]], 1);
        }
        for (int i = 1; i < nums1.length; i++) {
            // System.out.println(left[i] + " " + right[i]);
            res += (long) left[i] * (long) right[i];
        }
        return res;
    }

    public int lowbit(int x) {
        return x & -x;
    }

    public void add(int x, int c) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tr[i] += c;
        }
    }

    public int sum(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tr[i];
        }
        return res;
    }
}