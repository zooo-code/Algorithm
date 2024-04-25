package org.barkingdog.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//https://www.acmicpc.net/problem/10773
public class stackTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());

            if(a!= 0){
                stack.push(a);
            }else{
                stack.pop();
            }
        }
        int answer =0;
        for (Integer i : stack) {
            answer+=i;
        }

        System.out.println(answer);
    }
}
