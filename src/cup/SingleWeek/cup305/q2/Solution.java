package cup.SingleWeek.cup305.q2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 1iin
 */
public class Solution {
    Set<Integer> isVisited = new HashSet<>();
    Map<Integer, Set<Integer>> map = new HashMap<>();

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrictedSet = new HashSet<>();
        for (int i = 0; i < restricted.length; i++) {
            restrictedSet.add(restricted[i]);
        }
        for (int i = 0; i < edges.length; i++) {
            if (restrictedSet.contains(edges[i][0]) || restrictedSet.contains(edges[i][1])) {
                continue;
            }
            if (!map.containsKey(edges[i][0])) {
                map.put(edges[i][0], new HashSet<>());
            }
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new HashSet<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0);
        return isVisited.size();
    }

    public void dfs(int index) {
        if (isVisited.contains(index)) {
            return;
        }
        isVisited.add(index);
        if (map.containsKey(index)) {
            for (int i : map.get(index)) {
                dfs(i);
            }
        }
    }

}
