package songmody.hash.spy;

import java.util.HashMap;
import java.util.Map;

public class Solution_firstTry {
    public int solution_first(String[][] clothes) {
        HashMap<String, Integer> total = new HashMap<>();
        int res = 0;
        int res2 = 1;
        int realres = 0;
        //HashMap에 의상종류(key)와 각 의상종류마다 몇개 있는지(value)를 put함.
        for (int i = 0; i < clothes.length; i++) {
            String[] inClothes = clothes[i];
            for (int k = 1; k < inClothes.length; k += 2) {
                System.out.print(inClothes[k] + " ");
                total.put(inClothes[k], total.getOrDefault(inClothes[k], 0) + 1);
            }

        }
        System.out.println(total.entrySet());
        //각 종류마다 갯수(value)를 꺼내와서 각 종류 sum(value)하고 value끼리 곱한 값을 더하는 식을 세웠는데 아님. 예제만 맞음.
        for (Map.Entry<String, Integer> elem : total.entrySet()) {
            res = res + elem.getValue();
            if (total.keySet().size() <= 1) {
                realres = res;
            } else {
                res2 = res2 * elem.getValue();
                realres = res + res2;
            }
        }
        System.out.println("res: " + res + ", res2: " + res2 + " res + res2 : " + realres);

        return realres;
    }

    public static void main(String[] args) {
        String[][] ff = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] ee = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        Solution_firstTry sol = new Solution_firstTry();
        sol.solution_first(ff);
    }
}
