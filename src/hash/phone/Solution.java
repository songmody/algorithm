package hash.phone;

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String temp = "";
        Boolean res = true;


        for(String phone : phone_book){
            map.put(phone, phone.length());
        }
        System.out.println(map.entrySet());

        for(int i = 0; i<phone_book.length; i++){
            for(int j = 1; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    res = false;
                }
            }

        }
        return res;
    }

    public static void main(String[] args){
        String[] phone_book = {"12","123","1235","567","88"};
        Solution sol = new Solution();
        System.out.println(sol.solution(phone_book));
    }
}