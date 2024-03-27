package org.Hash.lv1;
import java.util.*;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/131128
public class NumberPartner {


    public static void main(String[] args) {

        String X = "100";
        String Y = "2345";
        String solution = new NumberPartner().solution(X, Y);
        System.out.println("solution = " + solution);
    }


    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        for(String key: X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0)+1);
        }
        for(String key: Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0)+1);
        }

        for(String key: xMap.keySet()) {
            if(!yMap.containsKey(key)) continue;

            int length = Math.min(xMap.get(key), yMap.get(key));
            for(int i = 0; i < length; i++) {
                list.add(key);
            }
        }

        String result = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());

        if(result.isEmpty()) return "-1";
        if(result.replaceAll("0", "").isEmpty()) return "0";
        return result;
    }

    public String solution2(String X, String Y) {
        String answer = "";

        // 2 중 포문 x
        // 어떤 자료구조에 담아야 할까?
        // 해시에 각 x,y 의 숫자 갯수를 담아 진행

        String[] x = X.split("");
        String[] y = Y.split("");
        Map<String,Integer> xMap = new HashMap<>();
        Map<String,Integer> yMap = new HashMap<>();

        for(int i = 0 ; i < x.length ; i++){
            if(xMap.containsKey(x[i])){
                Integer num = xMap.get(x[i]);
                xMap.put(x[i],num+ 1);
            } else{
                xMap.put(x[i],1);
            }
        }

        for(int i = 0 ; i < y.length ; i++){
            if(yMap.containsKey(y[i])){
                Integer num = yMap.get(y[i]);
                yMap.put(y[i],num+ 1);
            } else{
                yMap.put(y[i],1);
            }
        }
        int maxSize ;
        if(x.length > y.length){
            maxSize = x.length;
        } else{
            maxSize = y.length;
        }
        List<String> a = new ArrayList<>(maxSize);
        for(int i = 0; i < x.length ; i++){

            if(yMap.containsKey(x[i])){
                Integer yCnt = yMap.get(x[i]);
                Integer xCnt = xMap.get(x[i]);
                if(xCnt >0 && yCnt >0){
                    xMap.put(x[i], xCnt-1);
                    yMap.put(x[i], yCnt-1);
                    a.add(x[i]);
                }
            }
        }
        Collections.sort(a);


        if(a.isEmpty()){
            return "-1";
        }

        StringBuilder br = new StringBuilder();
        for(int i = a.size() -1 ; 0<=i ;i--){
            String temp = a.get(i);

            if(temp.equals("0") && i == a.size() -1){
                return "0";
            }
            br.append(temp);
        }
        answer = br.toString();
        return answer;
    }
}
