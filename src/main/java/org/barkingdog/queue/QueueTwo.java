package org.barkingdog.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


//https://www.acmicpc.net/problem/10845
public class QueueTwo {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            if(split[0].equals("push")){
                int a = Integer.parseInt(split[1]);
                queue.offer(a);
            } else if (split[0].equals("pop")) {
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.poll());
                }
            }else if (split[0].equals("size")) {
                System.out.println(queue.size());
            }else if (split[0].equals("empty")) {
                if(queue.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if (split[0].equals("front")) {
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.peek());

                }
            }else if (split[0].equals("back")) {
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(queue.peekLast());

                }
            }
        }
    }
}
