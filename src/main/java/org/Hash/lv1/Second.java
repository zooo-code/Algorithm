package org.Hash.lv1;

import java.util.*;
//10 분 걸림
//https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class Second {

    public static void main(String[] args) {
        Second second = new Second();
        String s = "banana";
        int[] solution = second.solution(s);

        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, List<Integer>> map = new HashMap<>();
        String[] split = s.split("");

        for (int i = 0 ; i < split.length ;i++ ){
            if(!map.containsKey(split[i])){
                answer[i] = -1;
                List<Integer> a = new ArrayList<>();
                a.add(i);
                map.put(split[i],a);
            } else{
                List<Integer> a = map.get(split[i]);

                int n = i-a.get(a.size()-1);
                a.add(i);
                answer[i] = n ;
            }

        }

        return answer;
    }
}
