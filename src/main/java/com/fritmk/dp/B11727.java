package com.fritmk.dp;

import java.util.Scanner;

/**
 * 2×n 타일링 2
 * 난이도: 실버3
 * https://www.acmicpc.net/problem/11727
 */
public class B11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int[] dp = new int[n+1];

        dp[1] = 1;
        if(n >=2)
            dp[2] = 3;

        for(int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i-1] + (2 * dp[i-2]) ) % 10_007;
        }

        System.out.println(dp[n]);
    }
}
