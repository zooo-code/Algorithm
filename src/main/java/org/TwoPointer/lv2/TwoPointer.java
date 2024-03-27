package org.TwoPointer.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 해결 못함 투포인터 개념을 까먹음
// 부분 수열의 합을 구할 수 있다.
//https://school.programmers.co.kr/learn/courses/30/lessons/178870
public class TwoPointer {


    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int[] solution = solution(a, k);
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public static int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int left = 0;
        int right = N;
        int sum = 0;
        // 투 포인터를 이용해 부분 수열의 합을 구한다.
        for (int L = 0, R = 0; L < N; L++) {
            // 일단 sum < k 을 만족하지 않을 때까지 더한다.R 에 대한 변화는 아래 R++ 에서 조절한다.
            while (R < N && sum < k) {
                sum += sequence[R++];
            }
            if (sum == k) {
                int range = R - L - 1;
                if (range < right - left) {
                    right = R - 1;
                    left = L;
                }
            }
            sum -= sequence[L];

        }

        int[] answer = new int[]{left, right};
        return answer;
    }

}
