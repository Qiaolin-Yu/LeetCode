package cup.DoubleWeek.cup65.q2;

/**
 * @author 1iin
 */
public class Robot {
    int[][] map;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[] pos = new int[]{0, 0};
    int d = 0;

    public Robot(int width, int height) {
        map = new int[width][height];
    }

    public void moveOne() {
        if (pos[0] + directions[d][0] >= map.length || pos[1] + directions[d][1] >= map[0].length
                || pos[0] + directions[d][0] < 0 || pos[1] + directions[d][1] < 0) {
            d = (d + 1) % 4;
        }
        pos[0] += directions[d][0];
        pos[1] += directions[d][1];
    }

    public void move(int num) {
        if (num > map.length * 2 + map[0].length * 2 - 4) {
            num = num % (map.length * 2 + map[0].length * 2 - 4);
            if (pos[0] == 0 && pos[1] == 0) {
                d = 3;
            }
        }
        while (num-- > 0) {
            moveOne();
        }
    }

    public int[] getPos() {
        return pos;
    }

    public String getDir() {
        if (d == 0) {
            return "East";
        }
        if (d == 1) {
            return "North";
        }
        if (d == 2) {
            return "West";
        }
        return "South";
    }
}
