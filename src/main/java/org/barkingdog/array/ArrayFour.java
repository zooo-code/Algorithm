package org.barkingdog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//https://www.acmicpc.net/problem/10807
public class ArrayFour {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());
        int[] a = new int[201];

        for(String b : s){
            int i = Integer.parseInt(b);
            a[i+100]++;

        }
        System.out.println(a[v+100]);

    }
}
