package songmody.hash.race;

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String res = "";
        for (String part : participant) {
            //getOrDefault(key,defaultValue) : 해당 key에 값이 있을 경우 기존 값사용, 없을 경우 defaultValue초기화
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        for (String comp : completion) {
            map.put(comp, map.get(comp) -1);
        }

        //map의 전체 key값 -> keySet() / 전체 key, val값 -> entrySet()
        for(String key : map.keySet()){
            if(map.get(key) > 0){
                res = key;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        Solution sol = new Solution();
        System.out.println(sol.solution(participant, completion));
    }
}