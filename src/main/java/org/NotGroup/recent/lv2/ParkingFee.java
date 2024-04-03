package org.NotGroup.recent.lv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=java
//30분 풀이후 포기

public class ParkingFee {

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // IN을 위한 Map
        Map<String, Integer> map1 = new HashMap<>();
        // OUT 을 위한 Map
        Map<String, Integer> map2 = new HashMap<>();

        //car 의 번호를 담는다.
        Set<String> carInfo = new HashSet<>();

        int baseTime = fees[0];
        int baseFee = fees[1];
        int partTime = fees[2];
        int partFee = fees[3];

        for (String record : records) {
            String[] tmp = record.split(" ");
            int time = getRealTime(tmp[0]);
            String car = tmp[1];
            String io = tmp[2];
            carInfo.add(car);
            // 들어오는 경우 나가는 경우 구분
            if (io.equals("IN")) {
                map1.put(car, time);

            // 나가는 경우
            } else {

                int carTime1 = map1.get(car);
                map1.remove(car);
                if (map2.containsKey(car)) {
                    int carTime2 = map2.get(car);
                    map2.replace(car, carTime2 + time - carTime1);
                } else {
                    map2.put(car, time - carTime1);
                }
            }
        }
        // 이제 시간을 계산하자.
        int lastTime = 1439;

        for (String car : map1.keySet()) {
            int carTime1 = map1.get(car);
            if (map2.containsKey(car)) {
                int carTime2 = map2.get(car);
                map2.replace(car, carTime2 + lastTime - carTime1);
            } else {
                map2.put(car, lastTime - carTime1);
            }
        }
        int cnt = 0;
        String[] carArray = new String[carInfo.size()];
        for (String car : carInfo) {
            carArray[cnt] = car;
            cnt++;
        }
        Arrays.sort(carArray);
        // System.out.println(Arrays.toString(carArray));

        answer = new int[carArray.length];

        for (int i = 0; i<answer.length; i++) {
            int result = baseFee;
            String car = carArray[i];

            int val = map2.get(car);
            if (val > baseTime) {
                result = (int) (baseFee + Math.ceil((double)(val-baseTime)/partTime) * partFee);
            }
            answer[i] = result;
        }

        return answer;
    }


    public int getRealTime(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int minute = Integer.parseInt(tmp[1]);
        return hour + minute;
    }
}
