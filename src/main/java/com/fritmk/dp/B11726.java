package com.fritmk.dp;

import java.util.Scanner;

/**
 * 2xN 타일링
 * 난이도: 실버3
 * https://www.acmicpc.net/problem/11726
 */
public class B11726 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //
        int[] dp = new int[n + 1]; // 2×n 직사각형을 채우는 경우의 수

        // 초기값
        dp[1] = 1;
        dp[2] = 2;


        for(int i = 3; i < n+1; i++) {
            dp[i] = ( dp[i-1] + dp[i-2] ) % 10_007; // 세로를 채우고 남은 공간의 경우의 수 (dp[n-1]), 가로 두개를 채우고 남은 공간의 경우의 수 (dp[n-2])
        }

        System.out.println(dp[n]);

    }
}
