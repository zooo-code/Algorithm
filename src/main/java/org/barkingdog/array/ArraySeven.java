package org.barkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/13300
public class ArraySeven {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 남학생은 남학생 끼리,
        // 여학생은 여학생 끼리,
        // 같은 한년의 학생들을 배정 ,
        // 한방에 한명도 가능

        // 한방에 배정 가능 인원 최대 k 조건에 맞는 필요한 방의 최소 개수
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[][] matrix = new int[7][2];

        // 학년과 성별로 사람을 다 배열에 각 각 분리해서 모은 후 k 로 나눠서 답을 결정
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            int gender = Integer.parseInt(info[0]);
            int grade = Integer.parseInt(info[1]);

            matrix[grade][gender]++;

        }
        int answer = 0;
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix[i].length ; j++){

                if(matrix[i][j] != 0){
                    answer += matrix[i][j] / k ;
                    if (matrix[i][j] % k != 0){
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
