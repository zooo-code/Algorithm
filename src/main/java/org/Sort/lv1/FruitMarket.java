package org.Sort.lv1;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/135808
public class FruitMarket {


    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = {1,2,3,1,2,3,1};

        FruitMarket fruitMarket = new FruitMarket();
        int solution = fruitMarket.solution(k, m, score);
        System.out.println(solution);
    }

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        int count = 0;
        for (int i = score.length -1 ; i>=0 ; i--){

            count++;
            if (count==m){
                answer += score[i] * m;
                count = 0;
            }
        }
        int i = score[score.length -1];

        System.out.println("i = " + i);
        return answer;
    }
}
