package cup.special.cmbchina.q1;

/**
 * @author 1iin
 */
public class Solution {
    public String deleteText(String article, int index) {
        String[] words = article.split(" ");
        int temp = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (temp + words[i].length() - 1 >= index && temp <= index) {
                temp += words[i].length() + 1;
                continue;
            }
            temp += words[i].length() + 1;
            stringBuilder.append(words[i]);
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }
        if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return String.valueOf(stringBuilder);
    }
}
