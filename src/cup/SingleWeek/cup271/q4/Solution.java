package cup.SingleWeek.cup271.q4;

/**
 * @author 1iin
 */
public class Solution {
    int[] pre;

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        pre = new int[(int) (2e5 + 10)];

        int fruitIndex = 0;
        for (int i = 0; i < pre.length; i++) {
            if (i != 0) {
                pre[i] = pre[i - 1];
            }
            if (fruitIndex == fruits.length) {
                continue;
            }
            if (fruits[fruitIndex][0] == i) {
                pre[i] += fruits[fruitIndex][1];
                fruitIndex++;
            }
        }
        for (int i = 0; i < pre.length; i++) {
            System.out.print(pre[i] + " ");
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            int left = startPos - i;
            int right = Math.max(startPos, left + k - i);
            if (left < 0) {
                left = 0;
            }
            if (right >= pre.length) {
                right = pre.length - 1;
            }
            res = Math.max(res, getSum(left, right));
        }
        for (int i = 0; i <= k; i++) {
            int right = startPos + i;
            int left = Math.min(startPos, right - k + i);
            if (left < 0) {
                left = 0;
            }
            if (right >= pre.length) {
                right = pre.length - 1;
            }
            res = Math.max(res, getSum(left, right));
        }
        return res;

    }

    public int getSum(int left, int right) {
        if (left == 0) {
            return pre[right];
        }
        return pre[right] - pre[left - 1];
    }
}
