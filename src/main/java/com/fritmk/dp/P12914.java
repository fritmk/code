package com.fritmk.dp;

/**
 * 멀리 뛰기
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */
public class P12914 {
    public long solution(int n) {

        long[] dp = new long[n+1];

        dp[1] = 1L;

        if(n > 1)
            dp[2] = 2L;

        for(int i = 3; i < n +1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}
