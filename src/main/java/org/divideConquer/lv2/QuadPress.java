package org.divideConquer.lv2;

//https://school.programmers.co.kr/learn/courses/30/lessons/68936
// 시간 20 분 고민 후 해결 불가 -> 분할 정복 개념 습득 문제를 쪼개서 생각하자.
// 같은 작업이 반복된다.
public class QuadPress {
    public static void main(String[] args) {

    }
    static int[] answer;
    public static class Solution {

        public boolean check(int[][] arr, int x, int y, int size, int val) {
            for(int i = x; i < x + size; i++)
                for(int j = y; j < y + size; j++)
                    if(arr[i][j] != val)
                        return false;
            return true;
        }
        public void quad(int[][] arr, int x, int y, int size){
            if(check(arr,x,y,size, arr[x][y])){
                if(arr[x][y] == 1)
                    answer[1]++;
                else answer[0]++;
                return ;
            }
            quad(arr,x,y, size/2);
            quad(arr,x,y + size/2, size/2);
            quad(arr,x+size/2,y, size/2);
            quad(arr,x+size/2,y + size/2, size/2);
        }
        public int[] solution(int[][] arr) {
            answer = new int[2];
            quad(arr,0,0,arr.length);
            return answer;
        }
    }
}
