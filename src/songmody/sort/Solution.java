package songmody.sort;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int i = 0;
        int j = 0;
        int k = 0;
        List<Integer> modifiedArr = new ArrayList<>();
//        modifiedArr.setan = new int[commands.length];
        for(int p = 0; p < commands.length; p++){
            i = commands[p][0];
            j = commands[p][1];
            k = commands[p][2];

            modifiedArr.clear();
            for(int g = i-1; g < j; g++){
                modifiedArr.add(array[g]);
            }
            Collections.sort(modifiedArr);
            answer[p] = modifiedArr.get(k-1);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public static void main(String args[]){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] cmd = {{2,5,3},{4,4,1},{1,7,3}};
        Solution sol = new Solution();
        sol.solution(array, cmd);
    }
}