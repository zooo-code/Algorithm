package org.barkingdog.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class stackThree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        List<String> b = new ArrayList<>();
        int start = 1;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            // 입력한 숫자가 시작 숫자보다 크면
            if (value >= start) {
                // start + 1 부터 value 까지 stack에 push 하기(오름차순으로 push 됨)
                for (int num = start; num <= value; num++) {
                    stack.push(num);				// push
                    b.add("+");	// push한 만큼 + 출력
                }
                start = value + 1; // 다음 숫자부터 다시 push 준비
            }else if (stack.peek() != value){
                System.out.println("NO");
                return;
            }

            stack.pop();
            b.add("-");

        }

        for (String s : b) {
            System.out.println( s);
        }
    }
}
