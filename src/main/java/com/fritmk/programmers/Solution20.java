package com.fritmk.programmers;


import java.util.HashMap;
/**
 * 할인 행사
 * 문제유형 : 해시
 * 난이도 : 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
public class Solution20 {

    public static void main(String[] args) {
        System.out.println(new Solution20().solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
            new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
        ));
    }

    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }


        HashMap<String, Integer> dc;
        int count;
        for (int i = 0; i < discount.length - 9; i++) { // discount start day
            dc = new HashMap<>();
            for (int idx = i; idx < i + 10; idx++) {
                dc.put(discount[idx], dc.getOrDefault(discount[idx], 0) + 1);
            }

            count = 0;
            for (String key : map.keySet()) {
                if ( map.get(key) <= dc.getOrDefault(key, 0)) {
                    count++;
                }
            }
            if (count == map.size()) {
                answer++;
            }
        }

        return answer;

    }

}
