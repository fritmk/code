package com.fritmk.programmers.dp;

/**
 * 조약돌 문제
 * 난이도: 3
 */
public class Solution69 {

    private static int solution(int[][] arr) {
        int n = arr[0].length;
        int[][] dp = new int[4][n];

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[2][0] = arr[2][0];
        dp[3][0] = arr[0][0] + arr[2][0];

        for(int i = 1; i < n; i++) {
            dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], dp[2][i-1]);
            dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], Math.max(dp[2][i-1], dp[3][i-1]));
            dp[2][i] = arr[2][i] + Math.max(dp[0][i-1], dp[1][i-1]);
            dp[3][i] = arr[0][i] + arr[2][i] + dp[1][i-1];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 4; i++) {
            if(max < dp[i][n-1]) {
                max = dp[i][n-1];
            }
        }
        return max;
    }

}
