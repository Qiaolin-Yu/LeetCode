package cup.DoubleWeek.cup84.q3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 1iin
 */
public class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long day = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i]) && day - map.get(tasks[i]) <= space) {
                day += space - day + map.get(tasks[i]) + 1;
            } else {
                day++;
            }
            map.put(tasks[i], day);
        }
        return day;
    }
}
