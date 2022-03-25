package cup.SingleWeek.cup284.q4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 1iin
 */
public class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        Util util = new Util();
        long path = util.path(n, edges, dest, src1, src2);
        return path > Long.MAX_VALUE / 2 ? -1 : path;
    }
}

class Util {
    int N = (int) 1e5 + 10, M = (int) (1e5 + 10);
    int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    long[] dist = new long[N];
    boolean[] vis = new boolean[N];
    int n, k, idx;
    long INF = Long.MAX_VALUE / 2;

    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }

    public long path(int n, int[][] edges, int start, int end1, int end2) {
        this.n = n;
        k = start;
        Arrays.fill(he, -1);
        for (int[] t : edges) {
            int u = t[0], v = t[1], c = t[2];
            add(v, u, c);
        }
        dijkstra();
        long min = INF / 2;
        for (int i = 0; i <= n; i++) {
//            min = Math.min(dist[i]+)
        }
        return dist[end1];
    }

    void dijkstra() {
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        dist[k] = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        q.add(new long[]{k, 0});
        while (!q.isEmpty()) {
            long[] poll = q.poll();
            long id = poll[0], step = poll[1];
            if (vis[(int) id]) continue;
            vis[(int) id] = true;
            for (int i = he[(int) id]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[(int) id] + w[i]) {
                    dist[j] = dist[(int) id] + w[i];
                    q.add(new long[]{j, dist[j]});
                }
            }
        }
    }
}

