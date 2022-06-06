package songmody.hash.spy;

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> total = new HashMap<>();
        int res = 1;
        //HashMap에 의상종류(key)와 각 의상종류마다 몇개 있는지(value)를 put함.
        for (int i = 0; i < clothes.length; i++) {
            String[] inClothes = clothes[i];
            for (int k = 1; k < inClothes.length; k += 2) {
                System.out.print(inClothes[k] + " ");
                total.put(inClothes[k], total.getOrDefault(inClothes[k], 0) + 1);
            }
        }
//        for (Map.Entry<String, Integer> elem : total.entrySet()) {
//            res = res * (elem.getValue() + 1);
//        }
        //value를 꺼내기 위해서는 위의 방법보다 아래 방법이 편할듯 하다.
        for(String key : total.keySet()){
            res *= (total.get(key) + 1);
        }
        return res - 1;
    }

    public static void main(String[] args){
        String[][] ff = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] ee = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        Solution sol = new Solution();
        System.out.println(sol.solution(ee));
    }
}
