package org.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFSFour {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static String[][] map;
    static int R;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        map = new String[R][C];


        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = split[j];
                if (map[i][j].equals("J")) {
                    q1.add(new int[]{i, j});
                }else if(map[i][j].equals("F")) {
                    q2.add(new int[]{i, j});
                }
            }
        }






    }
}
