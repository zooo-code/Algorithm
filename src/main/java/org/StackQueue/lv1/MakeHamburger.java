package org.StackQueue.lv1;

import java.util.Stack;
//https://school.programmers.co.kr/learn/courses/30/lessons/133502
public class MakeHamburger {

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int solution = new MakeHamburger().solution(ingredient);

        System.out.println("solution = " + solution);
    }
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> inStack = new Stack<>();

        for(int in : ingredient) {
            inStack.push(in);

            // 스택의 사이즈가 4이상이 됐을 경우 조건처리 시작 (오류방지)
            if(inStack.size() >= 4) {

                // Stack이 1231이 연달아 들어가있는 경우
                if(inStack.get(inStack.size()-4) == 1
                        && inStack.get(inStack.size()-3) == 2
                        && inStack.get(inStack.size()-2) == 3
                        && inStack.get(inStack.size()-1) == 1) {

                    answer++; // 값++
                    inStack.pop();
                    inStack.pop();
                    inStack.pop();
                    inStack.pop(); // 1231 총 4개를 pop()을 활용해 삭제
                }
            }

        }

        return answer;
    }
}
