package org.Heap;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/138477
public class Honor {

    public static void main(String[] args) {

        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        Honor honor = new Honor();

        System.out.println("solution = " + Arrays.toString(honor.solution(k, score)));
    }


    public int[] solution(int k, int[] score) {

        // 결과를 담을 배열 선언
        int[] answer = new int[score.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        for(int i = 0; i < score.length; i++) {
            priorityQueue.add(score[i]);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            answer[i] = priorityQueue.peek();
        }
        return answer;

    }
}

