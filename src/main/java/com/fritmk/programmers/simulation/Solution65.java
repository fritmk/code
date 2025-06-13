package com.fritmk.programmers.simulation;

/**
 * 점프와 순간 이동
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */
public class Solution65 {
    public int solution(int n) {
        return Integer.toBinaryString(n).replace("0", "").length();
    }
}
