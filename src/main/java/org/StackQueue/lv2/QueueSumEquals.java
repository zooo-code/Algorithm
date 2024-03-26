package org.StackQueue.lv2;

import java.util.LinkedList;
import java.util.Queue;

// 30 분 고민후 해설 참조
// 핵심 그냥 작을때 옮기고 다 더하자.
// https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=java
public class QueueSumEquals {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        //pop insert 합쳐서 작업을 1회 수행
        long sum = 0;
        long q1Sum = 0;
        long q2Sum = 0;

        for(int i = 0 ; i < queue1.length ; i++){
            sum += queue1[i] + queue2[i];
            q1Sum += queue1[i];
            q2Sum += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);

        }
        if(q1Sum == q2Sum){

            return 0;
        }
        System.out.println(sum + " q1Sum " + q1Sum + " q2Sum " + q2Sum);

        while(true){

            if(q1Sum < q2Sum){
                int out = q2.poll();
                q2Sum -= out;

                q1.offer(out);
                q1Sum += out;
                answer +=1;

            } else if(q1Sum > q2Sum ){
                int out = q1.poll();
                q1Sum -= out;

                q2.offer(out);
                q2Sum += out;
                answer +=1;
            } else{
                break;
            }
            //반복을 각 큐만큼 의 길이만큼 보다 더 하고 2배 더하면 안되는 것
            if(answer > (queue1.length + queue2.length) * 2)
                return -1;
        }



        return answer;
    }
}
