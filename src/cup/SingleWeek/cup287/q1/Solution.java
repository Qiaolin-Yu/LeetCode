package cup.SingleWeek.cup287.q1;

/**
 * @author 1iin
 */
public class Solution {
    public int convertTime(String current, String correct) {
        int hour1 = Integer.parseInt(current.substring(0, 2));
        int minute1 = Integer.parseInt(current.substring(3, 5)) + hour1 * 60;

        int hour2 = Integer.parseInt(correct.substring(0, 2));
        int minute2 = Integer.parseInt(correct.substring(3, 5)) + hour2 * 60;

        int change = (minute2 + 3600 * 24 - minute1) % (3600 * 24);
        int count = 0;
        count += change / 60;
        change = change % 60;
        count += change / 15;
        change = change % 15;
        count += change / 5;
        change = change % 5;
        count += change;
        change = 0;
        return count;
    }
}
