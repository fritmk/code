package com.fritmk.programmers.dp;

/**
 * 피보나치 수
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
public class Solution70 {
    private static int[] dp;

    public int solution(int n) {


        dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        if(n == 0 || n == 1) {
            return dp[n];
        }

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n] % 1234567;

    }
}
