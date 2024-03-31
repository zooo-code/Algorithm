package org.Implement.lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/136798
// 구현인데 생각 방법이 좀 독특..?
// 이거 풀려면 약수 개수 구하는 법좀 생각해야할듯?
public class NightWeapon {


    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;
        NightWeapon nightWeapon = new NightWeapon();
        int solution = nightWeapon.solution(number, limit, power);
        System.out.println(solution);
    }
    public int solution(int number, int limit, int power) {
        int answer = 0;
        String test = new String("test");

        String upperCase = test.toUpperCase();
        System.out.println("upperCase = " + upperCase);
        char[] a  = upperCase.toCharArray();



        for (int i = 1 ; i <= number ; i++){
            int cnt = 0;
            //num이 16일 경우 약수는 1, 2, 4, 8, 16
            //합성수의 특징에 따라
            //16의 제곱근인 4 전까지는 약수의 개수가 하나 더 있음이 보장
            //따라서 for문은 i가 제곱근일때 까지 반복
            for (int j= 1 ; j*j <= i ; j++){
                // 제곱근 일때는 1개 더하고
                if (j*j ==i ){
                    cnt++;
                    // 제곱 근 전까지는 아니면 2개 더하고 원래 약수는 짝을 이루니..
                }else if(i%j == 0) {
                    cnt+=2;
                }
            }
            if (cnt > limit){
                cnt = power;
            }
            answer+= cnt;
        }
        return answer;
    }
}
