package songmody.monthlyCodeChallengeSeason.firstSeason;
import java.util.*;

public class Trit {

        public int solution(int n) {
            int answer = 0;
            String normalThird = "";
            ArrayList<Integer> reversalThirdArr = new ArrayList<>();
            int mod = 0;

            // #. 진법 변환에는 여러 방법이 있겠지만 0승인 뒤에서 부터 채워져야하기 때문에 순서가 중요하다.
            // #. list사용법 : add한 후 reverse()라이브러리사용 or for문 시 뒤에서부터 꺼내오는 방법
            // #. string 사용 : normalThird = mod + normalThird와 같이 사용하거나.

            while(n > 0){
                mod = n % 3;
                n = n / 3;
                // normalThird = mod + normalThird;
                reversalThirdArr.add(mod);
            }
            // #. 이미 앞뒤가 반전된 3진법 이기 때문에 reverse할필요가 없음.
            // System.out.println(reversalThirdArr.toString());
            // Collections.reverse(normalThirdArr);
            // System.out.println("after : " + normalThirdArr.toString());

            // #. 0부터 시작하므로 size - 1필요.
            int arrSize = reversalThirdArr.size() - 1;
            for(int i = 0; i < reversalThirdArr.size(); i++){
                answer +=  reversalThirdArr.get(i) * Math.pow(3, arrSize);
                arrSize--;
            }
            return answer;
        }

    public static void main(String[] args) {
        Trit trit = new Trit();
        trit.solution(45);
    }
}
