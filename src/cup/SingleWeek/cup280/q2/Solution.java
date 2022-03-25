package cup.SingleWeek.cup280.q2;

/**
 * @author 1iin
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        int n = (int) (1e5 + 10);
        int[] map1 = new int[n];
        int[] map2 = new int[n];
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i += 2) {
            map1[nums[i]]++;
            num1++;
        }
        for (int i = 1; i < nums.length; i += 2) {
            map2[nums[i]]++;
            num2++;
        }
        int max1 = 1;
        for (int i = 1; i < map1.length; i++) {
            if (map1[i] >= map1[max1]) {
                max1 = i;
            }
        }
        int max2 = 1;
        for (int i = 1; i < map2.length; i++) {
            if (map2[i] >= map2[max2]) {
                max2 = i;
            }
        }
        if (max1 != max2) {
            return num1 - map1[max1] + num2 - map2[max2];
        }
        if (num1 - map1[max1] <= num2 - map2[max2]) {
            int res = num1 - map1[max1];
            int temp = 0;
            for (int i = 1; i < n; i++) {
                if (i == max2) {
                    continue;
                }
                if (map2[i] >= map2[temp]) {
                    temp = i;
                }
            }
            return res + num2 - map2[temp];

        } else {
            int res = num2 - map2[max2];
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (i == max1) {
                    continue;
                }
                if (map1[i] >= map1[temp]) {
                    temp = i;
                }
            }
            return res + num1 - map1[temp];
        }


    }
}
