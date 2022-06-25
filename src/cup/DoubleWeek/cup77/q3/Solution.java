package cup.DoubleWeek.cup77.q3;


import java.util.Arrays;

/**
 * @author 1iin
 */
public class Solution {
    char[][] map;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        map = new char[m][n];
        for (char[] chars : map) {
            Arrays.fill(chars, ' ');
        }
        for (int[] guard : guards) {
            map[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall : walls) {
            map[wall[0]][wall[1]] = 'W';
        }
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 'G') {
                    if (isValid(row, col - 1, 'l')) {
                        dfs(row, col - 1, 'l');
                    }
                    if (isValid(row - 1, col, 'u')) {
                        dfs(row - 1, col, 'u');
                    }
                    if (isValid(row + 1, col, 'd')) {
                        dfs(row + 1, col, 'd');
                    }
                    if (isValid(row, col + 1, 'r')) {
                        dfs(row, col + 1, 'r');

                    }
                }
            }
        }
        int res = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == ' ') {
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int row, int col, char direction) {
        if (map[row][col] == ' ') {
            map[row][col] = '.';
        }
        if (direction == 'd') {
            if (isValid(row + 1, col, 'd')) {
                dfs(row + 1, col, 'd');
            }
        }

        if (direction == 'u') {
            if (isValid(row - 1, col, 'u')) {
                dfs(row - 1, col, 'u');
            }
        }
        if (direction == 'r') {
            if (isValid(row, col + 1, 'r')) {
                dfs(row, col + 1, 'r');
            }
        }
        if (direction == 'l') {
            if (isValid(row, col - 1, 'l')) {
                dfs(row, col - 1, 'l');
            }
        }
    }

    public boolean isValid(int row, int col, char direction) {
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length) {
            return false;
        }
        if (map[row][col] == 'W') {
            return false;
        }
        if (direction == map[row][col]) {
            return false;
        }
        if (map[row][col] == 'G') {
            if (direction == 'd') {
                map[row - 1][col] = 'u';
            } else if (direction == 'u') {
                map[row + 1][col] = 'd';
            } else if (direction == 'r') {
                map[row][col - 1] = 'l';
            } else if (direction == 'l') {
                map[row][col + 1] = 'r';
            }
            return false;
        }
        return true;
    }
}
