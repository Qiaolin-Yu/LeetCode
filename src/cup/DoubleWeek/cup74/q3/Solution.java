package cup.DoubleWeek.cup74.q3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 1iin
 */
public class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            heap.add((double) nums[i]);
        }
        double reduce = 0;
        int count = 0;
        while (reduce < sum / 2) {
            double num = heap.poll();
            reduce += num / 2;
            heap.add(num / 2);
            count++;
        }
        return count;
    }
}
