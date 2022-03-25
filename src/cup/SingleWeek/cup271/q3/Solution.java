package cup.SingleWeek.cup271.q3;

/**
 * @author 1iin
 */
public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int left = 0;
        int right = plants.length - 1;
        int leftNum = capacityA;
        int rightNum = capacityB;
        while (left <= right) {
            if (left == right) {
                if (leftNum >= rightNum) {
                    if (leftNum < plants[left]) {
                        res++;
                        leftNum = capacityA;
                    }
                    leftNum -= plants[left];
                    left++;
                } else {
                    if (rightNum < plants[right]) {
                        res++;
                        rightNum = capacityB;
                    }
                    rightNum -= plants[right];
                    right--;
                }
                continue;
            }
            if (leftNum < plants[left]) {
                res++;
                leftNum = capacityA;
            }
            leftNum -= plants[left];
            left++;
            if (rightNum < plants[right]) {
                res++;
                rightNum = capacityB;
            }
            rightNum -= plants[right];
            right--;
        }
        return res;
    }
}
