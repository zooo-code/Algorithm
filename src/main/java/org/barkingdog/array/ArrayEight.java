package org.barkingdog.array;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/11328
public class ArrayEight {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n ; i++) {
            int[] alpha = new int[26];

            String[] split = br.readLine().split(" ");
            String s = split[0];
            String s1 = split[1];

            char[] charArray = s.toCharArray();
            char[] charArray1 = s1.toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                alpha[charArray[j] - 'a']++;
            }
            boolean flag = true;
            for (int j = 0; j < charArray1.length; j++) {

                alpha[charArray1[j] - 'a']--;
            }

            for (int a: alpha){
                if(a != 0){
                    flag = false;
                }
            }

            if(flag){
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }

        }

    }

}
