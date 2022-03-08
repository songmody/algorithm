package stackqueue.printer;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Task{
        int priority;
        int location;
        Task(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
    public int solution(int[] priorities, int loca) {
        int answer = 0;
        Queue<Task> queue = new LinkedList<>();
        for(int i = 0; i< priorities.length; i++){
            queue.offer(new Task(priorities[i], i));
        }

        for(Task ts : queue){
            System.out.println(ts.priority + ": "+ ts.location);
        }

        int cnt = 0;
        while (!queue.isEmpty()){
            boolean flag = false;
            Task ts = queue.poll();
            for (Task comTs : queue) {
                if (ts.priority < comTs.priority) {
                    flag = true;
                }
            }
            if (flag) {
                queue.offer(ts);
            }else{
                cnt++;
                if(loca == ts.location){
                    answer =  cnt;
                    break;
                }
            }
        }
        System.out.println("answer: " + answer);
        return answer;
    }

    public static void main(String args[]) {
        int[] prior = {2, 1, 3, 2};
        int loca = 2;
        Solution sol = new Solution();
        sol.solution(prior, loca);
    }
}