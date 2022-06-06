package songmody.hash.music;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> arrAnswer = new ArrayList<Integer>();
        HashMap<String, Integer> mapMerge = new HashMap<>();
        // 장르별 재생수 총합 MAP생성
        for (int i = 0; i < genres.length; i++) {
            mapMerge.put(genres[i], mapMerge.getOrDefault(genres[i], 0) + plays[i]);
        }
        //장르별 재생 수 내림차순 정렬
        List<String> sorted_genres_list = new ArrayList<>(mapMerge.keySet());
        Collections.sort(sorted_genres_list, (o1, o2) -> (mapMerge.get(o2).compareTo(mapMerge.get(o1))));
        System.out.println("장르~~~~~~: "+Arrays.toString(new List[]{sorted_genres_list}));

        //장르 안의 고유번호에 따른 재생수 MAP생성
       for(String key : sorted_genres_list){
            HashMap<Integer, Integer> hs = new HashMap<>();
            for(int i = 0; i< genres.length; i++){
                if(key.equals(genres[i])){
                    hs.put(i, plays[i]);
                }
            }
            //고유번호 별 내림차순 정렬
            List<Integer> sorted_plays_list = new ArrayList<>(hs.keySet());
            sorted_plays_list.sort((s1, s2) -> (hs.get(s2).compareTo(hs.get(s1))));

            int j = 0;
            for(Integer max : sorted_plays_list){   //장르별 2개만 뽑아내기 위함. 0~1
                if(j > 1){
                    break;
                }
                arrAnswer.add(max);
                j++;
            }
            answer =  new int[arrAnswer.size()];
            for(int i = 0; i<arrAnswer.size(); i++){
                answer[i] = arrAnswer.get(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] generes = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(generes, plays)));
    }
}

