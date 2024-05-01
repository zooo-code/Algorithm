package org.barkingdog.queue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/2164
public class QueueThree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }

        while (true) {
            if( queue.size() == 1){
                System.out.println(queue.poll());
            }
            if(queue.isEmpty()){
                break;
            }
            queue.pollFirst();
            Integer b = queue.pollFirst();

            queue.add(b);

        }
    }
}
