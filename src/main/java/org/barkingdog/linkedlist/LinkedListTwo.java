package org.barkingdog.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//https://www.acmicpc.net/problem/5397
public class LinkedListTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            int index = 0;
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < split.length; j++) {
                String string = split[j];
                if("<".equals(split[j])) {
                    if(index != 0){
                        index--;
                    }

                }else if(">".equals(split[j])) {
                    if(index != list.size()){
                        index++;
                    }
                }else if("-".equals(split[j])) {
                    if(index != 0) {
                        list.remove(index - 1);
                        index--;
                    }
                }else{
                    list.add(index,string);
                    index++;
                }

            }

            StringBuilder result = new StringBuilder();
            for (String a : list) {
                result.append(a);
            }
            System.out.println(result);
        }






    }
}

