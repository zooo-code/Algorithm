package org.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BfsTwo {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        int[][] map  =  new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split1 = br.readLine().split("");
            for (int j = 0; j < split1.length; j++) {
                map[i][j] = Integer.parseInt(split1[j]);
            }
        }
        int answerMap = bfs(map);

        System.out.print(answerMap);

    }


    public static int bfs(int[][] maps){
        int[] start = {0,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0<= nx && nx < n && 0<= ny && ny < m && maps[nx][ny]!=0){

                    if(maps[nx][ny]==1){
                        maps[nx][ny] = maps[x][y] +1;
                        queue.offer(new int[]{nx, ny});
                    }

                }
            }

        }
        return maps[n-1][m-1];
    }
}
