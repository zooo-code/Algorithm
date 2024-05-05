package org.barkingdog.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/10866
public class DequeOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            if(split[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(split[1]));
            } else if (split[0].equals("push_front")) {
                deque.addFirst(Integer.parseInt(split[1]));
            } else if (split[0].equals("pop_front")) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.removeFirst());
                }else{
                    System.out.println("-1");
                }
            }else if(split[0].equals("pop_back")) {
                if(!deque.isEmpty()) {
                    System.out.println(deque.removeLast());
                }else{
                    System.out.println("-1");
                }
            }else if(split[0].equals("size")) {
                System.out.println(deque.size());
            }else if(split[0].equals("empty")) {
                if(deque.isEmpty()) {
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(split[0].equals("front")) {
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.peekFirst());
                }
            }else if(split[0].equals("back")) {
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.peekLast());
                }
            }
        }
    }
}
