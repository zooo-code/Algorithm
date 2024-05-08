package org.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfsOne {


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n ;
    static int m ;

    static int artCnt = 0;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        int[][] map = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            String[] split1 = br.readLine().split(" ");

            for(int j = 0 ; j < m ; j++) {
                map[i][j] = Integer.parseInt(split1[j]);
            }
        }

        int answer = 0;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(map[i][j] == 1) {
                    int temp = bfs(map, i, j);
                    answer = Math.max(temp,answer );
                }

            }
        }
        System.out.println(artCnt);
        System.out.println(answer);


    }

    public static int bfs(int[][] map, int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start,end});
        map[start][end] = 0;
        int count = 1;
        artCnt++;
        while(!queue.isEmpty()) {
            int[] s = queue.poll();
            int x = s[0];
            int y = s[1];

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0<= nx && nx <n && 0<= ny && ny < m &&  map[nx][ny] == 1 ){
                    map[nx][ny] = 0;

                    queue.add(new int[] {nx, ny});
                    count++;
                }
            }

        }
        return count;

    }
}
