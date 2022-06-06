package songmody.monthlyCodeChallengeSeason.firstSeason;

import java.util.*;

public class SumTwoArg {

    public int[] solution(int[] numbers) {
        ArrayList<Integer> ansList = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            for (int k = i + 1; k < numbers.length; k++) {
                if (!ansList.contains(numbers[i] + numbers[k])) {
                    ansList.add(numbers[i] + numbers[k]);
                    System.out.println("****" + ansList.toString());
                }
            }
        }

        int[] answer = new int[ansList.size()];
        Collections.sort(ansList);

        for (int j = 0; j < ansList.size(); j++) {
            answer[j] = Integer.parseInt(String.valueOf(ansList.get(j)));

            System.out.println(answer[j]);
        }
        return answer;
    }
}
