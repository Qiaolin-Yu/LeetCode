package cup.SingleWeek.cup278.q4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 1iin
 */
public class Solution {
    int[] parent;
    int[] num;
    Map<Integer, Set<Integer>> m = new HashMap<>();
    String[] words;

    public int[] groupStrings(String[] words) {
        this.words = words;
        parent = new int[words.length];
        num = new int[words.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int temp = 0;
            for (int j = 0; j < chars.length; j++) {
                temp |= 1 << (chars[j] - 'a');
            }
            num[i] = temp;
            m.put(i, new HashSet<>());
            m.get(i).add(temp);
            for (int j = 0; j < 26; j++) {
                int a = temp ^ (1 << j);
                m.get(i).add(a);
            }
            for (int j = 0; j < 26; j++) {
                if ((temp & (1 << j)) == 0) {
                    continue;
                }
                int a = temp ^ (1 << j);
                for (int k = 0; k < 26; k++) {
                    int b = a | (1 << k);
                    if (b == a) {
                        continue;
                    }
                    m.get(i).add(b);
                }

            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (find(i) == find(j)) {
                    continue;
                }
                if (isConnected(i, j)) {
                    union(i, j);
                }
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                ans[0]++;
            }
        }
        int[] counts = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            counts[find(i)]++;
        }
        for (int i = 0; i < counts.length; i++) {
            ans[1] = Math.max(ans[1], counts[i]);
        }
        return ans;
    }

    public boolean isConnected(int word1, int word2) {
        return m.get(word1).contains(num[word2]);
    }

    public int find(int word) {
        if (parent[word] != word) {
            parent[word] = find(parent[word]);
        }
        return parent[word];
    }

    public void union(int word1, int word2) {
        if (find(word1) == find(word2)) {
            return;
        }
        parent[find(word1)] = find(word2);
    }

}
