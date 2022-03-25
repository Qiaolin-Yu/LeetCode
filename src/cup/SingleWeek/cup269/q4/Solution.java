package cup.SingleWeek.cup269.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 1iin
 */
public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        boolean[] isKnown = new boolean[n];
        isKnown[0] = true;
        isKnown[firstPerson] = true;
        int left = 0;
        while (left < meetings.length) {
            int right = left;
            while (right + 1 < meetings.length && meetings[right + 1][2] == meetings[left][2]) {
                right += 1;
            }

            while (true) {
                boolean flag = false;
                for (int i = left; i <= right; i++) {
                    if (isKnown[meetings[i][0]]) {
                        if (!isKnown[meetings[i][1]]) {
                            isKnown[meetings[i][1]] = true;
                            flag = true;
                        }

                    } else if (isKnown[meetings[i][1]]) {
                        if (!isKnown[meetings[i][0]]) {
                            isKnown[meetings[i][0]] = true;
                            flag = true;
                        }
                    }
                }
                if (!flag) {
                    break;
                }
            }

            left = right + 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < isKnown.length; i++) {
            if (isKnown[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
