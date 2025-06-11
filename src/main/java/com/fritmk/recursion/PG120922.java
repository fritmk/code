package com.fritmk.recursion;

import java.util.ArrayList;
/**
 * 종이 자르기
 * 난이도: 0
 * https://school.programmers.co.kr/learn/courses/30/lessons/120922
 */
public class PG120922 {

    private static ArrayList<Integer> list = new ArrayList<>();
    public int[] solution(int n) {
        recursion(n);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void recursion(int n) {

        list.add(n);

        if(n == 1) return;

        if(n % 2 == 0) {
            recursion(n / 2);
        } else {
            recursion(n * 3 + 1);
        }
    }

}
