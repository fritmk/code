package com.fritmk.dp;

import java.util.Scanner;

/**
 * 1,2,3 더하기
 * 난이도: 실버3
 * https://www.acmicpc.net/problem/9095
 */
public class B9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while(count > 0) {
            count--;
            int n = sc.nextInt();
            for(int i = 4; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            System.out.println(dp[n]);

        }
        sc.close();
    }
}
