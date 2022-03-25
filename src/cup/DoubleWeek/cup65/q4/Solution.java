package cup.DoubleWeek.cup65.q4;

import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    int[] tasks;
    int[] workers;
    int pills;
    int strength;
    boolean[] isUsed;

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        this.tasks = tasks;
        this.workers = workers;
        this.pills = pills;
        this.strength = strength;
        isUsed = new boolean[workers.length];
        int res = 0;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int w = workers.length - 1;
        int t = tasks.length - 1;
        while (w >= 0 && t >= 0) {
            if (isUsed[w]) {
                w--;
                continue;
            }
            if (tasks[t] <= workers[w]) {
                int worker = find(tasks[t]);
                isUsed[worker] = true;
                res++;
                t--;
                continue;
            }
            if (pills > 0 && tasks[t] <= workers[w] + strength) {
                int worker = find(tasks[t] - strength);
                res++;
                t--;
                isUsed[worker] = true;
                pills--;
                continue;
            }
            t--;
        }
        return res;
    }

    public int find(int query) {
        int left = 0;
        int right = workers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (workers[mid] < query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        while (left < isUsed.length && isUsed[left]) {
            left++;
        }
        if (left < isUsed.length && workers[left] < query) {
            left = isUsed.length;
        }
        return left;
    }
}
