package cup.SingleWeek.cup303.q3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author 1iin
 */
public class FoodRatings {
    Map<String, TreeSet<String>> rankingMap;
    Map<String, Integer> positionMap;
    String[] foods;
    String[] cuisines;
    int[] ratings;

    public TreeSet<String> createTreeSet() {
        return new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ratings[positionMap.get(o2)] - ratings[positionMap.get(o1)] == 0 ? o1.compareTo(o2) : ratings[positionMap.get(o2)] - ratings[positionMap.get(o1)];
            }
        });
    }


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        positionMap = new HashMap<>();
        rankingMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            positionMap.put(foods[i], i);
            if (!rankingMap.containsKey(cuisines[i])) {
                rankingMap.put(cuisines[i], createTreeSet());
            }
            rankingMap.get(cuisines[i]).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        int pos = positionMap.get(food);
        TreeSet<String> temp = rankingMap.get(cuisines[pos]);
        temp.remove(food);
        ratings[pos] = newRating;
        temp.add(food);
    }

    public String highestRated(String cuisine) {
        TreeSet<String> temp = rankingMap.get(cuisine);
        return temp.first();
    }
}
