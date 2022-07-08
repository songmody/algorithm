package songmody.monthlyCodeChallengeSeason.firstSeason;

import java.util.*;

public class TriangleSnail {
        public int[] solution(int n) {
            int[] answer = new int[(n*(n+1))/2];
            int[][] mat = new int[n][n];
            int x = -1;
            int y = 0;
            int num = 1;

            for(int i = 0; i<n; i++){
                for(int j = i; j<n; j++){
                    // #. 방향성이 3개니깐 3을 기준으로 하는거겠지? -> 사각형도 해보자.!!
                    if(i % 3 == 0){
                        x++;
                    }else if(i%3 == 1){
                        y++;
                    }else if(i%3 == 2){
                        x--;
                        y--;
                    }
                    mat[x][y] = num++;
                }
            }

            int k = 0;
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(mat[i][j] == 0) break;
                    answer[k++] = mat[i][j];
                }
            }
            return answer;
        }
}
