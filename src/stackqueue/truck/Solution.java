package stackqueue.truck;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> tq = new LinkedList<>();
        for(int truck : truck_weights){
            tq.offer(truck);
        }
        int time = 0;
        int sum = 0;
        while (!tq.isEmpty()) {
            int tqNum = tq.poll();
            while (true) {
                if (q.isEmpty()) {
                    q.offer(tqNum);
                    time++;
                    sum += tqNum;
                    break;
                } else if (q.size() == bridge_length) {
                    // 다리에서 트럭이 빠져나올때는 시간이 들지 않음.
                    sum -= q.poll();
                } else {
                    if (sum + tqNum <= weight) {
                        q.offer(tqNum);
                        time++;
                        sum += tqNum;
                        break;
                    } else {
                        q.offer(0);
                        time++;
                        //break가 없는 이유는 sum + tqNum > weight일때 0을 넣고
                        //한개의 트럭만이 지나갈 수 있도록 했기때문
                        //이후의 로직은 whil (true)이므로 위에서 처리해준다.
                    }
                }
            }
        }

        answer = time + bridge_length;
        System.out.println(answer);
        return answer;
    }
    public static void main(String args[]){
        int length = 2;
        int weight = 10;
        int[] truck = {7,4,5,6};
        Solution sol = new Solution();
        sol.solution(length, weight, truck);
    }
}
