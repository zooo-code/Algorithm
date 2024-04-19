package org.barkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ArraySix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        int x = Integer.parseInt(br.readLine());

        int[] numA = new int[2000001];

        for(int i = 0 ; i < n ; i++){

            int  a = Integer.parseInt(s[i]);
            numA[a]++;
        }

        int answer =0;
        // x 의 절반만 돌아도 된다. 둘다 있어야 값이 ++ 하면된다.
        for(int i = 1 ; i < (x +1)/2 ; i++){
            if(numA[i] == 1 && numA[x-i] == 1){
                answer++;
            }
        }

        System.out.println( answer);
    }
}
