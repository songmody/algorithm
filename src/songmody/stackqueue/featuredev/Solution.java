package songmody.stackqueue.featuredev;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> proQ = new LinkedList<>();
        Queue<Integer> spdQ = new LinkedList<>();
        List<Integer> ansList = new ArrayList<>();
        int percent = 0;
        int days = 1;
        int cnt = 0;
        for (int pro : progresses) {
            proQ.offer(pro);
        }
        for (int sp : speeds) {
            spdQ.offer(sp);
        }

        // 바로 조건문으로 들어가면 안됨.
        while (!proQ.isEmpty()) {
            percent = proQ.peek() + (spdQ.peek() * days);
            if (percent >= 100) {
                cnt++;
                proQ.poll();
                spdQ.poll();
            } else {
                // answer에 값을 넣는 시기가 100이상일떄가 아닌 다음큐값일때이므로
                // 다음 큐값때 cnt값을 가지고 있으면 answer에 add한다.
                if (cnt > 0) {
                    ansList.add(cnt);
                }
                days++;
                cnt = 0;
            }
        }
        // 위에서 다음값을 이용한 로직이므로 맨 마지막 큐값을 이용하기 위해서 while끝난 뒤 한번더.
        ansList.add(cnt);

        // 반환을 위해 answer배열 초기화해줘야함!
        answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] pro = {93, 30, 55};
        int[] sp = {1, 30, 5};
        Solution sol = new Solution();
        sol.solution(pro, sp);
    }
}