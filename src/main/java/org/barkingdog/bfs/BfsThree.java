package org.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//https://www.acmicpc.net/problem/7576
public class BfsThree {

    static int[][] maps;
    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] mn = br.readLine().split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);
        maps = new int[n][m];
        // 상자에 토마토를 담는다.
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++) {
                maps[i][j] = Integer.parseInt(line[j]);
                if(maps[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int bfs = bfs(q);
        System.out.println( bfs);
    }

    public static int bfs( Queue<int[]> q) {

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx][ny] == 0 ) {
                    maps[nx][ny] = maps[x][y] +1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        if (checkZero()) {
            return -1;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (max < maps[i][j]) {
                        max = maps[i][j];
                    }
                }
            }

            return max - 1;
        }


    }

    private static boolean checkZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
}
