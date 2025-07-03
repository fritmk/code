package com.fritmk.dp;

import java.util.Scanner;

/**
 * 이친수
 * 난이도: 실버3
 * https://www.acmicpc.net/submit/2193/95897739
 */
public class BJ2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        long[][] dp = new long[n+1][2];

        dp[1][0] = 0;
        dp[1][1] = 1L;

        for(int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }


        System.out.println((dp[n][0] + dp[n][1]));

    }
}
