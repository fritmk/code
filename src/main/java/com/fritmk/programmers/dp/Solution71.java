package com.fritmk.programmers.dp;

/**
 * 2xN 타일링
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12900
 */
public class Solution71  {

    public int solution(int n) {

        int[] result = new int[n+1];

        result[1] = 1;
        result[2] = 2;

        for(int i = 3; i <= n; i++) {
            result[i] = (result[i-1] + result[i-2]) % 1_000_000_007;
        }

        return result[n];
    }
}
