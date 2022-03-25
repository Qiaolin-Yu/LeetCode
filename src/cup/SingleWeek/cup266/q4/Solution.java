package cup.SingleWeek.cup266.q4;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (edgeMap.get(edges[i][0]) == null) {
                edgeMap.put(edges[i][0], new ArrayList<>());
            }
            if (edgeMap.get(edges[i][1]) == null) {
                edgeMap.put(edges[i][1], new ArrayList<>());
            }
            edgeMap.get(edges[i][0]).add(i);
            edgeMap.get(edges[i][1]).add(i);
        }
        Queue<State> queue = new LinkedList<>();
        int res = values[0];
        State state = new State(0, values[0], 0);
        state.track = new HashSet<>();
        state.track.add(0);
        queue.add(state);
        while (!queue.isEmpty()) {
            state = queue.poll();
            if (state.position == 0) {
                res = Math.max(state.value, res);
            }
            List<Integer> out = edgeMap.get(state.position);
            if (out == null) {
                continue;
            }
            for (int i = 0; i < out.size(); i++) {
                int newPosition = state.position == edges[out.get(i)][0] ? edges[out.get(i)][1] : edges[out.get(i)][0];
                if (state.cost + edges[out.get(i)][2] <= maxTime && newPosition == 0 || state.cost + edges[out.get(i)][2] <= maxTime - 10) {
                    int newValue = state.track.contains(newPosition) ? 0 : values[newPosition];
                    State newState = new State(newPosition, state.value + newValue, state.cost + edges[out.get(i)][2]);
                    newState.track = new HashSet<>(state.track);
                    newState.track.add(newPosition);
                    queue.add(newState);
                }
            }
        }
        return res;
    }
}

class State {
    int position;
    int value;
    int cost;
    Set<Integer> track;

    public State(int position, int value, int cost) {
        this.position = position;
        this.value = value;
        this.cost = cost;
    }
}