package org.Sort.lv2;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=java
public class HIndex {

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();

        int[] citations = {3, 3, 3, 3, 6,7,7,7};

        int solution = hIndex.solution(citations);
        System.out.println("solution = " + solution);

    }

    public int solution(int[] citations) {
        int answer =0;
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        for (int i = 0 ; i <citations.length ; i++) {
            int h = citations.length -i;

            if (citations[i] >=h){
                answer = h;
                break;
            }

        }


        return answer;
    }
}
