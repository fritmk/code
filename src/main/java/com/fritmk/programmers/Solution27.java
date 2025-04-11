package com.fritmk.programmers;

import java.util.HashMap;

/**
 * 다단계 칫솔 판매
 * 문제 유형: 트리
 * 난이도: 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/77486
 * 메모: 재귀 써야함
 */

import java.util.HashMap;


class Solution27  {

    private static HashMap<String, String> people = new HashMap<>();
    private static HashMap<String, Integer> result = new HashMap<>(); // 이익 (result)
    // private HashMap<String, Integer> sell = new HashMap<>(); // seller - 판매금액


    public static void main(String[] args) {
        int[] result = new Solution27().solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
                );
        for(int r : result) {
            System.out.println(r);
        }


    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {


        int[] answer = new int[enroll.length];

        for(int i = 0; i < enroll.length; i++) {
            result.put(enroll[i], 0);
            result.put("-", 0);
            people.put(enroll[i], referral[i]);
        }

        for(int i = 0; i < seller.length; i++) {
            calculate(seller[i], amount[i] * 100);
        }


        for(int i = 0;  i < enroll.length; i++) {
            answer[i] = result.get(enroll[i]);
        }


        return answer;
    }

    public static void calculate(String name, int price) {

        if (name.equals("-")) return;

        if(price / 10 < 1) {
            result.put(name, result.getOrDefault(name, 0) + price);
        } else {
            result.put(name, result.getOrDefault(name, 0) + (price - (price / 10)) );
            calculate(people.get(name), price / 10);
        }

    }

    }