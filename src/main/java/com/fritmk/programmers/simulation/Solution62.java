package com.fritmk.programmers.simulation;

/**
 * 이진 변환 반복하기
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class Solution62 {

    private static int[] solution(String s) {
        int count = 0;
        int zero = 0;
        while(!s.equals("1")) {
            count++;
            zero += s.replace("1","").length();
            s = getBinary(s.replace("0", "").length());
        }
        return new int[]{count, zero};
    }


    public static String getBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }


}
