package org.NotGroup.algo.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/12948

import java.util.LinkedHashSet;

public class HidePhoneNumber {


    public static void main(String[] args) {

        String phone_number = "01033334444";

        String solution = new HidePhoneNumber().solution(phone_number);
        System.out.println("solution = " + solution);
    }

    public String solution(String phone_number) {

        char[] charArray = phone_number.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int length = charArray.length;
        for (int i = 0; i < length ;i++){
            if (i < length -4){
                stringBuilder.append("*");
            } else{
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }



    public static class RemoveDuplicates {
        public static String removeDuplicates(String str) {
            // LinkedHashSet을 사용하여 중복을 제거하고 입력된 문자열의 순서를 유지합니다.
            LinkedHashSet<Character> set = new LinkedHashSet<>();

            // 문자열을 문자 단위로 반복하여 중복을 제거합니다.
            for (int i = 0; i < str.length(); i++) {
                set.add(str.charAt(i));
            }

            // LinkedHashSet의 요소를 이어붙여 새로운 문자열을 생성합니다.
            StringBuilder sb = new StringBuilder();
            for (Character ch : set) {
                sb.append(ch);
            }

            return sb.toString();
        }

        public static void main(String[] args) {
            String input = "banana";
            System.out.println("Original string: " + input);
            System.out.println("After removing duplicates: " + removeDuplicates(input));
        }
    }

}
