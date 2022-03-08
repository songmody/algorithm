package stackqueue.Coin;

import java.util.ArrayList;
import java.util.List;

public class Coin_firstTry {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cnt = 0;
        boolean flag = false;
        List<Integer> ansList = new ArrayList<>();
        for(int i = 0; i< prices.length; i++){
            cnt = 0;
            flag = false;
            for(int k = i+1; k < prices.length; k++){
                cnt++;
                if(prices[i] > prices[k]){
                    ansList.add(cnt);
                    flag = true;
                    break;
                }
            }
        }
        answer = new int[ansList.size()];
        for(int i = 0; i< answer.length; i++){
            answer[i] = ansList.get(i);
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String args[]){
        int[] prices = {1,2,3,2,3};
        Coin_firstTry coin = new Coin_firstTry();
        coin.solution(prices);
    }
}
