package org.BinarySearch.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 못풀음 이진 탐색 개념 + 구현 능력 부족
// https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class RankSearch {


    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            String[] p = info[i].split(" ");
            makeSentence(map , p, "", 0);
        }
        for (String key : map.keySet())
            Collections.sort(map.get(key));
        int cnt = 0;
        for(String q : query){
            StringBuilder br = new StringBuilder();
            String[] s = q.split(" ");
            String key = br.append(s[0])
                    .append(s[2])
                    .append(s[4])
                    .append(s[6])
                    .toString();
            int score = Integer.parseInt(s[7]);
            List<Integer> scoreList = map.getOrDefault(key, new ArrayList<>());


            answer[cnt] = binarySearch(scoreList,score) ;
            cnt++;
        }

        return answer;
    }


    // info가 포함될 수 있는 문장
    private static void makeSentence(HashMap<String, List<Integer>> map  , String[] p, String str, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeSentence(map, p, str + "-", cnt + 1);
        makeSentence(map, p, str + p[cnt], cnt + 1);
    }

    // 이제 이진 탐색으로 요구 점수이상인 인덱스를 찾아서 계산
    private static int binarySearch(List<Integer> scoreList , int score){
        int start = 0;
        int end = scoreList.size() -1;

        while(start <= end){
            int mid = (start + end)/2;
            int midScore = scoreList.get(mid);

            if (midScore < score){
                start = mid +1;
            } else{
                end = mid -1;
            }
        }

        return  scoreList.size() - start;
    }
}

