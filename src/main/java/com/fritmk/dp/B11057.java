package com.fritmk.dp;

import java.util.Scanner;

/**
 * 오르막수
 * 난이도: 실버1
 * https://www.acmicpc.net/problem/11057
 */
public class B11057 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        long[][] dp = new long[n+1][10]; // dp[i][j]는 길이가 i이고, 첫 자릿수가 j인 오르막 수의 개수

        // 초기화
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int z = j; z < 10; z++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][z]) % 10_007;
                }
            }
        }

        long result = 0L;
        for(int i = 0; i < 10; i++) {
            result += dp[n][i];
        }

        System.out.println(result % 10_007);

    }
}
