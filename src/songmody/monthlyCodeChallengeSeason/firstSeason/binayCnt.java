package songmody.monthlyCodeChallengeSeason.firstSeason;
import java.util.*;
public class binayCnt {

        public int[] solution(String s) {
            int[] answer = new int[2];
            int calCon = 0;
            int zeroCnt = 0;

            int superZeroCnt = 0;
            int superCalCnt = 0;
            int afterCalLeng = 0;

            String answerStr = "";

            while(!answerStr.equals("1") && afterCalLeng != 1){
                for(int i = 0; i<s.length(); i++){
                    char flag = s.charAt(i);
                    if(flag == '0'){
                        calCon++;
                        superZeroCnt++;
                    }
                }


                afterCalLeng = s.length() - calCon;
                System.out.println("afterCalLeng : " + afterCalLeng);


                while(afterCalLeng != 0){
                    String an = Integer.toString(afterCalLeng % 2);
                    answerStr = an + answerStr;
                    System.out.println("answer : " + answerStr);
                    afterCalLeng = afterCalLeng / 2;
                    superCalCnt++;
                }
                answer[0] = superZeroCnt;
                answer[1] = superCalCnt;
            }

            return answer;
        }

    public static void main(String[] args) {
        binayCnt binayCnt = new binayCnt();
        binayCnt.solution("01110");
    }
}
