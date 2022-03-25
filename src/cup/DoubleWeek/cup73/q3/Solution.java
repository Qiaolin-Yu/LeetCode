package cup.DoubleWeek.cup73.q3;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inDegree = new int[n];
        List<Set<Integer>> temp = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
            temp.add(new HashSet<>());
            res.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            lists.get(edges[i][0]).add(edges[i][1]);
            inDegree[edges[i][1]]++;
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int i = 0; i < lists.get(t).size(); i++) {
                int j = lists.get(t).get(i);
                temp.get(j).addAll(temp.get(t));
                temp.get(j).add(t);
                if (--inDegree[j] == 0) {
                    queue.add(j);
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            for (int a : temp.get(i)) {
                res.get(i).add(a);
            }
            Collections.sort(res.get(i));
        }
        return res;
    }
}
