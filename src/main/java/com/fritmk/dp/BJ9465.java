package com.fritmk.dp;

import java.util.Scanner;

/**
 * 스티커
 * 난이도: 실버1
 * https://www.acmicpc.net/problem/9465
 */
public class BJ9465 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while(n > 0) {

            int N = Integer.parseInt(sc.nextLine());
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String[] str1Arr = str1.split(" ");
            String[] str2Arr = str2.split(" ");

            long[][] arr  = new long[2][N+1];

            for(int i = 1; i <= N; i++) {
                arr[0][i] = Long.parseLong(str1Arr[i-1]);
                arr[1][i] = Long.parseLong(str2Arr[i-1]);
            }

            long[][] dp = new long[N+1][3]; // 케이스 - 미선택, 첫번째 열 선택, 두번째 열 선택
            dp[1][1] = arr[0][1];
            dp[1][2] = arr[1][1];

            for(int i= 2; i <= N; i++) {
                dp[i][0] = Math.max(Math.max( dp[i-1][0], dp[i-1][1] ), dp[i-1][2]);
                dp[i][1] = Math.max(dp[i-1][0] , dp[i-1][2])  + arr[0][i];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[1][i];
            }

            System.out.println( Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])) );
            n--;
        }

    }

}
