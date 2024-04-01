import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String[] args) {

        String s = "hElLo";
        char[] charArray = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(char c : charArray){
            if(Character.isLowerCase(c)){
                char a = Character.toUpperCase(c);
                sb.append(a);
            }else{
                char a = Character.toLowerCase(c);
                sb.append(a);
            }
        }
        System.out.println("sb = " + sb);


        int[] score = {1,4,53,76,3,342,4,6,623,43};

        Arrays.sort(score);
        List<Integer> a = new ArrayList<>();
        Collections.sort(a);

        System.out.println("Arrays.toString(score) = " + Arrays.toString(score));
    }
}
