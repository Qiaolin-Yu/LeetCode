package cup.DoubleWeek.cup68.q2;

import java.util.*;

/**
 * @author 1iin
 */
public class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> recipeSet = new HashSet<>();
        Set<String> supply = new HashSet<>(Arrays.asList(supplies));
        int temp = 0;
        while (true) {
            for (int i = 0; i < ingredients.size(); i++) {
                boolean flag = true;
                for (String s : ingredients.get(i)) {
                    if (!supply.contains(s) && !recipeSet.contains(s)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    recipeSet.add(recipes[i]);
                }
            }
            if (temp == recipeSet.size()) {
                break;
            }
            temp = recipeSet.size();
        }
        return new ArrayList<>(recipeSet);
    }
}