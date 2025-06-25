package com.fritmk.dp;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 쉬운 계단 수
 * 난이도: 실버1
 * https://www.acmicpc.net/problem/10844
 * (TODO) 재귀로 풀어보기
 */
public class B10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        long[][] dp = new long[n+1][10]; // 자릿수의 길이, 자릿값
        for(int i = 1; i <=9; i++) {
            dp[1][i] = 1L;
        }

        for(int i = 2; i <= n; i++) { // 지랏수의 길이
            for(int j = 0; j < 10; j++) { // 지릿값
                if(j == 0){
                    dp[i][j] = dp[i-1][1] % 1_000_000_000;
                } else if(j == 9) {
                    dp[i][j] = dp[i-1][8] % 1_000_000_000;

                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
                }
            }
        }

        long result = 0;
        // 각 자릿값마다의 경우의 수를 모두 더해준다.
        for(int i = 0; i < 10; i++) {
            result += dp[n][i];
        }
        System.out.println(result % 1_000_000_000);
    }

}
