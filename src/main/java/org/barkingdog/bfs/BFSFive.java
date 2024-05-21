package org.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/1697
public class BFSFive {

    static int[] check = new int[100001];
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }
    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int nx;

                if (i == 0) {
                    nx = temp + 1;
                } else if (i == 1) {
                    nx = temp - 1;
                } else {
                    nx = temp * 2;
                }

                if (nx == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if (nx >= 0 && nx < check.length && check[nx] == 0) {
                    q.add(nx);
                    check[nx] = check[temp] + 1;
                }
            }
        }
    }
}
