package cup.DoubleWeek.cup77.q4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 1iin
 */
public class Solution {
    int[][] grid;
    boolean isFlag = false;


    public int maximumMinutes(int[][] grid) {
        this.grid = grid;
        int left = 0;
        int right = grid.length * grid[0].length;
        if (!check(0, grid)) {
            return -1;
        }
        if (check(right + 1, grid)) {
            return 1000000000;
        }
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid, grid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int time, int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> peopleQueue = new LinkedList<>();
        peopleQueue.add(new int[]{0, 0});

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (temp[i][j] == 1) {
                    fireQueue.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < time; i++) {
            int size = fireQueue.size();
            for (int j = 0; j < size; j++) {
                int[] a = fireQueue.poll();
                if (isValid(a[0] - 1, a[1], temp)) {
                    fireQueue.add(new int[]{a[0] - 1, a[1]});
                    temp[a[0] - 1][a[1]] = 1;
                }
                if (isValid(a[0] + 1, a[1], temp)) {
                    fireQueue.add(new int[]{a[0] + 1, a[1]});
                    temp[a[0] + 1][a[1]] = 1;
                }
                if (isValid(a[0], a[1] - 1, temp)) {
                    fireQueue.add(new int[]{a[0], a[1] - 1});
                    temp[a[0]][a[1] - 1] = 1;
                }
                if (isValid(a[0], a[1] + 1, temp)) {
                    fireQueue.add(new int[]{a[0], a[1] + 1});
                    temp[a[0]][a[1] + 1] = 1;
                }
            }
        }

        while (!peopleQueue.isEmpty()) {
            int size = fireQueue.size();
            isFlag = false;
            for (int j = 0; j < size; j++) {
                int[] a = fireQueue.poll();
                if (isValid(a[0] - 1, a[1], temp)) {
                    if (a[0] - 1 == grid.length - 1 && a[1] == grid[0].length - 1) {
                        isFlag = true;
                    }
                    fireQueue.add(new int[]{a[0] - 1, a[1]});
                    temp[a[0] - 1][a[1]] = 1;
                }
                if (isValid(a[0] + 1, a[1], temp)) {
                    if (a[0] + 1 == grid.length - 1 && a[1] == grid[0].length - 1) {
                        isFlag = true;
                    }
                    fireQueue.add(new int[]{a[0] + 1, a[1]});
                    temp[a[0] + 1][a[1]] = 1;
                }
                if (isValid(a[0], a[1] - 1, temp)) {
                    if (a[0] == grid.length - 1 && a[1] - 1 == grid[0].length - 1) {
                        isFlag = true;
                    }
                    fireQueue.add(new int[]{a[0], a[1] - 1});
                    temp[a[0]][a[1] - 1] = 1;
                }
                if (isValid(a[0], a[1] + 1, temp)) {
                    if (a[0] == grid.length - 1 && a[1] + 1 == grid[0].length - 1) {
                        isFlag = true;
                    }
                    fireQueue.add(new int[]{a[0], a[1] + 1});
                    temp[a[0]][a[1] + 1] = 1;
                }
            }
            size = peopleQueue.size();
            for (int j = 0; j < size; j++) {
                int[] a = peopleQueue.poll();
                System.out.println(a[0] + " " + a[1]);
                if (isValid(a[0] + 1, a[1], temp)) {
                    if (a[0] + 1 == grid.length - 1 && a[1] == grid[0].length - 1) {
                        return true;
                    }
                    peopleQueue.add(new int[]{a[0] + 1, a[1]});
                }
//                if (isValid(a[0] - 1, a[1], temp)) {
//                    if (a[0] - 1 == grid.length - 1 && a[1] == grid[0].length - 1) {
//                        return true;
//                    }
//                    peopleQueue.add(new int[]{a[0] + 1, a[1]});
//                }
                if (isValid(a[0], a[1] + 1, temp)) {
                    if (a[0] == grid.length - 1 && a[1] + 1 == grid[0].length - 1) {
                        return true;
                    }
                    peopleQueue.add(new int[]{a[0], a[1] + 1});
                }
//                if (isValid(a[0], a[1] - 1, temp)) {
//                    if (a[0] == grid.length - 1 && a[1] - 1 == grid[0].length - 1) {
//                        return true;
//                    }
//                    peopleQueue.add(new int[]{a[0], a[1] + 1});
//                }
            }
        }
        return false;
    }

    public boolean isValid(int row, int col, int[][] temp) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        if (row == grid.length - 1 && col == grid[0].length - 1 && isFlag) {
            return true;
        }
        if (temp[row][col] != 0) {
            return false;
        }
        return true;
    }
}

