package org.barkingdog.linkedlist;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/1406
public class LinkedListOne {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] split = s.split("");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(split));


        int m = Integer.parseInt(br.readLine());
        int index = s.length();

        for (int i = 0; i < m; i++) {
            String[] a = br.readLine().split(" ");

            if(a[0].equals("P")) {
                String s1 = a[1];
                list.add(index,s1);
                index++;
            }else if(a[0].equals("D")){
                if(index != list.size()) {
                    index++;
                }
            }else if(a[0].equals("L")){
                if(index != 0) {
                    index--;
                }
            }else{
                if(index > 0){
                    index -=1;
                    list.remove(index);
                }

            }
        }

        System.out.println(String.join("", list));

    }
}
