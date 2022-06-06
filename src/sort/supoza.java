//package sort;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class supoza {
//    public int[] solution(int[] answers) {
//        int[] methodFirst = {1,2,3,4,5};
//        int[] methodSecond = {2,1,2,3,2,4,2,5};
//        int[] methodThird = {3,3,1,1,2,2,4,4,5,5};
//        int[] scores = {0,0,0};
//
//        for(int i = 0; i< answers.length; i++){
//            if(methodFirst[i % 5] == answers[i]) {scores[0]++;}
//            if(methodSecond[i % 8] == answers[i]) {scores[1]++;}
//            if(methodThird[i % 10] == answers[i]) {scores[2]++;}
//        }
//
//        int ansList[] = new int[scores.length];
//        for(int i = 0; i< scores.length; i++){
//            ansList[i] = scores[i];
//        }
//        //오름차순정렬 -> 제일 높은 요소가 ansList의 맨 마지막 위치인 ansList[2]에 위치하게됨
//        Arrays.sort(ansList);
//        List<Integer> list = new ArrayList<>();
//
//        for(int i = 0; i< scores.length; i++){
//            if(scores[i] == ansList[2]){
//                list.add(i+1);
//            }
//        }
//        int[] answer = new int[list.size()];
//        for(int i = 0; i<list.size(); i++){
//            answer[i] = list.get(i);
//            System.out.println(answer[i]);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        int arr[] = {1,3,2,4,2};
//        supoza su = new supoza();
//        su.solution(arr);
//    }
//}
