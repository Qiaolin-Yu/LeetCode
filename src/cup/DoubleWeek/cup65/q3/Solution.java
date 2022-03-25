package cup.DoubleWeek.cup65.q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 1iin
 */
public class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    int[][] items;

    public int[] maximumBeauty(int[][] items, int[] queries) {
        this.items = items;
        Arrays.sort(items, (o1, o2) -> o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> items[o2][1] - items[o1][1]);
        for (int i = 0; i < items.length; i++) {
            if (priorityQueue.isEmpty() || items[priorityQueue.peek()][1] < items[i][1]) {
                priorityQueue.add(i);
            }
        }
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll());
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(items[list.get(i)][0]+" "+items[list.get(i)][1]);
//        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = helper(queries[i]);
        }
        return res;
    }

    public int helper(int query) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (items[list.get(mid)][0] > query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (items[list.get(left)][0] > query) {
            return 0;
        }
        return items[list.get(left)][1];
    }

}
