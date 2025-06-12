package com.fritmk.programmers.sorting;
import java.util.Arrays;
/**
 * 문자열 내 마음대로 정렬하기
 * 난이도: 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */
public class Solution52 {

    public String[] solution(String[] strings, int n) {
        String[] answer = {};

        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2. charAt(n) ?
                o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n))); // o1 - o2 : 음수면 o1가 앞에

        return strings;
    }


}
