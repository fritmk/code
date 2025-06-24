package com.fritmk.programmers.dp;

/**
 * 땅따먹기
 * 난이도: 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 */
public class Solution73 {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];

        // 초기값 설정
        for(int i = 0 ; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for(int x = 1; x < land.length; x++) {
            for(int y = 0; y < 4; y++) {
                for(int z = 0; z < 4; z++) {
                    if(y != z) {
                        dp[x][y] = Math.max(dp[x][y], land[x][y] + dp[x-1][z]);
                    }
                }
            }
        }


        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length-1][i]);
        }

        return answer;
    }
}
