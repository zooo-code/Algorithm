package org.barkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2577
public class arrayTwo {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(br.readLine());

        long b = Long.parseLong(br.readLine());
        long c = Long.parseLong(br.readLine());

        long d = a *b *c;
        String s = String.valueOf(d);
        char[] charArray  = s.toCharArray();
        int[] array = new int[10];

        for (char value : charArray) {
            array[value - '0']++;
        }
        for (int i : array) {
            System.out.println( i);
        }

    }
}
