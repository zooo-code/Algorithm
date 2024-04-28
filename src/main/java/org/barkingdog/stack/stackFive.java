package org.barkingdog.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 이 문제의 핵심은 i번째 빌딩의 높이 h(i)를 기준으로 이전 빌딩들 중,
 * i번째 빌딩의 높이 h(i)보다 낮은 빌딩은 체크할 필요가 없다는 점 입니다.
 * 위의 예시에서 1, 2, 3, 4번째 빌딩들을 순으로 관찰 가능한지를 체크해 오다가,
 * 5번째 빌딩에서 가로막혀 버리기 때문에 1, 2, 3, 4에서의 확인했던 내용들을 확인할 필요가 없어지게 됩니다.
 * 5번째 빌딩부터 다시 관찰 가능한 다음 빌딩이 무엇일까를 확인해 보면 되는거죠. 이러한 방식은 '모노스택' 이론에 해당하는 문제 입니다.
 * 기본적인 스택 기능을 가지며 모든 원소들이 오름차순(혹은 내림차순)을 유지하도록 하며 체크하는 방식 입니다.
 */
//https://www.acmicpc.net/problem/6198
public class stackFive {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long ans = 0 ;

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            //현재 입력이 들어온 높이를 확인합니다.
            int height = Integer.parseInt(br.readLine());
            // 스택이 비어있지 않다면
            while(!stack.isEmpty() && stack.peek() <= height) {
                // 가장 위에 있는 높이의 값을 현재 들어온 높이와 비교하고
                // 만약에 현재의 높이가 높거나 같다면
                // i번째 빌딩보다 낮거나 같은 애들은 빼버린다.
                stack.pop();
            }
            // 이때 매번 입력이 들어온 스택의 사이즈를 더합니다.
            ans += stack.size(); //스택 사이즈를 더함으로써, 벤치마킹 가능한 개수를 더해준다.
            stack.push(height); //i번째 빌딩의 높이를 넣어준다.
        }
        System.out.println(ans);
    }
}
