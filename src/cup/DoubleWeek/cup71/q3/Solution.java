package cup.DoubleWeek.cup71.q3;

/**
 * @author 1iin
 */
public class Solution {
    int res = Integer.MAX_VALUE;
    int startAt;
    int moveCost;
    int pushCost;

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        this.startAt = startAt;
        this.moveCost = moveCost;
        this.pushCost = pushCost;
        for (int minute = 0; minute <= 99; minute++) {
            int second = targetSeconds - minute * 60;
            if (second > 99) {
                continue;
            }
            if (second < 0) {
                break;
            }
            if (minute == 0) {
                if (second < 10) {
                    helper("" + second);
                    helper("0" + second);
                    helper("00" + second);
                    helper("000" + second);
                } else {
                    helper("" + second);
                    helper("0" + second);
                    helper("00" + second);
                }

            } else if (minute < 10) {
                String secondStr;
                if (second < 10) {
                    secondStr = "0" + second;
                } else {
                    secondStr = "" + second;
                }
                helper(minute + secondStr);
                helper("0" + minute + secondStr);
            } else {
                String secondStr;
                if (second < 10) {
                    secondStr = "0" + second;
                } else {
                    secondStr = "" + second;
                }
                helper("" + minute + secondStr);
            }
        }
        return res;
    }

    public void helper(String str) {
        long process = 0;
        int pointer = startAt;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - '0' != pointer) {
                process += moveCost;
                pointer = chars[i] - '0';
            }
            if (process > res) {
                return;
            }
            process += pushCost;
            if (process > res) {
                return;
            }
        }
        System.out.println(res + " " + str);
        res = (int) Math.min(res, process);
    }
}
