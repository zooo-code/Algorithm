package org.barkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1475
public class ArrayThree {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String a  = bufferedReader.readLine();

        char[] charArray = a.toCharArray();
        int[] array = new int[10];
        for(char c : charArray){
            array[c-'0']++;
        }

        for(int i = 0 ; i <  array.length ; i++){
            if(i == 6 || i == 9){
                continue;
            }
            answer = Math.max(answer, array[i]);
        }

        answer = Math.max(answer, (array[6] +array[9]+1)/2);
        System.out.println(answer);
    }
}
