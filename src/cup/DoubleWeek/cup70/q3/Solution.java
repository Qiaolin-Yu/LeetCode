package cup.DoubleWeek.cup70.q3;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    int[][] grid;
    int[] pricing;
    boolean[][] isVisited;
    int k;
    PriorityQueue<Thing> heap = new PriorityQueue<>(new Comparator<Thing>() {
        @Override
        public int compare(Thing o1, Thing o2) {
            if (o1.distance != o2.distance) {
                return o2.distance - o1.distance;
            }
            if (o1.val != o2.val) {
                return o2.val - o1.val;
            }
            if (o1.row != o2.row) {
                return o2.row - o1.row;
            }
            return o2.col - o1.col;
        }
    });

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        this.grid = grid;
        this.pricing = pricing;
        this.k = k;
        this.isVisited = new boolean[grid.length][grid[0].length];
        bfs(start);
        LinkedList<List<Integer>> res = new LinkedList<>();
        while (!heap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Thing thing = heap.poll();
            temp.add(thing.row);
            temp.add(thing.col);
            res.addFirst(temp);
        }
        return res;
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0 && !isVisited[row][col];
    }

    public void bfs(int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        int[] root = new int[]{start[0], start[1], 0};

        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            int row = root[0];
            int col = root[1];
            int distance = root[2];
            isVisited[row][col] = true;
            if (isValid(row + 1, col)) {
                queue.add(new int[]{row + 1, col, distance + 1});
                isVisited[row + 1][col] = true;
            }
            if (isValid(row - 1, col)) {
                queue.add(new int[]{row - 1, col, distance + 1});
                isVisited[row - 1][col] = true;
            }
            if (isValid(row, col + 1)) {
                queue.add(new int[]{row, col + 1, distance + 1});
                isVisited[row][col + 1] = true;
            }
            if (isValid(row, col - 1)) {
                queue.add(new int[]{row, col - 1, distance + 1});
                isVisited[row][col - 1] = true;
            }
            if (grid[row][col] != 1) {
                add(distance, row, col);
            }
        }

    }

    public void add(int distance, int row, int col) {
        if (grid[row][col] < pricing[0] || grid[row][col] > pricing[1]) {
            return;
        }
        Thing thing = new Thing(distance, grid[row][col], row, col);
        if (heap.size() < k) {
            heap.add(thing);
            return;
        }
        Thing temp = heap.peek();
        boolean change = false;
        if (thing.distance > temp.distance) {
            return;
        } else if (thing.distance < temp.distance) {
            heap.poll();
            heap.add(thing);
            return;
        }
        if (thing.val > temp.val) {
            return;
        } else if (thing.val < temp.val) {
            heap.poll();
            heap.add(thing);
            return;
        }
        if (thing.row > temp.val) {
            return;
        } else if (thing.row < temp.row) {
            heap.poll();
            heap.add(thing);
            return;
        }
        if (thing.col < temp.col) {
            heap.poll();
            heap.add(thing);
        }

    }
}

class Thing {
    int distance;
    int val;
    int row;
    int col;

    public Thing(int distance, int val, int row, int col) {
        this.distance = distance;
        this.val = val;
        this.row = row;
        this.col = col;
    }
}