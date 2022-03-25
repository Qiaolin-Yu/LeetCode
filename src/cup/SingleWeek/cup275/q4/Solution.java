package cup.SingleWeek.cup275.q4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 1iin
 */
public class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Flower[] flowers = new Flower[plantTime.length];
        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = new Flower(plantTime[i], growTime[i]);
        }
        int res = 0;
        int day = 0;
        Arrays.sort(flowers, (o1, o2) -> o2.grow - o1.grow);
        for (int i = 0; i < flowers.length; i++) {
            day += flowers[i].plant;
            res = Math.max(res, day + flowers[i].grow);
        }
        return res;
    }
}

class Flower {
    int plant;
    int grow;

    public Flower(int plant, int grow) {
        this.plant = plant;
        this.grow = grow;
    }
}
