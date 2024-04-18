package org.barkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1919
public class ArrayFive {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s1 = br.readLine();
        char[] split = s.toCharArray();
        char[] split1 = s1.toCharArray();
        int[] one = new int[26];
        int[] two = new int[27];

        int answer = 0;

        for(int i = 0; i < split.length; i++) {
            one[split[i] - 'a']++;
        }

        for(int i = 0; i < split1.length; i++) {
            two[split1[i] - 'a']++;
        }

        for(int i = 0 ; i < 27; i++){
            if(one[i] != two[i]){
                answer += Math.abs(one[i] - two[i]);
            }
        }
        System.out.println( answer);
    }
}
