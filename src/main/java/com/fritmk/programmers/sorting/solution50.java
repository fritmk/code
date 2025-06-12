package com.fritmk.programmers.sorting;

/**
 * 계수 정렬 구현하기
 */
public class solution50 {

    public static void main(String[] args) {

        int[] list = new int[26];
        String s = "algorithm";

        for(int i = 0; i < s.length(); i++) {
            list[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(list[i] > 0) {
                while(list[i] > 0) {
                    result.append((char) (i + 'a'));
                    list[i]--;
                }
            }
        }

        System.out.println(result);
    }


}
