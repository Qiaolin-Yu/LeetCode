package cup.DoubleWeek.cup69.q1;

/**
 * @author 1iin
 */
public class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            if (word.length == 1 || word.length == 2) {
                words[i] = words[i].toLowerCase();

            } else {
                words[i] = words[i].toLowerCase();
                word = words[i].toCharArray();
                word[0] = Character.toUpperCase(word[0]);
                words[i] = String.valueOf(word);
            }
            res.append(words[i]);
            if (i == words.length - 1) {
                continue;
            }
            res.append(" ");
        }
        return res.toString();
    }
}
