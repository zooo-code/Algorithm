package org.barkingdog.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//https://www.acmicpc.net/problem/10808
public class ArrayOne {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] charArray = input.toCharArray();
        int[] intArray = new int[26];

        for(char c : charArray) {
            intArray[c-'a']++;
        }
        for(int i = 0 ; i < intArray.length ; i++){

            System.out.print(intArray[i] + " ");
        }


    }
}
