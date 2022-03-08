package stackqueue.Coin;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < 5; i++){
            answer[0] ++;
        }

        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i]+", ");
        }
        return answer;
    }
    public static void main(String args[]){
        int[] prices = {5, 25, 50, 75, 100};
        Solution coin = new Solution();
        coin.solution(prices);
    }
}
