package cup.SingleWeek.cup287.q4;

import java.util.*;

/**
 * @author 1iin
 */
public class Encrypter {
    Map<Character, String> keyToValue;
    Map<String, List<Character>> valueToKey;
    Set<String> dictionarySet;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        keyToValue = new HashMap<>();
        valueToKey = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            keyToValue.put(keys[i], values[i]);
            valueToKey.put(values[i], valueToKey.getOrDefault(values[i], new ArrayList<>()));
            valueToKey.get(values[i]).add(keys[i]);
        }
        this.dictionarySet = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            dictionarySet.add(dictionary[i]);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        char[] chars = word1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(keyToValue.getOrDefault(chars[i], String.valueOf(chars[i])));
        }
        return String.valueOf(sb);
    }

    public int decrypt(String word2) {
        int count = 0;
        for (String key : dictionarySet) {
            if (encrypt(key).equals(word2)) {
                count++;
            }
        }
        return count;
    }

}

